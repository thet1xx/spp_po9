import java.util.ArrayList;
import java.util.List;
interface Mobile {
    void makeCall(String phoneNumber);
    void sendMessage(String phoneNumber, String message);
    void playMusic(String song);
}
abstract class IphoneMobile implements Mobile {
    String model;
    public IphoneMobile(String model) {
        this.model = model;
    }
    @Override
    public void makeCall(String phoneNumber) {
        System.out.println("Звонок с " + model + " на " + phoneNumber);
    }
    @Override
    public void sendMessage(String phoneNumber, String message) {
        System.out.println("Отправка сообщения с " + model + " на " + phoneNumber + ": " + message);
    }
    abstract void installApp(String appName);
}
class Model extends IphoneMobile {
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
        System.out.println("Установка приложения " + appName + " на " + model);
    }
    public void uninstallApp(String appName) {
        if (installedApps.contains(appName)) {
            installedApps.remove(appName);
            System.out.println("Удаление приложения " + appName + " с " + model);
        } else {
            System.out.println("Приложение " + appName + " не установлено на устройстве " + model);
        }
    }
    @Override
    public void playMusic(String song) {
        System.out.println("Воспроизведение музыки " + song + " на " + model);
    }
}
public class Main1 {
    public static void main(String[] args) {
        Model iphone11 = new Model("Iphone 11 pro", 32);
        System.out.println("Объём памяти: " + iphone11.getStorageCapacity() + " GB");
        iphone11.makeCall("+375297228696");
        iphone11.sendMessage("+375297941646", "Как дела?");
        iphone11.installApp("ITunes");
        iphone11.installApp("YouTube");
        iphone11.uninstallApp("ITunes");
        iphone11.uninstallApp("Google Chrome");
        iphone11.playMusic("Beethoven - 3 Piano Sonata");
    }
}