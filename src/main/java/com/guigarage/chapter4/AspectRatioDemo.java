package com.guigarage.chapter4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AspectRatioDemo  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AreaRegion region = new AreaRegion();
        region.setContentBias(Orientation.VERTICAL);
        region.setStyle("-fx-border-width: 3;" +
                "-fx-border-color: black;" +
                "-fx-background-color: lightblue;");

        StackPane myPane = new StackPane();
        myPane.setPadding(new Insets(24));
        myPane.getChildren().add(region);

        Button verticalButton = new Button("Vertical");
        verticalButton.setOnAction(e -> region.setContentBias(Orientation.VERTICAL));
        Button horizontalButton = new Button("Horizontal");
        horizontalButton.setOnAction(e -> region.setContentBias(Orientation.HORIZONTAL));
        HBox buttonPane = new HBox(verticalButton, horizontalButton);
        buttonPane.setSpacing(12);

        Slider surfaceAreaSlider = new Slider(0, 640000.0, 64000.0);
        region.surfaceAreaProperty().bind(surfaceAreaSlider.valueProperty());

        VBox mainPane = new VBox(myPane, buttonPane, surfaceAreaSlider);

        Scene myScene = new Scene(mainPane);

        primaryStage.setScene(myScene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
