package com.guigarage.chapter8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class SwingNodeDemo extends Application {

    private Button jfxButton;

    private JButton swingButton;

    @Override
    public void start(Stage primaryStage) throws Exception {

        jfxButton = new Button("JavaFX Button");
        jfxButton.setOnAction((e) -> {
            SwingUtilities.invokeLater(() -> {
                swingButton.setEnabled(!swingButton.isEnabled());
            });
        });

        SwingNode swingNode = new SwingNode();

        SwingUtilities.invokeLater(() -> {
            swingButton = new JButton("Swing Button");
            swingButton.addActionListener((e) -> {
                Platform.runLater(() -> {
                    jfxButton.setDisable(!jfxButton.isDisabled());
                });
            });
            swingNode.setContent(swingButton);
        });



        VBox myPane = new VBox();
        myPane.setPadding(new Insets(12));
        myPane.setAlignment(Pos.CENTER);
        myPane.setSpacing(12);
        myPane.getChildren().addAll(jfxButton, swingNode);
        Scene myScene = new Scene(myPane);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
