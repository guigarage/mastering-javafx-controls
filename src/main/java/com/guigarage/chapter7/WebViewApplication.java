package com.guigarage.chapter7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        WebView webView = new WebView();
        webView.getEngine().load("http://www.google.de");
        webView.setOnRotate((e) -> webView.setRotate(webView.getRotate() + e.getAngle()));

        StackPane myPane = new StackPane();
        myPane.getChildren().addAll(webView);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.titleProperty().bind(webView.getEngine().titleProperty());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}