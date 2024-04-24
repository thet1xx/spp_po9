package org.example;

// конкретная стратегия для проезда
public class TransportationStrategy implements TourPackageBuilder{

    @Override
    public int calculateCost() {
        return 100;
    }
}
