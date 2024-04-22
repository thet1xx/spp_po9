import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightManager flightManager = new FlightManager();
        try {
            flightManager.loadFlightsFromFile("/Users/greendal/IdeaProjects/SPPLab3-2/src/flights.txt");

            List<Flight> flightsToLondon = flightManager.getFlightsByDestination("London");
            System.out.println("Flights to London:");
            for (Flight flight : flightsToLondon) {
                System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
            }

            List<Flight> mondayFlights = flightManager.getFlightsByDay("Monday");
            System.out.println("\nFlights on Monday:");
            for (Flight flight : mondayFlights) {
                System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date departureTimeThreshold = dateFormat.parse("2024-04-02 12:00");
            List<Flight> mondayAfternoonFlights = flightManager.getFlightsByDayAndTime("Monday", departureTimeThreshold);
            System.out.println("\nMonday flights after 12:00:");
            for (Flight flight : mondayAfternoonFlights) {
                System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
            }

            List<Flight> boeingFlights = flightManager.getFlightsByAircraftType("Boeing 737");
            System.out.println("\nBoeing 737 flights:");
            for (Flight flight : boeingFlights) {
                System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
            }

            List<List<Flight>> groupedFlights = flightManager.groupFlightsByPassengerCapacity();
            System.out.println("\nGrouped flights by passenger capacity:");
            System.out.println("Small capacity flights:");
            for (Flight flight : groupedFlights.get(0)) {
                System.out.print(flight.getFlightNumber() + " - " + flight.getDepartureTime() + " - ");
                System.out.println("Passenger capacity = " + flight.calculatePassengerCapacity(flight.getAircraftType()));
            }
            System.out.println("\nMedium capacity flights:");
            for (Flight flight : groupedFlights.get(1)) {
                System.out.print(flight.getFlightNumber() + " - " + flight.getDepartureTime() + " - ");
                System.out.println("Passenger capacity = " + flight.calculatePassengerCapacity(flight.getAircraftType()));
            }
            System.out.println("\nLarge capacity flights:");
            for (Flight flight : groupedFlights.get(2)) {
                System.out.print(flight.getFlightNumber() + " - " + flight.getDepartureTime() + " - ");
                System.out.println("Passenger capacity = " + flight.calculatePassengerCapacity(flight.getAircraftType()));
            }

            List<Flight> roundTripFlights = flightManager.getRoundTripFlights();
            System.out.println("\nRound trip flights:");
            for (Flight flight : roundTripFlights) {
                System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
            }

        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }
}