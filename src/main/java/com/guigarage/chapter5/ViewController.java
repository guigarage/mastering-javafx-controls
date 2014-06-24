package com.guigarage.chapter5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class ViewController {

    @FXML
    private Slider redSlider;

    @FXML
    private Slider greenSlider;

    @FXML
    private Slider blueSlider;

    @FXML
    private TextField redField;

    @FXML
    private TextField greenField;

    @FXML
    private TextField blueField;

    @FXML
    private CheckBox invertCheckbox;

    @FXML
    private CheckBox saturateCheckbox;

    @FXML
    private Slider rotationSlider;

    @FXML
    private Slider scaleSlider;

    @FXML
    private RadioButton rectangleToggle;

    @FXML
    private RadioButton circleToggle;

    @FXML
    private RadioButton textToggle;

    @FXML
    private StackPane canvas;

    private ToggleGroup group;

    public void initialize() {
        rectangleToggle.setUserData(new Rectangle(50, 50));
        circleToggle.setUserData(new Circle(20));
        textToggle.setUserData(new Text("TEXT"));

        group = new ToggleGroup();
        rectangleToggle.setToggleGroup(group);
        circleToggle.setToggleGroup(group);
        textToggle.setToggleGroup(group);
        group.selectToggle(rectangleToggle);

        redField.textProperty().bind(redSlider.valueProperty().asString());
        greenField.textProperty().bind(greenSlider.valueProperty().asString());
        blueField.textProperty().bind(blueSlider.valueProperty().asString());

        redSlider.valueProperty().addListener(event -> setColor());
        greenSlider.valueProperty().addListener(event -> setColor());
        blueSlider.valueProperty().addListener(event -> setColor());
        group.selectedToggleProperty().addListener(event -> setColor());

        invertCheckbox.selectedProperty().addListener(event -> setColor());
        saturateCheckbox.selectedProperty().addListener(event -> setColor());

        canvas.rotateProperty().bind(rotationSlider.valueProperty());
        canvas.scaleXProperty().bindBidirectional(scaleSlider.valueProperty());
        canvas.scaleYProperty().bindBidirectional(scaleSlider.valueProperty());

        setColor();
    }

    private void setColor() {
        canvas.getChildren().clear();
        Shape shape = (Shape) group.getSelectedToggle().getUserData();
        Color color = Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue());
        if(invertCheckbox.isSelected()) {
            color = color.invert();
        }
        if(saturateCheckbox.isSelected()) {
            color = color.saturate();
        }
        shape.setFill(color);
        canvas.getChildren().add(shape);
    }
}
