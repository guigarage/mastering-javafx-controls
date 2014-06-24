package com.guigarage.chapter6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorListCellDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<Color> data = FXCollections.observableArrayList();
        data.addAll(Color.ALICEBLUE, Color.ORANGE, Color.YELLOW, Color.INDIGO, Color.KHAKI, Color.FORESTGREEN, Color.LIGHTPINK, Color.CRIMSON, Color.SEASHELL);


        ListView<Color> listView = new ListView<>();
        listView.setItems(data);
        listView.setCellFactory(c -> new ColorListCell());
        listView.setEditable(true);

        StackPane myPane = new StackPane();
        myPane.getChildren().add(listView);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
