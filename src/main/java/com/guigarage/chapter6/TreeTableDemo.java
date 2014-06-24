package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Date;

public class TreeTableDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TreeTableView<File> treeTable = new TreeTableView<>();

        TreeTableColumn<File, String> nameColumn = new TreeTableColumn<>("Name");
        TreeTableColumn<File, Long> sizeColumn = new TreeTableColumn<>("Size");
        TreeTableColumn<File, Date> modifiedColumn = new TreeTableColumn<>("Last Modified");


        nameColumn.setCellValueFactory((f) -> new SimpleStringProperty(f.getValue().getValue().getName()));
        sizeColumn.setCellValueFactory((f) -> new SimpleObjectProperty<>(f.getValue().getValue().length()));
        modifiedColumn.setCellValueFactory((f) -> new SimpleObjectProperty<>(new Date(f.getValue().getValue().lastModified())));

        treeTable.setRoot(createTree(new File(".")));
        treeTable.setShowRoot(true);
        treeTable.setTreeColumn(sizeColumn);

        treeTable.getColumns().addAll(nameColumn, sizeColumn, modifiedColumn);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(treeTable);

        primaryStage.setScene(new Scene(vbox));

        primaryStage.show();
    }

    private TreeItem<File> createTree(File file) {
        TreeItem<File> item = new TreeItem<>(file);
        File[] childs = file.listFiles();
        if (childs != null) {
            for (File child : childs) {
                item.getChildren().add(createTree(child));
            }
            item.setGraphic(new ImageView(getClass().getResource("folder.png").toExternalForm()));
        } else {
            item.setGraphic(new ImageView(getClass().getResource("text-x-generic.png").toExternalForm()));
        }
        return item;
    }


    public static void main(String[] args) {
        launch(args);
    }

}
