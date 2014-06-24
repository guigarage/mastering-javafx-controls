package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ColorPickerDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("Demo Label");
        label.setFont(new Font(24));

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction((e) -> label.setTextFill(colorPicker.getValue()));

        VBox box = new VBox(label, colorPicker);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(24));
        box.setSpacing(24);
        Scene myScene = new Scene(box);

        primaryStage.setScene(myScene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
