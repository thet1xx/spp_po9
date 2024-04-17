package org.example;

import java.util.ArrayList;
import java.util.List;

    class FlightCrew {

        public String getPosition() {
            return position;
        }

        private String name;
        private String position;

        public FlightCrew(String name, String position) {
            this.name = name;
            this.position = position;
        }

        public String getName() {
            return name;
        }

    }

    class Aircraft {
        private int seatingCapacity;
        private int flightRange;

        public Aircraft(int seatingCapacity, int flightRange) {
            this.seatingCapacity = seatingCapacity;
            this.flightRange = flightRange;
        }
    }

    class Flight {
        private String flightNumber;
        private Airport departureAirport;
        private Airport destinationAirport;
        private boolean isCanceled;
        private Aircraft aircraft;
        private List<FlightCrew> flightCrew;

        public Flight(String flightNumber, Airport departureAirport, Airport destinationAirport, Aircraft aircraft) {
            this.flightNumber = flightNumber;
            this.departureAirport = departureAirport;
            this.destinationAirport = destinationAirport;
            this.aircraft = aircraft;
            this.isCanceled = false;
            this.flightCrew = new ArrayList<>();
        }

        public void addFlightCrewMember(FlightCrew crewMember) {
            flightCrew.add(crewMember);
        }

        public void setDestinationAirport(Airport newDestination) {
            this.destinationAirport = newDestination;
        }

        public void cancelFlight() {
            this.isCanceled = true;
        }

        public List<FlightCrew> getFlightCrew() {
            return flightCrew;
        }

        public Airport getDepartureAirport() {
            return departureAirport;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public boolean isCanceled() {
            return isCanceled;
        }

        public void setCanceled(boolean canceled) {
            this.isCanceled = canceled;
        }

        public Airport setDestinationAirport() {
            return  destinationAirport;
        }

    }

    class Airport {
        private String name;
        private String location;

        public Airport(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public String getName() {
            return name;

        }
    }

    class Administrator {
        public void formFlightCrew(Flight flight, List<FlightCrew> crewMembers) {
            for (FlightCrew crewMember : crewMembers) {
                flight.addFlightCrewMember(crewMember);
            }
        }

        public void changeDestinationAirport(Flight flight, Airport newDestination) {
            flight.setDestinationAirport(newDestination);
        }

        public void cancelFlight(Flight flight) {
            flight.cancelFlight();
        }
    }

