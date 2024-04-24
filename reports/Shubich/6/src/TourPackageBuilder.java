package org.example;

public class TourPackageBuilder {
    private TourPackageStrategy transportationStrategy;
    private TourPackageStrategy accommodationStrategy;

    public void setTransportationStrategy(TourPackageStrategy transportationStrategy) {
        this.transportationStrategy = transportationStrategy;
    }

    public void setAccommodationStrategy(TourPackageStrategy accommodationStrategy) {
        this.accommodationStrategy = accommodationStrategy;
    }

    public int calculateTotalCost() {
        int transportationCost = transportationStrategy.calculateCost();
        int accommodationCost = accommodationStrategy.calculateCost();
        return transportationCost + accommodationCost;
    }
}