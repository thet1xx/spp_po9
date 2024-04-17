import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

class Bill {
    private double amount;

    public Bill(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class Service {
    private String name;
    private double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Subscriber {
    public String phoneNumber;
    public List<Service> services;
    public Bill bill;
    public boolean isActive;

    public Subscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.services = new ArrayList<>();
        this.bill = new Bill(0);
        this.isActive = true;
    }

    public void requestPhoneNumberChange(Administrator administrator, String newNumber) {
        administrator.changePhoneNumber(this, newNumber);
    }

    public void requestService(Administrator administrator, Service service) {
        administrator.requestService(this, service);
    }

    public void cancelService(Administrator administrator, Service service) {
        administrator.cancelService(this, service);
    }

    public void payBill(double amount) {
        this.bill.setAmount(this.bill.getAmount() - amount);
        System.out.println("Абонент " + this.phoneNumber + " положил " + amount + " на счет");
        if(!this.isActive && !checkUnpaidBill())
        {
            this.isActive = true;
            System.out.println
                    ("абонент " + this.phoneNumber + " обратно подключен после уплаты задолженности");
        }
    }

    public void accountAmount()
    {
        if(checkUnpaidBill())
        {
            System.out.println
                    ("у абонента " + this.phoneNumber + " до сих пор есть задолженность суммой " + this.bill.getAmount());
        }
        else
        {
            System.out.println
                    ("у абонента " + this.phoneNumber + " имеется остаток на счете суммой " + (-this.bill.getAmount()));
        }
    }

    public boolean checkUnpaidBill() {
        return this.bill.getAmount() > 0;
    }
}

class Administrator {
    public void changePhoneNumber(Subscriber subscriber, String newNumber) {
        System.out.println("Абонент с номером" + subscriber.phoneNumber + " сменил номер телефона на " + newNumber);
        subscriber.phoneNumber = newNumber;
    }

    public void requestService(Subscriber subscriber, Service service) {
        subscriber.services.add(service);
        subscriber.bill.setAmount(subscriber.bill.getAmount() + service.getPrice());
        System.out.println("Абонент " + subscriber.phoneNumber + " подписался на услугу: " + service.getName());
    }

    public void cancelService(Subscriber subscriber, Service service) {
        if (subscriber.services.contains(service)) {
            subscriber.services.remove(service);
            subscriber.bill.setAmount(subscriber.bill.getAmount() - service.getPrice());
            System.out.println("Абонент " + subscriber.phoneNumber + " отказался от услуги: " + service.getName());
        }
    }

    public void temporarilyDisableSubscriber(Subscriber subscriber) {
        if (subscriber.checkUnpaidBill()) {
            subscriber.isActive = false;
            System.out.println("абонент " + subscriber.phoneNumber + " временно отключен за неуплату.");
        }
    }
}

class TelephoneStation {
    private List<Subscriber> subscribers;

    public TelephoneStation() {
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}

public class Task_03 {
    public static void main(String[] args) {
        TelephoneStation telephoneStation = new TelephoneStation();

        Service service1 = new Service("Интернет", 30.0);
        Service service2 = new Service("Кабельное телевидение", 50.0);
        Service service3 = new Service("Музыка", 40.0);
        Subscriber subscriber1 = new Subscriber("123456789");

        telephoneStation.addSubscriber(subscriber1);

        Administrator administrator = new Administrator();

        subscriber1.requestPhoneNumberChange(administrator, "987654321");

        subscriber1.payBill(50);

        subscriber1.requestService(administrator, service1);
        subscriber1.requestService(administrator, service2);
        subscriber1.requestService(administrator, service3);

        subscriber1.accountAmount();

        subscriber1.cancelService(administrator, service2);

        administrator.temporarilyDisableSubscriber(subscriber1);

        subscriber1.payBill(80);
    }
}
