package com.codecool.seasonalproductdiscounter.model.discounts;

import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public record MonthlyDiscount(String name, int rate, List<Month> months) implements Discount {
    @Override
    public boolean accepts(Product product, LocalDate date) {
        for (Month month : months
        ) {
            return date.getMonth().equals(month);
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
        return name + " discount APPLIED- " + rate + "% off ";
    }
}
