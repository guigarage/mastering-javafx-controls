package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EditableListDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll("Franky", "Private", "Steve", "Murphy", "Junior");

        ListView<String> listView = new ListView<>();
        listView.setItems(data);
        listView.setCellFactory(TextFieldListCell.forListView());
        listView.setEditable(true);

        StackPane myPane = new StackPane();
        myPane.getChildren().add(listView);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}