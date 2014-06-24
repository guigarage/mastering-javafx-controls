package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleControls  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label userLabel = new Label("User:");

        Label passwordLabel = new Label("Password:");

        TextField userNameField = new TextField();
        userNameField.setPromptText("username");


        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("password");

        Button button = new Button("Login");

        passwordField.disableProperty().bind(userNameField.textProperty().isEmpty());
        button.disableProperty().bind(userNameField.textProperty().isEmpty().or(passwordField.textProperty().isEmpty()));

        button.setOnAction(event -> System.out.println("Login: " + userNameField.getText() + " / " + passwordField.getText()));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(6);
        gridPane.setVgap(6);
        gridPane.setPadding(new Insets(6));

        gridPane.add(userLabel, 0, 0);
        gridPane.add(userNameField, 1, 0);

        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        gridPane.add(button, 0, 2, 2, 1);
        GridPane.setHalignment(button, HPos.CENTER);


       // gridPane.getStyleClass().add("login-pane");
      //  userLabel.getStyleClass().add("login-label");
      //  passwordLabel.getStyleClass().add("login-label");
      //  button.getStyleClass().add("login-button");
      //  userNameField.getStyleClass().add("login-textfield");
      //  passwordField.getStyleClass().add("login-textfield");

        gridPane.setId("login-pane");

        Scene myScene = new Scene(gridPane);
//        myScene.getStylesheets().add(getClass().getResource("custom.css").toExternalForm());

        primaryStage.setScene(myScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}