package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.enums.Season;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;

public record SeasonalDiscount(String name, int rate, String whichSeason) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        Season productSeason = product.season();
        if (productSeason.shift(0).contains(date) && whichSeason.equals("NEXT") || productSeason.shift(2).contains(date) && whichSeason.equals("NEXT")) {
            return true;
        } else if (productSeason.shift(1).contains(date) && whichSeason.equals("AFTER NEXT")) {
            return true;
        }
        return false;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int rate() {
        return rate;
    }

    @Override
    public String toString() {
        return name + " discount APPLIED - " + rate + "% off ";
    }
}
