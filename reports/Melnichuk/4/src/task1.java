import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Notepad {
    private HashMap<String, DayRecord> records;

    public Notepad() {
        records = new HashMap<>();
    }

    public void addRecord(String date, String record) {
        if (!records.containsKey(date)) {
            records.put(date, new DayRecord());
        }
        records.get(date).add(record);
    }

    public List<String> getRecords(String date) {
        if (records.containsKey(date)) {
            return records.get(date).getRecords();
        }
        return new ArrayList<>();
    }

    private class DayRecord {
        private ArrayList<String> records;

        public DayRecord() {
            records = new ArrayList<>();
        }

        public void add(String record) {
            records.add(record);
        }

        public List<String> getRecords() {
            return records;
        }
    }
}
public class task1 {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        notepad.addRecord("08-04-2024", "Запись 1");
        notepad.addRecord("08-04-2024", "Запись 2");
        notepad.addRecord("08-04-2024", "Запись 3");
        notepad.addRecord("05-04-2024", "Запись 4");
        notepad.addRecord("05-04-2024", "Запись 5");

        List<String> records = notepad.getRecords("08-04-2024");
        System.out.println("Записи на 08-04-2024");
        for (String record : records) {
            System.out.println(record);
        }
    }
}

