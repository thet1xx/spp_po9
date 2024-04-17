package Lab3_2;

class Train {
    int trainNumber;
    String destination;
    String departureTime;
    int availableSeats;

    public Train(int trainNumber, String destination, String departureTime, int availableSeats) {
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }


    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
