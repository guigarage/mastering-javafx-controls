package com.guigarage.chapter10;

import com.guigarage.chapter10.util.CssHelper;
import com.guigarage.chapter10.util.SkinPropertyBasedCssMetaData;
import javafx.animation.ScaleTransition;
import javafx.beans.InvalidationListener;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.SkinBase;
import javafx.scene.effect.InnerShadow;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.List;

public class TriangleButtonSkin extends SkinBase<TriangleButton> {

    private Path triangle;
    private boolean invalidTriangle = true;
    private ScaleTransition scaleTransition;
    private StyleableObjectProperty<Duration> scaleTransitionTime;

    private InvalidationListener invalidTriangleListener = observable -> invalidTriangle = true;
    private InvalidationListener updateTriangleColorListener = observable -> updateTriangleColor();
    private InvalidationListener updateEffectListener = observable -> updateEffect();

    protected TriangleButtonSkin(TriangleButton control) {
        super(control);
        control.widthProperty().addListener(invalidTriangleListener);
        control.heightProperty().addListener(invalidTriangleListener);
        control.backgroundFillProperty().addListener(updateTriangleColorListener);
        control.strokeFillProperty().addListener(updateTriangleColorListener);
        control.armedProperty().addListener(updateEffectListener);
    }

    @Override
    public void dispose() {
        if(scaleTransition != null) {
            scaleTransition.stop();
            scaleTransition = null;
        }

        getSkinnable().widthProperty().removeListener(invalidTriangleListener);
        getSkinnable().heightProperty().removeListener(invalidTriangleListener);
        getSkinnable().backgroundFillProperty().removeListener(updateTriangleColorListener);
        getSkinnable().strokeFillProperty().removeListener(updateTriangleColorListener);
        getSkinnable().armedProperty().removeListener(updateEffectListener);

        getChildren().clear();

        super.dispose();
    }

    protected void updateEffect() {
        if (getSkinnable().isArmed()) {
            if (triangle != null) {
                InnerShadow innerShadow = new InnerShadow();
                innerShadow.setOffsetX(1.0f);
                innerShadow.setOffsetY(1.0f);
                triangle.setEffect(innerShadow);
            }
        } else {
            if (triangle != null) {
                triangle.setEffect(null);
            }
        }
    }

    public Duration getScaleTransitionTime() {
        return scaleTransitionTime.get();
    }

    public void setScaleTransitionTime(Duration scaleTransitionTime) {
        this.scaleTransitionTime.set(scaleTransitionTime);
    }

    public StyleableObjectProperty<Duration> scaleTransitionTimeProperty() {
        if (scaleTransitionTime == null) {
            scaleTransitionTime = CssHelper.createProperty(StyleableProperties.SCALE_TRANSITION_TIME, TriangleButtonSkin.this);
        }
        return scaleTransitionTime;
    }

    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return StyleableProperties.STYLEABLES;
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
        triangle.getElements().add(new MoveTo(width / 2, 0));
        triangle.getElements().add(new LineTo(width, height));
        triangle.getElements().add(new LineTo(0, height));
        triangle.getElements().addAll(new ClosePath());
        updateTriangleColor();
        updateEffect();
        triangle.setOnMouseEntered((e) -> zoomIn());
        triangle.setOnMouseExited((e) -> zoomOut());
        triangle.setOnMouseClicked((e) -> getSkinnable().fireEvent(new ActionEvent()));
        triangle.setOnMousePressed((e) -> getSkinnable().setArmed(true));
        triangle.setOnMouseReleased((e) -> getSkinnable().setArmed(false));
        getChildren().add(triangle);
    }

    private void zoomIn() {
        if (scaleTransition != null) {
            scaleTransition.pause();
        }
        scaleTransition = new ScaleTransition(scaleTransitionTimeProperty().get(), triangle);
        scaleTransition.setFromX(triangle.getScaleX());
        scaleTransition.setFromY(triangle.getScaleY());
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.play();
    }

    private void zoomOut() {
        if (scaleTransition != null) {
            scaleTransition.pause();
        }
        scaleTransition = new ScaleTransition(scaleTransitionTimeProperty().get(), triangle);
        scaleTransition.setFromX(triangle.getScaleX());
        scaleTransition.setFromY(triangle.getScaleY());
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.play();
    }

    @Override
    protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return topInset + bottomInset + 200;
    }

    @Override
    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return rightInset + leftInset + 200;
    }

    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return 20 + topInset + bottomInset;
    }

    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return 20 + rightInset + leftInset;
    }

    @Override
    protected double computeMaxWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
    }

    @Override
    protected double computeMaxHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return computePrefHeight(width, topInset, rightInset, bottomInset, leftInset);
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        if (invalidTriangle) {
            updateTriangle(contentWidth, contentHeight);
            invalidTriangle = false;
        }
        layoutInArea(triangle, contentX, contentY, contentWidth, contentHeight, -1, HPos.CENTER, VPos.CENTER);
    }
    private static class StyleableProperties {
        private static final SkinPropertyBasedCssMetaData<TriangleButton, Duration> SCALE_TRANSITION_TIME = CssHelper.createSkinMetaData("-fx-animation-duration", DurationStyleConverter.getInstance(), "scaleTransitionTime", Duration.millis(250));
        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES = CssHelper.createCssMetaDataList(TriangleButton.getClassCssMetaData(), SCALE_TRANSITION_TIME);
    }

}