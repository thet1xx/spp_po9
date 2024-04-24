package org.example;

public class TourPackage {
    private TourPackageStrategy transportationStrategy;
    private TourPackageStrategy accommodationStrategy;
    private int totalCost;

    public TourPackage(TourPackageBuilder builder) {
        this.transportationStrategy = builder.transportationStrategy;
        this.accommodationStrategy = builder.accommodationStrategy;
        this.totalCost = builder.calculateTotalCost();
    }

    public TourPackageStrategy getTransportationStrategy() {
        return transportationStrategy;
    }

    public TourPackageStrategy getAccommodationStrategy() {
        return accommodationStrategy;
    }

    public int getTotalCost() {
        return totalCost;
    }
}