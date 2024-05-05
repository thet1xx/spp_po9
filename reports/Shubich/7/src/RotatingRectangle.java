package org.example;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotatingRectangle extends Application {

    private static final double FRAME_WIDTH = 600;
    private static final double FRAME_HEIGHT = 400;
    private static final double RECTANGLE_WIDTH = 100;
    private static final double RECTANGLE_HEIGHT = 50;
    private static final double ROTATION_SPEED = 1; 

    private Rectangle rectangle;
    private double centerX;
    private double centerY;
    private double angle = 0;

    @Override
    public void start(Stage primaryStage) {
        rectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT, Color.PURPLE);
        centerX = FRAME_WIDTH / 2;
        centerY = FRAME_HEIGHT / 2;
        rectangle.setX(centerX - RECTANGLE_WIDTH / 2);
        rectangle.setY(centerY - RECTANGLE_HEIGHT / 2);

        Group root = new Group(rectangle);
        Scene scene = new Scene(root, FRAME_WIDTH, FRAME_HEIGHT, Color.WHITE);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> rotateRectangle()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotating Rectangle");
        primaryStage.show();
    }

    private void rotateRectangle() {
        double newX = centerX + (rectangle.getX() - centerX) * Math.cos(Math.toRadians(ROTATION_SPEED)) - (rectangle.getY() - centerY) * Math.sin(Math.toRadians(ROTATION_SPEED));
        double newY = centerY + (rectangle.getX() - centerX) * Math.sin(Math.toRadians(ROTATION_SPEED)) + (rectangle.getY() - centerY) * Math.cos(Math.toRadians(ROTATION_SPEED));

        angle += ROTATION_SPEED;

        rectangle.setX(newX);
        rectangle.setY(newY);
        rectangle.setRotate(angle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
