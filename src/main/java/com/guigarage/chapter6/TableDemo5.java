package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableDemo5 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Claudine", "Zillmann", "Design"),
                new Person("Joel", "Ferreira", "Pro Gamer"),
                new Person("Alexander", "Jorde", "Junior Developer"),
                new Person("Holger", "Merk", "Senior Architect")
        );

        TableView<Person> table = new TableView(data);

        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.getColumns().addAll(firstNameColumn, lastNameColumn);
        TableColumn<Person, String> jobColumn = new TableColumn<>("Job");

        firstNameColumn.setCellValueFactory((e) -> new ReadOnlyStringWrapper(e.getValue().getFirstName()));
        lastNameColumn.setCellValueFactory((e) -> new ReadOnlyStringWrapper(e.getValue().getLastName()));
        jobColumn.setCellValueFactory((e) -> new ReadOnlyStringWrapper(e.getValue().getJob()));

        firstNameColumn.setOnEditCommit((e) -> e.getRowValue().setFirstName(e.getNewValue()));
        lastNameColumn.setOnEditCommit((e) -> e.getRowValue().setLastName(e.getNewValue()));
        jobColumn.setOnEditCommit((e) -> e.getRowValue().setJob(e.getNewValue()));

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
