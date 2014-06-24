package com.guigarage.chapter10.util;

import javafx.beans.property.Property;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;

public class DefaultPropertyBasedCssMetaData<S extends Styleable, V> extends AbstractPropertyBasedCssMetaData<S, V> {

    public DefaultPropertyBasedCssMetaData(String property, StyleConverter<?, V> converter, String propertyName, V defaultValue) {
        super(property, converter, propertyName, defaultValue);
    }

    protected <T extends Property<V> & StyleableProperty<V>> T getProperty(S styleable) {
        try {
            return (T) styleable.getClass().getMethod(getPropertyName() + "Property").invoke(styleable);
        } catch (Exception e) {
            throw new RuntimeException("Can't get StyleableProperty", e);
        }
    }
}