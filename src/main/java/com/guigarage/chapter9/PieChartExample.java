package com.guigarage.chapter9;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PieChartExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        pieChartData.addAll(
                new PieChart.Data("Christopher Eccleston", 1),
                new PieChart.Data("David Tennant", 5),
                new PieChart.Data("Matt Smith", 3));

        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Tenure of Doctor Who");

        chart.getStylesheets().add(getClass().getResource("pie.css").toExternalForm());

        StackPane myPane = new StackPane();
        myPane.getChildren().add(chart);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Pie Chart");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}