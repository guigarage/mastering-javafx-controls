package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DatePickerDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        DatePicker datePicker = new DatePicker();

        StackPane myPane = new StackPane();
        myPane.getChildren().add(datePicker);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("App");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
