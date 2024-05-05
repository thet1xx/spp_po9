package org.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JuliaSetFractal extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MAX_ITERATIONS = 500;
    private static final double SCALE = 500;
    private static final double OFFSET_X = WIDTH / 2;
    private static final double OFFSET_Y = HEIGHT / 2;

    private double cRe = -0.7;
    private double cIm = 0.27015;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        drawJuliaSet(canvas);

        BorderPane root = new BorderPane(canvas);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Julia Set Fractal");
        primaryStage.show();
    }

    private void drawJuliaSet(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        PixelWriter pw = gc.getPixelWriter();

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double zx = 1.5 * (x - OFFSET_X) / (SCALE);
                double zy = (y - OFFSET_Y) / (SCALE);
                int iteration = 0;
                while (zx * zx + zy * zy < 4 && iteration < MAX_ITERATIONS) {
                    double temp = zx * zx - zy * zy + cRe;
                    zy = 2.0 * zx * zy + cIm;
                    zx = temp;
                    iteration++;
                }
                if (iteration == MAX_ITERATIONS) {
                    pw.setColor(x, y, Color.WHITE);
                } else {
                    double ratio = (double) iteration / MAX_ITERATIONS;
                    pw.setColor(x, y, Color.color(ratio, ratio * ratio, ratio * ratio * ratio));
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
