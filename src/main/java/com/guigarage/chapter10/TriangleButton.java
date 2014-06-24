package com.guigarage.chapter10;

import com.guigarage.chapter10.util.CssHelper;
import com.guigarage.chapter10.util.DefaultPropertyBasedCssMetaData;
import com.sun.javafx.css.converters.PaintConverter;
import javafx.beans.property.*;
import javafx.css.CssMetaData;
import javafx.css.PseudoClass;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.List;

public class TriangleButton extends Control {

    private StyleableObjectProperty<Paint> backgroundFill;

    private StyleableObjectProperty<Paint> strokeFill;

    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return TriangleButton.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };

    public TriangleButton() {
       getStyleClass().add("triangle");
        armedProperty().addListener((observable, oldValue, newValue) -> pseudoClassStateChanged(ARMED_PSEUDO_CLASS, newValue));
    }

    private static final PseudoClass ARMED_PSEUDO_CLASS =
            PseudoClass.getPseudoClass("armed");

    private BooleanProperty armed;

    public final void setArmed(boolean armed) {
        armedProperty().set(armed);
    }

    public final boolean isArmed() {
        return armed == null ? false : armed.get();
    }

    public final BooleanProperty armedProperty() {
        if (armed == null) {
            armed = new SimpleBooleanProperty(false);
        }
        return armed;
    }



    @Override
    protected Skin<?> createDefaultSkin() {
        return new TriangleButtonSkin(this);
    }

    public Paint getBackgroundFill() {
        return backgroundFill == null ? Color.DARKGRAY : backgroundFill.get();
    }

    public void setBackgroundFill(Paint backgroundFill) {
        this.backgroundFill.set(backgroundFill);
    }

    public StyleableObjectProperty<Paint> backgroundFillProperty() {
        if (backgroundFill == null) {
            backgroundFill = CssHelper.createProperty(StyleableProperties.BACKGROUND_FILL, TriangleButton.this);
        }
        return backgroundFill;
    }

    public Paint getStrokeFill() {
        return strokeFill == null ? Color.DARKGRAY : strokeFill.get();
    }

    public void setStrokeFill(Paint strokeFill) {
        this.strokeFill.set(strokeFill);
    }

    public StyleableObjectProperty<Paint> strokeFillProperty() {
        if (strokeFill == null) {
            strokeFill = CssHelper.createProperty(StyleableProperties.STROKE_FILL, TriangleButton.this);
        }
        return strokeFill;
    }

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onAction;
    }

    public final EventHandler<ActionEvent> getOnAction() {
        return onActionProperty().get();
    }

    public final void setOnAction(EventHandler<ActionEvent> value) {
        onActionProperty().set(value);
    }

    private static class StyleableProperties {
        private static final DefaultPropertyBasedCssMetaData<TriangleButton, Paint> BACKGROUND_FILL = CssHelper.createMetaData("-fx-triangle-fill", PaintConverter.getInstance(), "backgroundFill", Color.LIGHTGREEN);
        private static final DefaultPropertyBasedCssMetaData<TriangleButton, Paint> STROKE_FILL = CssHelper.createMetaData("-fx-triangle-stroke", PaintConverter.getInstance(), "strokeFill", Color.BLUE);
        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES = CssHelper.createCssMetaDataList(Control.getClassCssMetaData(), BACKGROUND_FILL, STROKE_FILL);
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }
}
