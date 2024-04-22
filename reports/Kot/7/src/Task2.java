import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2 extends JFrame {
    private List<Integer> turns;
    private double startingAngle, sideLength;
    private static final double ANGLE_45DEGREES = Math.PI / 4;

    public Task2(int amountOfIterations) {
        super("Dragon Curve");
        setBounds(100, 100, 1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        turns = getSequence(amountOfIterations);
        startingAngle = -amountOfIterations * ANGLE_45DEGREES;
        sideLength = 550 / Math.pow(2, amountOfIterations / 2.);
    }

    public List<Integer> getSequence(int iterations) {
        List<Integer> turnSequence = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            List<Integer> copy = new ArrayList<>(turnSequence);
            Collections.reverse(copy);
            turnSequence.add(1);
            for (Integer turn : copy) {
                turnSequence.add(-turn);
            }
        }
        return turnSequence;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        double angle = startingAngle;
        int x1 = 230, y1 = 450;
        int x2 = x1 + (int) (Math.cos(angle) * sideLength);
        int y2 = y1 + (int) (Math.sin(angle) * sideLength);
        g.drawLine(x1, y1, x2, y2);
        x1 = x2;
        y1 = y2;
        for (Integer turn : turns) {
            angle += turn * (Math.PI / 2);
            x2 = x1 + (int) (Math.cos(angle) * sideLength);
            y2 = y1 + (int) (Math.sin(angle) * sideLength);
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество шагов: ");
        int amountOfIterations = scanner.nextInt();

        new Task2(amountOfIterations).setVisible(true);
    }
}
