package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AccordionDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Accordion accordion = new Accordion();
        TitledPane pane1 = new TitledPane("Edit", new Button("Edit"));
        TitledPane pane2 = new TitledPane("Save", new Button("Save"));
        TitledPane pane3 = new TitledPane("Close", new Button("Close"));
        accordion.getPanes().addAll(pane1, pane2, pane3);

        StackPane myPane = new StackPane();
        myPane.getChildren().add(accordion);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Accordion");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
