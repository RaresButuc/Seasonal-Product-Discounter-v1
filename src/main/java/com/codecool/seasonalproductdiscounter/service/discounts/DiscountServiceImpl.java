package com.codecool.seasonalproductdiscounter.service.discounts;

import com.codecool.seasonalproductdiscounter.model.discounts.Discount;
import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    @Override
    public Offer getOffer(Product product, LocalDate date) {
        List<Discount> allDiscounts = new DiscountProviderImpl().getDiscounts();
        List<Discount> applicableDiscounts = new LinkedList<>();
        double newPrice = product.price();
        for (Discount eachDis : allDiscounts) {
            if (eachDis.accepts(product, date)) {
                applicableDiscounts.add(eachDis);
                newPrice = newPriceDisc(newPrice, eachDis.rate());
            }
        }
        return new Offer(product, date, applicableDiscounts, Double.parseDouble(new DecimalFormat("##.####").format(newPrice)));
    }

    public double newPriceDisc(double price, double disc) {
        return price * ((100 - disc) / 100);
    }

    ;

    private void printDiscounts(List<Discount> discounts) {
        for (Discount discount :
                discounts) {
            System.out.println(discount.name());
        }
    }
}
