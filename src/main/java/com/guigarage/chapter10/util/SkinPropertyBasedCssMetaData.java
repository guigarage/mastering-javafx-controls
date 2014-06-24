package com.guigarage.chapter10.util;

import javafx.beans.property.Property;
import javafx.css.StyleConverter;
import javafx.css.StyleableProperty;
import javafx.scene.control.Control;

public class SkinPropertyBasedCssMetaData<S extends Control, V> extends AbstractPropertyBasedCssMetaData<S, V> {

    public SkinPropertyBasedCssMetaData(String property, StyleConverter<?, V> converter, String propertyName, V defaultValue) {
        super(property, converter, propertyName, defaultValue);
    }

    protected <T extends Property<V> & StyleableProperty<V>> T getProperty(S styleable) {
        try {
            return (T) styleable.getSkin().getClass().getMethod(getPropertyName() + "Property").invoke(styleable.getSkin());
        } catch (Exception e) {
            throw new RuntimeException("Can't get StyleableProperty", e);
        }
    }
}