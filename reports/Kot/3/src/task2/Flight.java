import java.util.Date;
import java.util.List;

public class Flight {
    private String destination;
    private int flightNumber;
    private String aircraftType;
    private Date departureTime;
    private List<String> operatingDays;

    public Flight(String destination, int flightNumber,
                  String aircraftType, Date departureTime,
                  List<String> operatingDays) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.operatingDays = operatingDays;
    }

    public int calculatePassengerCapacity(String aircraftType) {
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

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public List<String> getOperatingDays() {
        return operatingDays;
    }
}