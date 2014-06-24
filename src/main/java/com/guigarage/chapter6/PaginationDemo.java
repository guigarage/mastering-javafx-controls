package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PaginationDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pagination pagination = new Pagination();
        pagination.setPageCount(3);
        pagination.setPageFactory((i) -> new Label("This is the page with index " + i));

        StackPane myPane = new StackPane();
        myPane.getChildren().add(pagination);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Pagination");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
