import java.util.ArrayList;
import java.util.List;

public class CD {
    private List<Directory> directories;

    public CD() {
        this.directories = new ArrayList<>();
    }

    private class Directory {
        private String name;
        private List<String> files;

        public Directory(String name) {
            this.name = name;
            this.files = new ArrayList<>();
        }

        public void addFile(String file) {
            this.files.add(file);
        }

        public void printDirectory() {
            System.out.println("Directory: " + name);
            for (String file : files) {
                System.out.println("- " + file);
            }
        }
    }

    public void addDirectory(String name) {
        directories.add(new Directory(name));
    }

    public void addFileToDirectory(String directoryName, String fileName) {
        for (Directory directory : directories) {
            if (directory.name.equals(directoryName)) {
                directory.addFile(fileName);
                return;
            }
        }
        System.out.println("Directory " + directoryName + " not found!");
    }

    public void printCDContents() {
        System.out.println("CD Contents:");
        for (Directory directory : directories) {
            directory.printDirectory();
        }
    }

    public static void main(String[] args) {
        CD cd = new CD();

        cd.addDirectory("The Pretty Reckless");
        cd.addFileToDirectory("The Pretty Reckless", "justtonight.mp3");
        cd.addFileToDirectory("The Pretty Reckless", "you.mp3");

        cd.addDirectory("Muse");
        cd.addFileToDirectory("Muse", "hysteria.mp3");
        cd.addFileToDirectory("Music", "song.mp3");

        cd.printCDContents();
    }
}
