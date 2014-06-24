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

public class TableDemo3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<ExtendedPerson> data = FXCollections.observableArrayList(
                new ExtendedPerson("Claudine", "Zillmann", "Design", true),
                new ExtendedPerson("Joel", "Ferreira", "Pro Gamer", false),
                new ExtendedPerson("Alexander", "Jorde", "Junior Developer", false),
                new ExtendedPerson("Holger", "Merk", "Senior Architect", false)
        );

        TableView<ExtendedPerson> table = new TableView();
        table.itemsProperty().setValue(data);

        TableColumn firstNameColumn = new TableColumn("First Name");
        TableColumn lastNameColumn = new TableColumn("Last Name");
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.getColumns().addAll(firstNameColumn, lastNameColumn);
        TableColumn jobColumn = new TableColumn("Job");

        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<ExtendedPerson,String>("firstName")
        );
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<ExtendedPerson,String>("lastName")
        );
        jobColumn.setCellValueFactory(
                new PropertyValueFactory<ExtendedPerson,String>("job")
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
