package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SeperatorInToolbarDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        ToolBar toolBar = new ToolBar(
                new Button("New"),
                new Button("Open"),
                new Button("Save"),
                new Separator(),
                new Button("Run"),
                new Button("Debug"),
                new Separator(),
                new Button("Help")
        );

        BorderPane pane = new BorderPane();
        pane.setTop(toolBar);
        pane.setCenter(new TextArea());

        Scene myScene = new Scene(pane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("My little IDE");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
