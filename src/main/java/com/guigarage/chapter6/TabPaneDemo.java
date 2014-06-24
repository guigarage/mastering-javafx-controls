package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Button");
        tab1.setContent(new StackPane(new Button("Button")));

        Tab tab2 = new Tab("CheckBox");
        tab2.setContent(new StackPane(new CheckBox("CheckBox")));

        tabPane.getTabs().addAll(tab1, tab2);

        StackPane myPane = new StackPane();
        myPane.getChildren().add(tabPane);
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
