package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeperatorDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        String[] names = new String[]{"Dog", "Horse", "Cat",
                "Tiger", "Shark", "Bear"};
        CheckBox[] cbs = new CheckBox[names.length];
        for (int i = 0; i < names.length; i++) {
            cbs[i] = new CheckBox(names[i]);
        }

        VBox vbox = new VBox(cbs);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(24));
        vbox.setBackground(Background.EMPTY);

        Separator separator = new Separator();
        vbox.getChildren().add(3, separator);

        Scene myScene = new Scene(vbox);

        primaryStage.setScene(myScene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
