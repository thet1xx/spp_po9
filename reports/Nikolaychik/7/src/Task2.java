import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

class Lab2 extends JFrame {;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length");
        int n = sc.nextInt();
        System.out.print("Enter recursion depth : "); // чем больше коэф. тем меньше шагов рекурсии
        int depth = sc.nextInt();

        JFrame window = new JFrame("serpinsky");
        window.setSize(1520, 700);
        window.setBackground(Color.BLACK);
        window.setContentPane(new Triangles(n, depth));
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}