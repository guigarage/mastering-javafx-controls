package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxStates extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CheckBox c1 = new CheckBox("CheckBox true true");
        c1.setSelected(true);
        c1.setIndeterminate(true);
        CheckBox c2 = new CheckBox("CheckBox true false");
        c2.setSelected(true);
        c2.setIndeterminate(false);
        CheckBox c3 = new CheckBox("CheckBox false true");
        c3.setSelected(false);
        c3.setIndeterminate(true);
        CheckBox c4 = new CheckBox("CheckBox false false");
        c4.setSelected(false);
        c4.setIndeterminate(false);

        VBox box = new VBox();
        box.setPadding(new Insets(24));
        box.setSpacing(12);
        box.getChildren().addAll(c1, c2, c3, c4);
        Scene myScene = new Scene(box);

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
