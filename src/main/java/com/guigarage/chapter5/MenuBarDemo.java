package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuBarDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuBar menuBar = new MenuBar();

        Menu mainMenu = new Menu("Main");
        MenuItem rotateItem = new MenuItem("Load");
        CheckMenuItem underlineItem = new CheckMenuItem("Underline");
        mainMenu.getItems().addAll(rotateItem, underlineItem);

        Menu editMenu = new Menu("Edit");
        Menu convertMenu = new Menu("Convert");
        convertMenu.getItems().addAll(new MenuItem("PDF"), new MenuItem("PNG"));
        editMenu.getItems().addAll(convertMenu, new MenuItem("Rotate"));

        menuBar.getMenus().addAll(mainMenu, editMenu);

        BorderPane pane = new BorderPane();
        pane.setTop(menuBar);

        Scene myScene = new Scene(pane);

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
