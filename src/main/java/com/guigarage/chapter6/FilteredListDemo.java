package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FilteredListDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> list = FXCollections.observableArrayList("Angelo", "Steffi", "Jan", "Silke");
        FilteredList<String> filteredList = new FilteredList<String>(list);
        filteredList.setPredicate((e) -> true);

        ListView<String> listView = new ListView<>(filteredList);

        TextField textField = new TextField();
        textField.textProperty().addListener((e) -> filteredList.setPredicate((v) -> (textField.getText() == null || textField.getText().length() == 0 || v.startsWith(textField.getText()))));

        VBox myPane = new VBox(textField, listView);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
