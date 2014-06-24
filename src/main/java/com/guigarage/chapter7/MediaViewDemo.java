package com.guigarage.chapter7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Media media = new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
        MediaPlayer player = new MediaPlayer(media);
        MediaView mediaView = new MediaView(player);

        Button playButton = new Button("play");
        playButton.setOnAction((e) -> player.play());

        Button pauseButton = new Button("pause");
        pauseButton.setOnAction((e) -> player.pause());

        HBox myPane = new HBox();
        myPane.getChildren().addAll(mediaView, playButton, pauseButton);
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