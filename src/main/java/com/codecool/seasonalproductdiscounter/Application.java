package com.codecool.seasonalproductdiscounter;

import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProviderImpl;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountService;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountServiceImpl;
import com.codecool.seasonalproductdiscounter.service.products.ProductProviderImpl;
import com.codecool.seasonalproductdiscounter.ui.SeasonalProductDiscounterUi;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        var productProvider = new ProductProviderImpl();
        DiscountProvider discountProvider = new DiscountProviderImpl();
        DiscountService discounterService = new DiscountServiceImpl();
        var ui = new SeasonalProductDiscounterUi(productProvider, discountProvider, discounterService);
        ui.run();
    }
}
