package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabeledStyleExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("This is a long text");
        button.setAlignment(Pos.BOTTOM_LEFT);
        button.setWrapText(true);
        button.setUnderline(true);
        button.setLineSpacing(12);
        button.setFont(new Font(24));
        button.setTextFill(Color.GREEN);

        Rectangle rect = new Rectangle(24,24);
        rect.setFill(Color.BROWN);
        button.setGraphic(rect);
        button.setGraphicTextGap(42);
        button.setContentDisplay(ContentDisplay.RIGHT);

        StackPane myPane = new StackPane();
        myPane.setPadding(new Insets(24));
        myPane.getChildren().add(button);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("App");
        primaryStage.setWidth(100);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}