package com.guigarage.chapter4;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Orientation;
import javafx.scene.layout.Region;

public class AreaRegion extends Region {

    private ObjectProperty<Orientation> contentBias;

    public final ObjectProperty<Orientation> contentBiasProperty() {
        if (contentBias == null) {
            contentBias = new SimpleObjectProperty<Orientation>(null) {
                @Override
                protected void invalidated() {
                    super.invalidated();
                    requestLayout();
                }
            };
        }
        return contentBias;
    }

    public final void setContentBias(Orientation value) { contentBiasProperty().set(value); }

    @Override
    public Orientation getContentBias() {
        return contentBias == null ? null : contentBias.get();
    }


    private DoubleProperty surfaceArea;

    public final DoubleProperty surfaceAreaProperty() {
        if (surfaceArea == null) {
            surfaceArea = new SimpleDoubleProperty(64000.0) {
                @Override
                protected void invalidated() {
                    super.invalidated();
                    requestParentLayout();
                }
            };
        }
        return surfaceArea;
    }

    public final void setSurfaceArea(double value) { surfaceAreaProperty().set(value); }
    public final double getSurfaceArea() { return surfaceArea == null ? 64000.0 : surfaceArea.get(); }

    @Override
    protected double computeMaxHeight(double width) {
        if (width < 0) {
            return Double.MAX_VALUE;
        } else {
            return getSurfaceArea() / width;
        }
    }

    @Override
    protected double computeMaxWidth(double height) {
        if (height < 0) {
            return Double.MAX_VALUE;
        } else {
            return getSurfaceArea() / height;
        }
    }

    @Override
    protected double computeMinHeight(double width) {
        if (width < 0) {
            return Double.MIN_VALUE;
        } else {
            return getSurfaceArea() / width;
        }
    }

    @Override
    protected double computeMinWidth(double height) {
        if (height < 0) {
            return Double.MIN_VALUE;
        } else {
            return getSurfaceArea() / height;
        }
    }

    @Override
    protected double computePrefHeight(double width) {
        if (width < 0) {
            return Math.sqrt(getSurfaceArea());
        } else {
            return getSurfaceArea() / width;
        }
    }

    @Override
    protected double computePrefWidth(double height) {
        if (height < 0) {
            return Math.sqrt(getSurfaceArea());
        } else {
            return getSurfaceArea() / height;
        }
    }

}
