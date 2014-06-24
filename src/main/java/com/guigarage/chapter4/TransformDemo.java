package com.guigarage.chapter4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.List;

public class TransformDemo  extends Application {

    private StackPane myPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        myPane = new StackPane();

        Transform rotation = new Rotate(45);
        Transform translate = new Translate(24, 24);
        Transform shearing = new Shear(0, 1);

        Button button1 = new Button("Alternative 1");
        button1.setOnAction(e -> useTransforms(rotation, translate));

        Button button2 = new Button("Alternative 2");
        button2.setOnAction(e -> useTransforms(translate, rotation));

        Button button3 = new Button("Alternative 3");
        button3.setOnAction(e -> useTransforms(rotation, shearing, translate));

        HBox menu = new HBox(button1, button2, button3);
        menu.setSpacing(6);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(12));

        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(myPane);
        mainPane.setBottom(menu);

        Scene myScene = new Scene(mainPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("App");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }


    public void useTransforms(Transform... transforms) {
        myPane.getChildren().clear();

        Rectangle origin = new Rectangle(40, 40);
        origin.setStyle("-fx-stroke: blue;" +
                "-fx-fill: darkgrey;");
        origin.setOpacity(0.5d);
        myPane.getChildren().addAll(origin);

        List<Transform> usedTransforms = FXCollections.observableArrayList();
        for(Transform transform : transforms) {
            usedTransforms.add(transform);

            Rectangle r = new Rectangle(40, 40);
            r.setStyle("-fx-stroke: blue;" +
                    "-fx-fill: transparent;");
            r.setOpacity((double) usedTransforms.size() / (double) transforms.length);

            r.getTransforms().addAll(usedTransforms);

            myPane.getChildren().addAll(r);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
