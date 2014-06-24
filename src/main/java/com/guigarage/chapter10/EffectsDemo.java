package com.guigarage.chapter10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EffectsDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button reflectionButton = new Button("Reflection");
        reflectionButton.setEffect(new Reflection());

        Button dropShadowButton = new Button("DropShadow");
        dropShadowButton.setEffect(new DropShadow());

        Button boxBlurButton = new Button("BoxBlur");
        boxBlurButton.setEffect(new BoxBlur());

        Button sepiaToneButton = new Button("SepiaTone");
        sepiaToneButton.setEffect(new SepiaTone());

        Button multipleEffectsButton = new Button("Mixed");
        SepiaTone effect = new SepiaTone();
        effect.setInput(new Reflection());
        multipleEffectsButton.setEffect(effect);


        VBox myPane = new VBox();
        myPane.setPadding(new Insets(24));
        myPane.setAlignment(Pos.CENTER);
        myPane.setSpacing(42);
        myPane.getChildren().addAll(reflectionButton, dropShadowButton, boxBlurButton, sepiaToneButton, multipleEffectsButton);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

}
