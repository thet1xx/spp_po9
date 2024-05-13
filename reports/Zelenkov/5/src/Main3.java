import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void requestPhoneNumberChange(TelephoneAdministrator administrator, String newNumber);
    void requestService(TelephoneAdministrator administrator, Service service);
    void cancelService(TelephoneAdministrator administrator, Service service);
    void payArrears(double amount);
    void accountAmount();
    boolean checkUnpaidBill();
}

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
    private final String name;
    private final double price;

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

class TelephoneSubscriber implements Subscriber {
    public String phoneNumber;
    public List<Service> services;
    public Bill bill;
    public boolean isActive;

    public TelephoneSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.services = new ArrayList<>();
        this.bill = new Bill(0);
        this.isActive = true;
    }

    public void requestPhoneNumberChange(TelephoneAdministrator administrator, String newNumber) {
        administrator.changePhoneNumber(this, newNumber);
    }

    public void requestService(TelephoneAdministrator administrator, Service service) {
        administrator.requestService(this, service);
    }

    public void cancelService(TelephoneAdministrator administrator, Service service) {
        administrator.cancelService(this, service);
    }

    public void payArrears(double amount) {
        this.bill.setAmount(this.bill.getAmount() - amount);
        System.out.println("Абонент " + this.phoneNumber + " положил " + amount + " на счет.");
        if(!this.isActive && !checkUnpaidBill())
        {
            this.isActive = true;
            System.out.println
                    ("Абонент " + this.phoneNumber + " вновь подключен после уплаты задолженности");
        }
    }

    public void accountAmount()
    {
        if(checkUnpaidBill())
        {
            System.out.println
                    ("У абонента " + this.phoneNumber + " имеется задолженность суммой " + this.bill.getAmount());
        }
        else
        {
            System.out.println
                    ("У абонента " + this.phoneNumber + " имеется остаток на счете суммой " + (-this.bill.getAmount()));
        }
    }

    public boolean checkUnpaidBill() {
        return this.bill.getAmount() > 0;
    }
}

interface Administrator {
    void changePhoneNumber(TelephoneSubscriber subscriber, String newNumber);
    void requestService(TelephoneSubscriber subscriber, Service service);
    void cancelService(TelephoneSubscriber subscriber, Service service);
    void temporarilyDisableSubscriber(TelephoneSubscriber subscriber);
}

class TelephoneAdministrator implements Administrator {
    public void changePhoneNumber(TelephoneSubscriber subscriber, String newNumber) {
        System.out.println("Абонент с номером " + subscriber.phoneNumber + " сменил номер телефона на " + newNumber);
        subscriber.phoneNumber = newNumber;
    }

    public void requestService(TelephoneSubscriber subscriber, Service service) {
        subscriber.services.add(service);
        subscriber.bill.setAmount(subscriber.bill.getAmount() + service.getPrice());
        System.out.println("Абонент " + subscriber.phoneNumber + " подписался на услугу: " + service.getName());
    }

    public void cancelService(TelephoneSubscriber subscriber, Service service) {
        if (subscriber.services.contains(service)) {
            subscriber.services.remove(service);
            subscriber.bill.setAmount(subscriber.bill.getAmount() - service.getPrice());
            System.out.println("Абонент " + subscriber.phoneNumber + " отказался от услуги: " + service.getName());
        }
    }

    public void temporarilyDisableSubscriber(TelephoneSubscriber subscriber) {
        if (subscriber.checkUnpaidBill()) {
            subscriber.isActive = false;
            System.out.println("Абонент " + subscriber.phoneNumber + " отключен за неуплату.");
        }
    }
}

class TelephoneStation {
    private List<TelephoneSubscriber> subscribers;

    public TelephoneStation() {
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(TelephoneSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public List<TelephoneSubscriber> getSubscribers() {
        return subscribers;
    }
}

public class Main3 {
    public static void main(String[] args) {
        TelephoneStation telephoneStation = new TelephoneStation();

        Service service1 = new Service("Интернет обслуживание", 34.0);
        Service service2 = new Service("Подписка на музыку", 89.0);
        Service service3 = new Service("Подписка на анекдоты", 15.0);
        TelephoneSubscriber subscriber1 = new TelephoneSubscriber("297228696");

        telephoneStation.addSubscriber(subscriber1);

        TelephoneAdministrator administrator = new TelephoneAdministrator();

        subscriber1.requestPhoneNumberChange(administrator, "336663432");

        subscriber1.payArrears(15);

        subscriber1.requestService(administrator, service1);
        subscriber1.requestService(administrator, service2);
        subscriber1.requestService(administrator, service3);

        subscriber1.accountAmount();

        subscriber1.cancelService(administrator, service2);

        administrator.temporarilyDisableSubscriber(subscriber1);

        subscriber1.payArrears(1000);

        subscriber1.accountAmount();
    }
}
