package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<Priority> data = FXCollections.observableArrayList(
                Priority.HIGH, Priority.LOW, Priority.MEDIUM, Priority.LOW, Priority.HIGH, Priority.LOW, Priority.MEDIUM
        );

        TableView<Priority> table = new TableView<>();
        table.itemsProperty().setValue(data);

        TableColumn<Priority, Priority> priorityColumn = new TableColumn<>("Priority");
        priorityColumn.setComparator((Priority p1, Priority p2) -> {
            if(p1.equals(p2)) {return 0;}
            if(p1.equals(Priority.HIGH)) {return 1;}
            if(p1.equals(Priority.MEDIUM) && p2.equals(Priority.LOW)) {return 1;}
            return -1;
        });

        priorityColumn.setSortType(TableColumn.SortType.DESCENDING);

        priorityColumn.setCellValueFactory((f) -> new SimpleObjectProperty<Priority>(f.getValue()));

        table.getColumns().addAll(priorityColumn);

        StackPane myPane = new StackPane();
        myPane.getChildren().add(table);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
