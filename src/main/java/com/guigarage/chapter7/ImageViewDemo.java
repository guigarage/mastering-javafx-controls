package com.guigarage.chapter7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane myPane = new StackPane();

        Image image = new Image(getClass().getResource("pic.jpg").toString());

        ImageView imageView = new ImageView(image);

        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(myPane.widthProperty());
        imageView.fitHeightProperty().bind(myPane.heightProperty());

        myPane.getChildren().add(imageView);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Image Viewer");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}