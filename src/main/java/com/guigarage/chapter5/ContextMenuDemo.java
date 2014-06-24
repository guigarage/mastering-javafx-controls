package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContextMenuDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Click me");

        ContextMenu menu = new ContextMenu();

        MenuItem rotateItem = new MenuItem("Rotate");
        rotateItem.setOnAction((e) -> button.setRotate(button.getRotate() + 45));

        CheckMenuItem underlineItem = new CheckMenuItem("Underline");
        button.underlineProperty().bindBidirectional(underlineItem.selectedProperty());

        menu.getItems().addAll(rotateItem, underlineItem);


        button.setContextMenu(menu);


        StackPane myPane = new StackPane();
        myPane.getChildren().add(button);
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
