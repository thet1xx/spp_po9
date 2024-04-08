import java.util.ArrayList;
import java.util.List;
interface Mobile {
    void makeCall(String phoneNumber);
    void sendMessage(String phoneNumber, String message);
    void playMusic(String song);
}

abstract class SamsungMobile implements Mobile {
    String model;

    public SamsungMobile(String model) {
        this.model = model;
    }

    @Override
    public void makeCall(String phoneNumber) {
        System.out.println("Making call from " + model + " to " + phoneNumber);
    }

    @Override
    public void sendMessage(String phoneNumber, String message) {
        System.out.println("Sending message from " + model + " to " + phoneNumber + ": " + message);
    }

    abstract void installApp(String appName);
}

class Model extends SamsungMobile {
    private final int storageCapacity;
    private List<String> installedApps;

    public Model(String model, int storageCapacity) {
        super(model);
        this.storageCapacity = storageCapacity;
        this.installedApps = new ArrayList<>();
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void installApp(String appName) {
        installedApps.add(appName);
        System.out.println("Installing app " + appName + " on " + model);
    }

    public void uninstallApp(String appName) {
        if (installedApps.contains(appName)) {
            installedApps.remove(appName);
            System.out.println("Uninstalling app " + appName + " from " + model);
        } else {
            System.out.println("App " + appName + " is not installed on " + model);
        }
    }

    @Override
    public void playMusic(String song) {
        System.out.println("Playing music " + song + " on " + model);
    }
}

public class Task_01 {
    public static void main(String[] args) {
        Model samsungGalaxy = new Model("Samsung Galaxy", 32);
        System.out.println("StorageCapacity: " + samsungGalaxy.getStorageCapacity() + " GB");
        samsungGalaxy.makeCall("+375333283757");
        samsungGalaxy.sendMessage("+375333283757", "Hello!");
        samsungGalaxy.installApp("Play Market");
        samsungGalaxy.installApp("YouTube");
        samsungGalaxy.uninstallApp("Play Market");
        samsungGalaxy.playMusic("MySong");
    }
}
