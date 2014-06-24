package com.guigarage.chapter9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CssStylingDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button bottomButton = new Button("Click");
        bottomButton.setId("bottomButton");

        Button toolbarButton1 = new Button("Click");
        toolbarButton1.setId("button-custom");


        Button toolbarButton2 = new Button("Click");
        toolbarButton2.setId("my-action-button");
        ToolBar toolbar = new ToolBar(toolbarButton1, toolbarButton2);
        //toolbarButton2.setStyle("-fx-background-color: green;");

        Button centerButton = new Button("Click");
        centerButton.setId("centerButton");
        StackPane centerPane = new StackPane(centerButton);

        VBox myPane = new VBox(toolbar, centerPane, bottomButton);
        VBox.setVgrow(centerPane, Priority.ALWAYS);
        myPane.setAlignment(Pos.CENTER);
        myPane.setSpacing(12);
        myPane.setPadding(new Insets(0, 0, 6, 0));

        centerButton.getStyleClass().add("dialog-button");
        bottomButton.getStyleClass().add("dialog-button");
        myPane.getStyleClass().add("vbox");


        Scene myScene = new Scene(myPane);

        myScene.getStylesheets().addAll(getClass().getResource("customstyle.css").toExternalForm());

        primaryStage.setScene(myScene);
        primaryStage.setTitle("App");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

}
