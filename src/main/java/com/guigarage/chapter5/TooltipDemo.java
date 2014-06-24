package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class TooltipDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label rectLabel = new Label("Rectangle");
        Tooltip rectTooltip = new Tooltip();
        rectTooltip.setGraphic(new Button("CLICK"));
        rectLabel.setTooltip(rectTooltip);

        Label circleLabel = new Label("Circle");
        Tooltip circleTooltip = new Tooltip();
        circleTooltip.setGraphic(new Circle(20, 20, 40, Color.ORANGE));
        circleLabel.setTooltip(circleTooltip);

        VBox myPane = new VBox();
        myPane.setPadding(new Insets(12));
        myPane.setSpacing(12);
        myPane.setAlignment(Pos.CENTER);
        myPane.getChildren().addAll(rectLabel, circleLabel);
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
