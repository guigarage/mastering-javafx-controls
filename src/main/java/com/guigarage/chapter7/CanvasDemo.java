package com.guigarage.chapter7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class CanvasDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseClicked(e -> stamp(gc, e.getX(), e.getY()));

        Button fillButton = new Button("fill");
        fillButton.setOnAction(e -> fill(gc));

        Button clearButton = new Button("clear");
        clearButton.setOnAction(e -> clear(gc));

        HBox box = new HBox(fillButton, clearButton);
        box.setSpacing(6);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(6));

        VBox myPane = new VBox();
        myPane.getChildren().addAll(canvas, box);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Canvas Demo");
        primaryStage.show();
    }

    private void fill(GraphicsContext gc) {
        Random random = new Random(System.currentTimeMillis());
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
        gc.setFill(color);
        gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    private void clear(GraphicsContext gc) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    private void stamp(GraphicsContext gc, double x, double y) {
        Random random = new Random(System.currentTimeMillis());
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble());
        gc.setFill(color);
        double size = random.nextDouble() * 300;
        gc.fillRect(x - size / 2, y - size / 2, size, size);
    }

    public static void main(String[] args) {
        launch(args);
    }

}