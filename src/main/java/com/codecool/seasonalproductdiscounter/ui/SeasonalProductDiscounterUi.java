package com.codecool.seasonalproductdiscounter.ui;

import com.codecool.seasonalproductdiscounter.model.discounts.Discount;
import com.codecool.seasonalproductdiscounter.model.offers.Offer;
import com.codecool.seasonalproductdiscounter.model.products.Product;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountProvider;
import com.codecool.seasonalproductdiscounter.service.discounts.DiscountService;
import com.codecool.seasonalproductdiscounter.service.products.ProductProvider;
import com.codecool.seasonalproductdiscounter.service.products.ProductProviderImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeasonalProductDiscounterUi {
    private final ProductProvider productProvider;
    private final DiscountProvider discountProvider;
    private final DiscountService discountService;
    private final Scanner scanner;

    public SeasonalProductDiscounterUi(
            ProductProvider productProvider,
            DiscountProvider discountProvider,
            DiscountService discounterService) {
        this.productProvider = productProvider;
        this.discountProvider = discountProvider;
        this.discountService = discounterService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to Seasonal Product Discounter!\n");
        System.out.println("Products List: ");
        printCatalog();
        System.out.println("------------------------------------------------");

        System.out.println("Promotions List: ");
        printPromotions();
        System.out.println("------------------------------------------------");

        System.out.println("Enter a date to see which products are discounted on that date:");
        LocalDate date = getDate();
        System.out.println();

        printOffers(date, getOffers(date));
    }

    public LocalDate getDate() {
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid input");
            }
        }
    }

    private void printCatalog() {
        List products = new ProductProviderImpl().getProducts();
        for (Object product :
                products) {
            System.out.println(product.toString());
        }
    }

    private void printPromotions() {
        System.out.println("All possible Promotions: ");
        for (Discount discount :
                discountProvider.getDiscounts()) {
            System.out.println(discount + "; ");
        }
    }

    private void printOffers(LocalDate date, List<Offer> offers) {
        for (Offer offer : offers
        ) {
            System.out.println("Available discounts for " + offer.product().name() + " for " + offer.product().season() + " season" + ':');
            for (Discount discount : offer.discounts()
            ) {
                System.out.println(discount.name());
            }
            System.out.println("% DISCOUNTED PRICE: " + offer.price());
            System.out.println("------------------------------------------------");
        }
    }

    private List<Offer> getOffers(LocalDate date) {
        List<Offer> discounted = new ArrayList<>();

        for (Product product : productProvider.getProducts()) {
            Offer offer = discountService.getOffer(product, date);
            if (!offer.discounts().isEmpty()) {
                discounted.add(offer);
            }
        }

        return discounted;
    }
}

