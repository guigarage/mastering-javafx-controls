package com.guigarage.chapter9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LadderDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button darkButton = new Button("Dark");
        darkButton.setId("dark-button");

        Button lightButton = new Button("Light");
        lightButton.setId("light-button");

        HBox box = new HBox(darkButton, lightButton);
        box.setPadding(new Insets(12));
        box.setSpacing(12);

        Scene myScene = new Scene(box);
        myScene.getStylesheets().addAll(getClass().getResource("laddertest.css").toExternalForm());

        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
