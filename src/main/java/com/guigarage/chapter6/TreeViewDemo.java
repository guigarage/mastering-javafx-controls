package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TreeView treeView = new TreeView();

        TreeItem<String> item = new TreeItem<>("javafx");
        TreeItem<String> item2 = new TreeItem<>("scene");
        item.getChildren().add(item2);
        TreeItem<String> item3 = new TreeItem<>("control");
        item2.getChildren().add(item3);
        item3.getChildren().add(new TreeItem<>("Button"));
        item3.getChildren().add(new TreeItem<>("TreeView"));
        item2.getChildren().add(new TreeItem<>("Scene"));
        TreeItem<String> item4 = new TreeItem<>("stage");
        item.getChildren().add(item4);
        item4.getChildren().add(new TreeItem<>("Stage"));

        treeView.setRoot(item);

        StackPane myPane = new StackPane();
        myPane.getChildren().add(treeView);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
