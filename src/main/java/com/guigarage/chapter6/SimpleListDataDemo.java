package com.guigarage.chapter6;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class SimpleListDataDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<String> data = FXCollections.observableArrayList();
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.itemsProperty().setValue(data);

        ListView<String> listView = new ListView<>();
        listView.itemsProperty().setValue(data);
        TextField inputField = new TextField();
        inputField.setPromptText("insert new data type");
        inputField.setOnAction(e -> data.add(inputField.getText()));
        VBox box = new VBox(6, inputField, comboBox, listView);
        box.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(box);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}