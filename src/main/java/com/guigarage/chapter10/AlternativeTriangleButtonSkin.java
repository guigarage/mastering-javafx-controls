package com.guigarage.chapter10;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Region;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class AlternativeTriangleButtonSkin extends SkinBase<TriangleButton> {

    private Path triangle;
    private boolean invalidTriangle = true;


    public AlternativeTriangleButtonSkin(TriangleButton control) {
        super(control);
        control.widthProperty().addListener(observable -> invalidTriangle = true);
        control.heightProperty().addListener(observable -> invalidTriangle = true);
        control.backgroundFillProperty().addListener(observable -> updateTriangleColor());
        control.strokeFillProperty().addListener(observable -> updateTriangleColor());

        getSkinnable().setMaxWidth(Region.USE_PREF_SIZE);
        getSkinnable().setMaxHeight(Region.USE_PREF_SIZE);
        getSkinnable().setMinWidth(Region.USE_PREF_SIZE);
        getSkinnable().setMinHeight(Region.USE_PREF_SIZE);
    }

    public void updateTriangleColor() {
        if (triangle != null) {
            triangle.setFill(getSkinnable().getBackgroundFill());
            triangle.setStroke(getSkinnable().getStrokeFill());
            getSkinnable().requestLayout();
        }
    }

    public void updateTriangle(double width, double height) {
        if (triangle != null) {
            getChildren().remove(triangle);
        }
        triangle = new Path();
        triangle.getElements().add(new MoveTo(width / 2, height));
        triangle.getElements().add(new LineTo(width, 0));
        triangle.getElements().add(new LineTo(0, 0));
        triangle.getElements().addAll(new ClosePath());

        updateTriangleColor();

        triangle.setOnMouseClicked((e) -> getSkinnable().fireEvent(new ActionEvent()));

        triangle.setOnMousePressed((e) -> getSkinnable().setArmed(true));
        triangle.setOnMouseReleased((e) -> getSkinnable().setArmed(false));

        getChildren().add(triangle);
    }

    @Override
    protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return topInset + bottomInset + 120;
    }

    @Override
    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return rightInset + leftInset + 120;
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        if (invalidTriangle) {
            updateTriangle(contentWidth, contentHeight);
            invalidTriangle = false;
        }
        layoutInArea(triangle, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
    }

}
