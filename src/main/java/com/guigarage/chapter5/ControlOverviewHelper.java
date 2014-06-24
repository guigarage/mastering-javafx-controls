package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ControlOverviewHelper extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Button");
        CheckBox checkbox = new CheckBox("CheckBox");
        Hyperlink hyperlink = new Hyperlink("Hyperlink");
        ToggleButton toggleButton = new ToggleButton("ToggleButton");
        RadioButton radioButton = new RadioButton("RadioButton");
        Label label = new Label("Label");
        TextField textField = new TextField("TextField");
        PasswordField passwordField = new PasswordField();
        TextArea textArea = new TextArea("TextArea");
        ProgressIndicator progressIndicator = new ProgressIndicator();
        ProgressBar progressBar = new ProgressBar();
        Slider slider = new Slider();
        Separator separator = new Separator();

        VBox myPane = new VBox(button, checkbox, hyperlink, toggleButton, radioButton, label, textField, textArea, progressIndicator, progressBar, slider);
        myPane.setSpacing(18);
        myPane.setAlignment(Pos.CENTER);
        myPane.setPadding(new Insets(12));
        //myPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene myScene = new Scene(myPane);

        setUserAgentStylesheet(STYLESHEET_CASPIAN);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("App");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

}