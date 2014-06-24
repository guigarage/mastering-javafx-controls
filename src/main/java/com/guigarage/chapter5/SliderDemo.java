package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class SliderDemo  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Slider slider1 = new Slider(-200, 200, 23);
        slider1.setMajorTickUnit(25);
        slider1.setShowTickLabels(true);
        slider1.setShowTickMarks(true);
        slider1.setBlockIncrement(25);
        slider1.setSnapToTicks(true);
        slider1.setMinorTickCount(25);
        slider1.setOrientation(Orientation.VERTICAL);
        slider1.setLabelFormatter(new StringConverter<Double>(){
            @Override
            public String toString(Double object) {
                return object + " °C";
            }

            @Override
            public Double fromString(String string) {
                return new Double(string.substring(0, string.length() - 3));
            }
        });
        slider1.valueProperty().addListener((e) -> System.out.println(slider1.getValue() + " °C selected"));

        Slider slider2 = new Slider(-1.0, 1.0, 0.5);
        slider2.setMajorTickUnit(0.05);
        slider2.setShowTickLabels(false);
        slider2.setShowTickMarks(true);

        HBox box = new HBox(slider1, slider2);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(12));
        HBox.setHgrow(slider2, Priority.ALWAYS);
        Scene myScene = new Scene(box);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Sliders");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
