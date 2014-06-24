package com.guigarage.chapter6;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ColorListCell extends ListCell<Color> {

    @Override
    protected void updateItem(Color item, boolean empty) {
        super.updateItem(item, empty);
        updateViewMode();
    }

    private void updateViewMode() {
        setGraphic(null);
        setText(null);
        if (isEditing()) {
            VBox box = new VBox();
            Label redLabel = new Label("Red:");
            Label greenLabel = new Label("Green:");
            Label blueLabel = new Label("Blue:");
            TextField redTextField = new TextField();
            TextField greenTextField = new TextField();
            TextField blueTextField = new TextField();

            if (getItem() != null) {
                redTextField.setText((int) (getItem().getRed() * 255) + "");
                greenTextField.setText((int) (getItem().getGreen() * 255) + "");
                blueTextField.setText((int) (getItem().getBlue() * 255) + "");
            }

            Button setColorButton = new Button("SET");
            setColorButton.setOnAction((e) -> commitEdit(Color.rgb(new Integer(redTextField.getText()),
                    new Integer(greenTextField.getText()),
                    new Integer(blueTextField.getText()))));

            box.getChildren().addAll(redLabel, redTextField, greenLabel, greenTextField, blueLabel, blueTextField, setColorButton);
            setGraphic(box);
        } else {
            if (getItem() != null) {
                setGraphic(new Circle(10, 10, 20, getItem()));
                setText("Red: " + (int) (getItem().getRed() * 255.0) + ", Green: " + (int) (getItem().getGreen() * 255.0) + ", Blue: " + (int) (getItem().getBlue() * 255.0));
            }
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        updateViewMode();
    }


}
