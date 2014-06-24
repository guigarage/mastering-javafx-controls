package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectionModelDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> data = FXCollections.observableArrayList(
                "Z", "B", "A", "X", "W", "C", "F"
        );

        SortedList sortedList = new SortedList(data);

        TableView<String> table = new TableView<>();
        table.itemsProperty().setValue(sortedList);

        sortedList.comparatorProperty().bind(table.comparatorProperty());

        TableColumn<String, String> column = new TableColumn<>("Data");
        column.setCellValueFactory((e) -> new SimpleStringProperty(e.getValue()));
        table.getColumns().add(column);



        VBox myPane = new VBox();
        myPane.setAlignment(Pos.CENTER);
        myPane.setPadding(new Insets(12));
        myPane.setSpacing(12);
        myPane.getChildren().add(table);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}