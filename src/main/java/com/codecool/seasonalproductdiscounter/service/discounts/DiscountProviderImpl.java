package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.discounts.ColorDiscount;
import com.codecool.seasonalproductdiscounter.model.discounts.Discount;
import com.codecool.seasonalproductdiscounter.model.discounts.MonthlyDiscount;
import com.codecool.seasonalproductdiscounter.model.discounts.SeasonalDiscount;
import com.codecool.seasonalproductdiscounter.model.enums.Season;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class DiscountProviderImpl implements DiscountProvider {
    private final List<Discount> discounts;

    public DiscountProviderImpl() {
        discounts = List.of(
                new ColorDiscount("Blue Winter", 5,Season.WINTER),
                new ColorDiscount("Green Spring", 5,Season.SPRING),
                new ColorDiscount("Yellow Summer", 5,Season.SUMMER),
                new ColorDiscount("Brown Autumn", 5,Season.AUTUMN),
                new MonthlyDiscount("Summer Kick-off", 10,List.of(Month.JUNE,Month.JULY)),
                new MonthlyDiscount("Winter Sale", 10,List.of(Month.FEBRUARY)),
                new SeasonalDiscount("Sale Discount", 10,"NEXT"),
                new SeasonalDiscount("Outlet Discount", 20,"AFTER NEXT")
        );
    }

    @Override
    public List<Discount> getDiscounts() {
        return discounts;
    }
}
