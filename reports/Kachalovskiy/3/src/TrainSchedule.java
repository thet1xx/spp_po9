package Lab3_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** TODO
 * TODO Обеспечивает первоначальный ввод данных в информационную систему о текущем расписании из файла и формирование дерева;
 * TODO • Печатает все расписание на экран по команде; OK
 * TODO • Выводит информацию о поезде по номеру поезда; OK
 * TODO • По названию станции назначения выводит данные обо всех поездах, которые следуют до этой станции;
 * TODO • Список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа;
 * TODO • Список поездов, отправляющихся до заданного пункта назначения и имеющих общие места;
 * TODO • За 10, 5, 3 минуты до отправления поезда показывает информационное сообщение об отправлении поезда
 **/

public class TrainSchedule {
    Node root;
    public TrainSchedule(){
        root = null;
    }

    public void insert(Train train) {
        root = insertRec(root, train);
    }

    private Node insertRec(Node root, Train train) {
        if (root == null) {
            root = new Node(train);
            return root;
        }

        if (train.departureTime.compareTo(root.train.departureTime) < 0)
            root.left = insertRec(root.left, train);
        else if (train.departureTime.compareTo(root.train.departureTime) > 0)
            root.right = insertRec(root.right, train);

        return root;
    }

    //Печатает все расписание
    public void printSchedule() {
        printInOrder(root);
    }

    private void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.println(root.train);
            printInOrder(root.right);
        }
    }

    public void findTrainByNumber(int trainNumber) {
        Node result = findTrain(root, trainNumber);
        if (result == null)
            System.out.println("Поезд с номером " + trainNumber + " не найден.");
        else
            System.out.println("Найден поезд: " + result.train);
    }

    private Node findTrain(Node root, int trainNumber) {
        if (root == null || root.train.trainNumber == trainNumber)
            return root;

        if (trainNumber < root.train.trainNumber)
            return findTrain(root.left, trainNumber);

        return findTrain(root.right, trainNumber);
    }

    public void printTrainsToDestination(String destination) {
        printTrainsToDestination(root, destination);
    }

    private void printTrainsToDestination(Node root, String destination) {
        if (root != null) {
            printTrainsToDestination(root.left, destination);
            if (root.train.destination.equals(destination)) {
                System.out.println(root.train);
            }
            printTrainsToDestination(root.right, destination);
        }
    }

    public void printTrainsToDestinationAfterTime(String destination, String time) {
        printTrainsToDestinationAfterTime(root, destination, time);
    }

    private void printTrainsToDestinationAfterTime(Node root, String destination, String time) {
        if (root != null) {
            printTrainsToDestinationAfterTime(root.left, destination, time);
            if (root.train.destination.equals(destination) && root.train.departureTime.compareTo(time) > 0) {
                System.out.println(root.train);
            }
            printTrainsToDestinationAfterTime(root.right, destination, time);
        }
    }

    public void printTrainsToDestinationWithAvailableSeats(String destination) {
        printTrainsToDestinationWithAvailableSeats(root, destination);
    }

    private void printTrainsToDestinationWithAvailableSeats(Node root, String destination) {
        if (root != null) {
            printTrainsToDestinationWithAvailableSeats(root.left, destination);
            if (root.train.destination.equals(destination) && root.train.availableSeats > 0) {
                System.out.println(root.train);
            }
            printTrainsToDestinationWithAvailableSeats(root.right, destination);
        }
    }

    public void notifyTrainDeparture(String time) {
        notifyTrainDeparture(root, time);
    }

    private void notifyTrainDeparture(Node root, String time) {
        if (root != null) {
            notifyTrainDeparture(root.left, time);
            int minutesBeforeDeparture = Integer.parseInt(root.train.departureTime.split(":")[0])*60 +
                                         Integer.parseInt(root.train.departureTime.split(":")[1]) - (
                                            Integer.parseInt(time.split(":")[0])*60 +
                                            Integer.parseInt(time.split(":")[1])
                    );

            if (minutesBeforeDeparture == 3 || minutesBeforeDeparture == 5 || minutesBeforeDeparture == 10 ) {
                System.out.println("Оповещение: Поезд " + root.train.trainNumber + " отправляется через " +
                        minutesBeforeDeparture + " минут");
            }
            notifyTrainDeparture(root.right, time);
        }
    }

    public void loadScheduleFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int trainNumber = Integer.parseInt(parts[0]);
                    String destination = parts[1];
                    String departureTime = parts[2];
                    int availableSeats = Integer.parseInt(parts[3]);
                    insert(new Train(trainNumber, destination, departureTime, availableSeats));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке расписания из файла: " + e.getMessage());
        }
    }
}

