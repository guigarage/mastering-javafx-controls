package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableDemo6 extends Application {

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

        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Person, Boolean> employeeOfTheMonthColumn = new TableColumn<>("Employee of the month");

        firstNameColumn.setCellValueFactory((e) -> new ReadOnlyStringWrapper(e.getValue().getFirstName()).getReadOnlyProperty());
        lastNameColumn.setCellValueFactory((e) -> new ReadOnlyStringWrapper(e.getValue().getLastName()).getReadOnlyProperty());
        employeeOfTheMonthColumn.setCellValueFactory((e) -> new ReadOnlyBooleanWrapper(e.getValue().isEmployeeOfTheMonth()).getReadOnlyProperty());

        employeeOfTheMonthColumn.setCellFactory(CheckBoxTableCell.forTableColumn((i) -> new SimpleBooleanProperty(data.get(i).isEmployeeOfTheMonth())));

        //table.setEditable(true);

        table.getColumns().addAll(firstNameColumn, lastNameColumn, employeeOfTheMonthColumn);

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
