package com.guigarage.chapter2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UnifiedStageDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button saveButton = new Button("save");
        ToolBar myToolbar = new ToolBar(saveButton);

        BorderPane pane = new BorderPane();
        pane.setTop(myToolbar);
        pane.setCenter(new TextArea());

        Scene myScene = new Scene(pane);
        myScene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(myScene);
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.setTitle("Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}