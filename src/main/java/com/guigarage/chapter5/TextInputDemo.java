package com.guigarage.chapter5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextInputDemo extends Application {


    private Button createNotFocusableButton(String label) {
        Button b = new Button() {
            @Override
            public void requestFocus() {}
        };
        b.setText(label);
        return b;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea("You’ve never heard of the Millennium Falcon? … It’s the ship that made the Kessel run in less than 12 parsecs.");
        textArea.setPrefColumnCount(60);
        textArea.setWrapText(true);
        textArea.setFont(new Font(32));

        Button caretLeftLabel = createNotFocusableButton("<");
        caretLeftLabel.setFont(new Font(24));
        caretLeftLabel.setTextFill(Color.BLUE);
        caretLeftLabel.setOnAction((e) -> textArea.backward());

        Label caretRightLabel = new Label(">");
        caretRightLabel.setFont(new Font(24));
        caretRightLabel.setTextFill(Color.BLUE);
        caretRightLabel.setOnMouseEntered((e) -> caretRightLabel.setTextFill(Color.ORANGE));
        caretRightLabel.setOnMouseExited((e) -> caretRightLabel.setTextFill(Color.BLUE));
        caretRightLabel.setOnMouseClicked((e) -> textArea.forward());

        Label caretStartLabel = new Label("<<");
        caretStartLabel.setFont(new Font(24));
        caretStartLabel.setTextFill(Color.BLUE);
        caretStartLabel.setOnMouseEntered((e) -> caretStartLabel.setTextFill(Color.ORANGE));
        caretStartLabel.setOnMouseExited((e) -> caretStartLabel.setTextFill(Color.BLUE));
        caretStartLabel.setOnMouseClicked((e) -> textArea.home());

        Label caretEndLabel = new Label(">>");
        caretEndLabel.setFont(new Font(24));
        caretEndLabel.setTextFill(Color.BLUE);
        caretEndLabel.setOnMouseEntered((e) -> caretEndLabel.setTextFill(Color.ORANGE));
        caretEndLabel.setOnMouseExited((e) -> caretEndLabel.setTextFill(Color.BLUE));
        caretEndLabel.setOnMouseClicked((e) -> textArea.end());

        Label wrapLabel = new Label("w");
        wrapLabel.setFont(new Font(24));
        wrapLabel.setTextFill(Color.BLUE);
        wrapLabel.setOnMouseEntered((e) -> wrapLabel.setTextFill(Color.ORANGE));
        wrapLabel.setOnMouseExited((e) -> wrapLabel.setTextFill(Color.BLUE));
        wrapLabel.setOnMouseClicked((e) -> textArea.setWrapText(!textArea.isWrapText()));

        HBox menu = new HBox(caretStartLabel, caretLeftLabel, wrapLabel, caretRightLabel, caretEndLabel);
        menu.setSpacing(12);
        menu.setAlignment(Pos.CENTER);

        VBox box = new VBox(menu, textArea);

        Scene myScene = new Scene(box);

        primaryStage.setScene(myScene);
        primaryStage.setTitle("App");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
