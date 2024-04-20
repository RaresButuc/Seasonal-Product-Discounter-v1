package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;

public record ColorDiscount(String name, int rate, Season season) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        if (product.season().equals(Season.WINTER) && product.color().equals(Color.BLUE) && product.season().getMonths().contains(date.getMonth()) && season.equals(Season.WINTER)) {
            return true;
        } else if (product.season().equals(Season.SPRING) && product.color().equals(Color.GREEN) && product.season().getMonths().contains(date.getMonth()) && season.equals(Season.SPRING)) {
            return true;
        } else if (product.season().equals(Season.SUMMER) && product.color().equals(Color.YELLOW) && product.season().getMonths().contains(date.getMonth()) && season.equals(Season.SUMMER)) {
            return true;
        } else if (product.season().equals(Season.AUTUMN) && product.color().equals(Color.BROWN) && product.season().getMonths().contains(date.getMonth()) && season.equals(Season.AUTUMN)) {
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
