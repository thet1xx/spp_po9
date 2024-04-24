import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 extends JPanel implements Runnable {
    private String[] strings;
    private int[] xPositions;
    private int[] yPositions;
    private int[] xSpeeds;
    private int[] ySpeeds;
    private int numStrings;
    private int speed;

    public Task1(String[] strings, int speed) {
        this.strings = strings;
        this.speed = speed;
        numStrings = strings.length;
        xPositions = new int[numStrings];
        yPositions = new int[numStrings];
        xSpeeds = new int[numStrings];
        ySpeeds = new int[numStrings];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < numStrings; i++) {
            g.drawString(strings[i], xPositions[i], yPositions[i]);
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < numStrings; i++) {
            xPositions[i] = random.nextInt(getWidth());
            yPositions[i] = random.nextInt(getHeight());
            xSpeeds[i] = random.nextInt(numStrings) - (numStrings / 2);
            ySpeeds[i] = random.nextInt(numStrings) - (numStrings / 2);
        }

        while (true) {
            moveStrings();
            repaint();
            try {
                Thread.sleep(this.speed); // Adjust the speed of movement here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moveStrings() {
        for (int i = 0; i < numStrings; i++) {
            xPositions[i] += xSpeeds[i];
            yPositions[i] += ySpeeds[i];

            if (xPositions[i] < 0 || xPositions[i] > getWidth()) {
                xSpeeds[i] = -xSpeeds[i];
            }

            if (yPositions[i] < 0 || yPositions[i] > getHeight()) {
                ySpeeds[i] = -ySpeeds[i];
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строки (для завершения введите пустую строку):");

        String input;
        while (!(input = scanner.nextLine()).isEmpty()) {
            strings.add(input);
        }

        System.out.println("Введите скорость движения строк: ");
        int speed = scanner.nextInt();

        JFrame frame = new JFrame("Moving Strings");
        Task1 movingStrings = new Task1(strings.toArray(new String[0]), speed);
        frame.add(movingStrings);
        frame.setSize(800, 600); // Adjust the frame size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread thread = new Thread(movingStrings);
        thread.start();
    }
}
