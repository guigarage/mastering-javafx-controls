package com.guigarage.chapter10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TriangleButtonDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TriangleButton button = new TriangleButton();
        button.setPadding(new Insets(20));

        button.setOnAction((e) -> {
            button.setSkin(new AlternativeTriangleButtonSkin(button));
            button.setSkin(new TriangleButtonSkin(button));
        });



        StackPane myPane = new StackPane();
        myPane.getChildren().add(button);
        Scene myScene = new Scene(myPane);

        //String stylesheet = getClass().getResource("test.css").toExternalForm();
        //myScene.getStylesheets().addAll(stylesheet);


        primaryStage.setScene(myScene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
