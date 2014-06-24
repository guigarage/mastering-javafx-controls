package com.guigarage.chapter4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LayoutDemo  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SortedPane myPane = new SortedPane();
        myPane.setPadding(new Insets(12,12,12,12));
        myPane.setSpacing(8);
        myPane.setStyle("-fx-border-width: 3;" +
                "-fx-border-color: black;" +
                "-fx-background-color: lightblue;");

        Button transformedButton = new Button("Hello World");
        transformedButton.setTranslateX(24);
        transformedButton.setTranslateY(24);
        transformedButton.setRotate(12);

        myPane.getChildren().add(transformedButton);
        myPane.getChildren().add(new Button("Long Text.............."));
        myPane.getChildren().add(new Button("short"));

        StackPane pane = new StackPane();
        pane.getChildren().add(myPane);

        Scene myScene = new Scene(pane);
        primaryStage.setScene(myScene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(140);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}