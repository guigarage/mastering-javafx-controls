package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableDemo4  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Claudine", "Zillmann", "Design"),
                new Person("Joel", "Ferreira", "Pro Gamer"),
                new Person("Alexander", "Jorde", "Junior Developer"),
                new Person("Holger", "Merk", "Senior Architect")
        );

        TableView<Person> table = new TableView();
        table.itemsProperty().setValue(data);

        TableColumn firstNameColumn = new TableColumn("First Name");
        TableColumn lastNameColumn = new TableColumn("Last Name");
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.getColumns().addAll(firstNameColumn, lastNameColumn);
        TableColumn jobColumn = new TableColumn("Job");

        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<Person,String>("firstName")
        );
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastName")
        );
        jobColumn.setCellValueFactory(
                new PropertyValueFactory<Person,String>("job")
        );

        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        jobColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        table.setEditable(true);

        table.getColumns().addAll(nameColumn, jobColumn);

        table.setOnMouseEntered((e) -> System.out.println(data));

        StackPane myPane = new StackPane();
        myPane.getChildren().add(table);
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
