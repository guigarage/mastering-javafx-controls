package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SplitPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().add(new StackPane(new Button("Button 1")));
        splitPane.getItems().add(new StackPane(new Button("Button 2")));
        splitPane.getItems().add(new StackPane(new Button("Button 3")));

        StackPane myPane = new StackPane();
        myPane.getChildren().add(splitPane);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("SplitPane");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
