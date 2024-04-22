import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FlightManager {
    private List<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<>();
    }

    public void loadFlightsFromFile(String filename) throws FileNotFoundException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            String destination = parts[0];
            int flightNumber = Integer.parseInt(parts[1]);
            String aircraftType = parts[2];
            Date departureTime = dateFormat.parse(parts[3]);
            String[] daysArray = parts[4].split(";");
            List<String> operatingDays = new ArrayList<>();
            operatingDays.addAll(Arrays.asList(daysArray));
            Flight flight = new Flight(destination, flightNumber, aircraftType, departureTime, operatingDays);
            flights.add(flight);
        }
        scanner.close();
    }

    public List<Flight> getFlightsByDestination(String destination) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    public List<Flight> getFlightsByDay(String day) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOperatingDays().contains(day)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    public List<Flight> getFlightsByDayAndTime(String day, Date time) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOperatingDays().contains(day) && flight.getDepartureTime().after(time)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    public List<Flight> getFlightsByAircraftType(String aircraftType) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getAircraftType().equalsIgnoreCase(aircraftType)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    public List<List<Flight>> groupFlightsByPassengerCapacity() {
        List<List<Flight>> groupedFlights = new ArrayList<>();
        List<Flight> smallCapacityFlights = new ArrayList<>();
        List<Flight> mediumCapacityFlights = new ArrayList<>();
        List<Flight> largeCapacityFlights = new ArrayList<>();
        for (Flight flight : flights) {
            int passengerCapacity = calculatePassengerCapacity(flight.getAircraftType());
            if (passengerCapacity >= 1 && passengerCapacity <= 100) {
                smallCapacityFlights.add(flight);
            } else if (passengerCapacity > 100 && passengerCapacity <= 200) {
                mediumCapacityFlights.add(flight);
            } else if (passengerCapacity > 200 && passengerCapacity <= 350) {
                largeCapacityFlights.add(flight);
            }
        }
        groupedFlights.add(smallCapacityFlights);
        groupedFlights.add(mediumCapacityFlights);
        groupedFlights.add(largeCapacityFlights);
        return groupedFlights;
    }

    private int calculatePassengerCapacity(String aircraftType) {
        if (aircraftType.equalsIgnoreCase("Boeing 737")) {
            return 180;
        } else if (aircraftType.equalsIgnoreCase("Airbus A320")) {
            return 100;
        } else if (aircraftType.equalsIgnoreCase("Boeing 777")) {
            return 300;
        } else {
            return 0;
        }
    }

    public List<Flight> getRoundTripFlights() {
        List<Flight> roundTripFlights = new ArrayList<>();
        for (Flight outboundFlight : flights) {
            for (Flight returnFlight : flights) {
                if (outboundFlight.getDestination().equalsIgnoreCase(returnFlight.getDestination()) &&
                        outboundFlight.getFlightNumber() != returnFlight.getFlightNumber()) {
                    roundTripFlights.add(outboundFlight);
                }
            }
        }
        return roundTripFlights;
    }
}
