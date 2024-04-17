package Lab3_2;


public class Lab3_2 {
    public static void main(String[] args) {
        TrainSchedule schedule = new TrainSchedule();
        schedule.loadScheduleFromFile("src/Lab3_2/schedule.txt");
        System.out.println("Вывод всех поездов");
        schedule.printSchedule();
        System.out.println("Поиск по номеру");
        schedule.findTrainByNumber(1);
        System.out.println("Вывод по месту прибытия");
        schedule.printTrainsToDestination("Kobrin");
        System.out.println("Вывод по месту прибытия после указанного времени");
        schedule.printTrainsToDestinationAfterTime("Kobrin", "15:00");
        System.out.println("Вывод по месту прибытия со свободными местами");
        schedule.printTrainsToDestinationWithAvailableSeats("Kobrin");
        schedule.notifyTrainDeparture("11:20");
    }
}
