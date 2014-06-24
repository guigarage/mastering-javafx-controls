package com.guigarage.chapter4;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedPane extends Pane {

    public SortedPane() {
        super();
        spacingProperty().addListener(e -> requestLayout());
    }

    public SortedPane(double spacing) {
        this();
        setSpacing(spacing);
    }

    public final DoubleProperty spacingProperty() {
        if (spacing == null) {
            spacing = new SimpleDoubleProperty(0) {
                @Override
                protected void invalidated() {
                    super.invalidated();
                    requestLayout();
                }
            };
        }
        return spacing;
    }

    private DoubleProperty spacing;
    public final void setSpacing(double value) { spacingProperty().set(value); }
    public final double getSpacing() { return spacing == null ? 0 : spacing.get(); }

    @Override
    protected void layoutChildren() {
        List<Node> sortedChildren = new ArrayList<>(getChildren());
        Collections.sort(sortedChildren, (c1, c2) -> new Double(c1.prefWidth(-1)).compareTo(new Double(c2.prefWidth(-1))));

        double currentX = getInsets().getLeft();

        for(Node c : sortedChildren) {
            double width = c.prefWidth(-1);
            double height = c.prefHeight(-1);
            layoutInArea(c, currentX, getInsets().getTop(), width, height, 0,HPos.CENTER, VPos.CENTER);
            currentX = currentX + width + getSpacing();
        }

    }

    @Override
    protected double computePrefHeight(double width) {
        double maxHeight = 0;
        for(Node c : getChildren()) {
            maxHeight = Math.max(c.prefHeight(-1), maxHeight);
        }
        return getInsets().getTop() + getInsets().getBottom() + maxHeight;
    }

    @Override
    protected double computePrefWidth(double height) {
        double width = 0;
        for(Node c : getChildren()) {
            width = width + c.prefWidth(-1);
        }
        double cumulatedSpacing = 0;
        if(getChildren().size() > 1) {
            cumulatedSpacing =  (getChildren().size() - 1) * getSpacing();
        }

        return getInsets().getLeft() + getInsets().getRight() + width + cumulatedSpacing;
    }

    @Override
    protected double computeMaxHeight(double width) {
        return computePrefHeight(width);
    }

    @Override
    protected double computeMaxWidth(double height) {
        return computePrefWidth(height);
    }

    @Override
    protected double computeMinHeight(double width) {
        return computePrefHeight(width);
    }

    @Override
    protected double computeMinWidth(double height) {
        return computePrefWidth(height);
    }
}
