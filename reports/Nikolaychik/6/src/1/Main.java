interface PhoneFactory {
    SmartPhone createSmartPhone();
}

interface SmartPhone {
    void displayInfo();
}

class AppleFactory implements PhoneFactory {
    public SmartPhone createSmartPhone() {
        return new iPhone();
    }
}

class SamsungFactory implements PhoneFactory {
    public SmartPhone createSmartPhone() {
        return new Galaxy();
    }
}

class iPhone implements SmartPhone {
    public void displayInfo() {
        System.out.println("This is an iPhone.");
    }
}

class Galaxy implements SmartPhone {
    public void displayInfo() {
        System.out.println("This is a Samsung Galaxy.");
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneFactory appleFactory = new AppleFactory();
        SmartPhone iphone = appleFactory.createSmartPhone();
        iphone.displayInfo();
        PhoneFactory samsungFactory = new SamsungFactory();
        SmartPhone galaxy = samsungFactory.createSmartPhone();
        galaxy.displayInfo();
    }
}