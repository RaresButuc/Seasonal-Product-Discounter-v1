package com.codecool.seasonalproductdiscounter.model.enums;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

public enum Season {
    SPRING(Set.of(Month.MARCH, Month.APRIL, Month.MAY)),
    SUMMER(Set.of(Month.JUNE, Month.JULY, Month.AUGUST)),
    AUTUMN(Set.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER)),
    WINTER(Set.of(Month.DECEMBER, Month.JANUARY, Month.FEBRUARY));

    private final Set<Month> months;

    Season(Set<Month> months) {
        this.months = months;
    }

    public Set<Month> getMonths() {
        return months;
    }

    public boolean contains(LocalDate date) {
        Month month = date.getMonth();
        if (Season.this.getMonths().contains(month)) {
            return true;
        }
        return false;
    }

    public Season shift(int amount) {
        Integer howManyOver = amount + 1;
        Integer firstCycle = (this.ordinal() + howManyOver) > Season.values().length ?
                (this.ordinal() + howManyOver) - Season.values().length : this.ordinal() + howManyOver;
        Integer secondCycle = firstCycle >= Season.values().length ? firstCycle - Season.values().length : null;
        if (secondCycle == null) {
            return Season.values()[firstCycle];
        }
        return Season.values()[secondCycle];
    }

}
