package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Payment myPayment = new Payment();
        myPayment.addProduct("Apple", 3.24);
        myPayment.addProduct("Banana", 6.21);
        myPayment.addProduct("Peach", 5.99);

        myPayment.showBill();
        double totalAmount = myPayment.getTotalAmount();
        System.out.println("Total amount: "+ totalAmount);

        // ------------

        Star star = new Star();
        star.setStar("Sun");
        Planet[] planets = {new Planet("Earth", true),new Planet("Mars", true), new Planet("Venus", false)};
        StarWay starWay = new StarWay(planets, star);

        System.out.println();
        starWay.getSystem();
        System.out.println();
        starWay.planetLive();
        System.out.println();
        starWay.starMethods();

        // ------
        System.out.println("---------");

        Airport departureAirport = new Airport("Start Airport", "City A");
        Airport destinationAirport = new Airport("Destination Airport", "City B");

        Aircraft aircraft = new Aircraft(200, 1000);


        Flight flight = new Flight("JJJJ123", departureAirport, destinationAirport, aircraft);


        FlightCrew pilot1 = new FlightCrew("Ovodok Vadim", "Pilot");
        FlightCrew pilot2 = new FlightCrew("Shubich Darya", "Pilot");
        FlightCrew navigator = new FlightCrew("Dmitry Solyshko", "Navigator");
        FlightCrew radioOperator = new FlightCrew("Zakhar Kharitanovich", "Radio Operator");
        FlightCrew flightAttendant1 = new FlightCrew("Dmitry Stupak", "Flight Attendant");
        FlightCrew flightAttendant2 = new FlightCrew("Vlad Melnichuk", "Flight Attendant");


        Administrator administrator = new Administrator();


        List<FlightCrew> crewMembers = Arrays.asList(pilot1, pilot2, navigator, radioOperator, flightAttendant1, flightAttendant2);
        administrator.formFlightCrew(flight, crewMembers);


        Airport newDestination = new Airport("Finish Airport", "City C");
        administrator.changeDestinationAirport(flight, newDestination);


        administrator.cancelFlight(flight);


        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("Departure Airport: " + flight.getDepartureAirport().getName());
        System.out.println("Destination Airport: " + flight.setDestinationAirport().getName());

        System.out.println("Flight Crew:");
        for (FlightCrew crewMember : flight.getFlightCrew()) {
            System.out.println("- " + crewMember.getName() + ", " + crewMember.getPosition());
        }
        flight.setCanceled(false);
        System.out.println("Flight Status: " + (flight.isCanceled() ? "Canceled" : "On Schedule"));
    }
    }
