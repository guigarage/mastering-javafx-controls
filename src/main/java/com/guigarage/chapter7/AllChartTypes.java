package com.guigarage.chapter7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AllChartTypes extends Application {

    private PieChart getPieChart() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("SWT", 13),
                        new PieChart.Data("AWT", 10),
                        new PieChart.Data("Swing", 22),
                        new PieChart.Data("JavaFX", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Ui Toolkits");
        return chart;
    }

    private LineChart<Number,Number> getLineChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Count");
        final LineChart<Number,Number> lineChart =
                new LineChart<>(xAxis,yAxis);

        lineChart.setTitle("Some Data");
        XYChart.Series<Number,Number> series = new XYChart.Series<>();
        series.setName("My portfolio");
        series.getData().add(new XYChart.Data(1, 20));
        series.getData().add(new XYChart.Data(2, 15));
        series.getData().add(new XYChart.Data(3, 10));
        series.getData().add(new XYChart.Data(4, 19));
        lineChart.setData(FXCollections.observableArrayList(series));
        return lineChart;
    }

    private AreaChart<Number,Number> getAreaChart() {
        final NumberAxis xAxis = new NumberAxis(1, 9, 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number,Number> ac =
                new AreaChart<>(xAxis,yAxis);
        ac.setTitle("Bug Monitoring");

        XYChart.Series<Number,Number> seriesApril= new XYChart.Series<>();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(1, 3));
        seriesApril.getData().add(new XYChart.Data(3, 12));
        seriesApril.getData().add(new XYChart.Data(6, 17));
        seriesApril.getData().add(new XYChart.Data(9, 4));

        XYChart.Series<Number,Number> seriesMay = new XYChart.Series<>();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(1, 19));
        seriesMay.getData().add(new XYChart.Data(3, 6));
        seriesMay.getData().add(new XYChart.Data(6, 20));
        seriesMay.getData().add(new XYChart.Data(9, 7));
        ac.setData(FXCollections.observableArrayList(seriesApril, seriesMay));
        return ac;
    }

    private BubbleChart<Number,Number> getBubbleChart() {
        final NumberAxis xAxis = new NumberAxis(1, 30, 4);
        final NumberAxis yAxis = new NumberAxis(0, 40, 10);
        final BubbleChart<Number,Number> blc = new
                BubbleChart<>(xAxis,yAxis);
        xAxis.setLabel("Barrels");
        yAxis.setLabel("Minion Food");
        blc.setTitle("Minion Monitoring");

        XYChart.Series<Number,Number> series1 = new XYChart.Series<>();
        series1.setName("Banana");
        series1.getData().add(new XYChart.Data(2, 7));
        series1.getData().add(new XYChart.Data(12, 19));
        series1.getData().add(new XYChart.Data(13, 18));
        series1.getData().add(new XYChart.Data(22, 27));

        XYChart.Series<Number,Number> series2 = new XYChart.Series<>();
        series2.setName("Gelato");
        series2.getData().add(new XYChart.Data(8, 7));
        series2.getData().add(new XYChart.Data(12, 24));
        series2.getData().add(new XYChart.Data(14, 8));
        series2.getData().add(new XYChart.Data(21, 21));
        blc.setData(FXCollections.observableArrayList(series1, series2));
        return blc;
    }

    private ScatterChart<Number,Number> getScatterChart() {
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-100, 200, 100);
        final ScatterChart<Number,Number> sc = new
                ScatterChart<>(xAxis,yAxis);
        xAxis.setLabel("X value");
        yAxis.setLabel("Y value");
        sc.setTitle("Some Random Points");

        XYChart.Series<Number,Number> series1 = new XYChart.Series<>();
        series1.setName("point series 1");
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        series1.getData().add(new XYChart.Data(2.7, 33.6));
        series1.getData().add(new XYChart.Data(5.6, 24.8));
        series1.getData().add(new XYChart.Data(1, 14));
        series1.getData().add(new XYChart.Data(1.3, 24.4));

        XYChart.Series<Number,Number> series2 = new XYChart.Series<>();
        series2.setName("point series 2");
        series2.getData().add(new XYChart.Data(5.2, 29.2));
        series2.getData().add(new XYChart.Data(10.5, 34.6));
        series2.getData().add(new XYChart.Data(3.3, 49.8));
        series2.getData().add(new XYChart.Data(5.8, 44));
        sc.setData(FXCollections.observableArrayList(series1, series2));
        return sc;
    }

    private BarChart<String,Number> getBarChart() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<>(xAxis,yAxis);
        bc.setTitle("Beer Summary");
        xAxis.setLabel("person");
        yAxis.setLabel("bottles");

        XYChart.Series<String,Number> series1 = new XYChart.Series<>();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data("Hendrik", 2631));
        series1.getData().add(new XYChart.Data("Marcel", 1672));
        series1.getData().add(new XYChart.Data("Sven", 2384));

        XYChart.Series<String,Number> series2 = new XYChart.Series<>();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data("Hendrik", 1839));
        series2.getData().add(new XYChart.Data("Marcel", 3275));
        series2.getData().add(new XYChart.Data("Sven", 2476));

        XYChart.Series<String,Number> series3 = new XYChart.Series<>();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data("Hendrik", 1738));
        series3.getData().add(new XYChart.Data("Marcel", 2745));
        series3.getData().add(new XYChart.Data("Sven", 3748));
        bc.setData(FXCollections.observableArrayList(series1, series2, series3));
        return bc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        PieChart pieChart = getPieChart();
        LineChart<Number,Number> lineChart = getLineChart();
        AreaChart<Number,Number> areaChart = getAreaChart();
        BubbleChart<Number,Number> bubbleChart = getBubbleChart();
        ScatterChart<Number,Number> scatterChart = getScatterChart();
        BarChart<String,Number> barChart = getBarChart();

        GridPane gridPane = new GridPane();
        gridPane.getChildren().addAll(pieChart, lineChart, areaChart, bubbleChart, scatterChart, barChart);

        GridPane.setConstraints(pieChart, 0,0);
        GridPane.setConstraints(lineChart, 0,1);
        GridPane.setConstraints(areaChart, 0,2);
        GridPane.setConstraints(bubbleChart, 1,0);
        GridPane.setConstraints(scatterChart, 1,1);
        GridPane.setConstraints(barChart, 1,2);


        Scene myScene = new Scene(gridPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Charts");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}