package com.codecool.seasonalproductdiscounter.model.products;

import com.codecool.seasonalproductdiscounter.model.enums.Color;
import com.codecool.seasonalproductdiscounter.model.enums.Season;

import java.time.Month;


public record Product(String name, Color color, Season season, double price) {

    public double newPriceDisc(double price, double disc) {
        return price * disc;
    }

    public Product newProduct(double newPrice) {
        return new Product(this.name, this.color, this.season, newPrice);
    }

    ;

    @Override
    public String toString() {
        return name +
                ", color= " + color +
                ", season= " + season +
                ", price= " + price +
                '}';
    }
}

