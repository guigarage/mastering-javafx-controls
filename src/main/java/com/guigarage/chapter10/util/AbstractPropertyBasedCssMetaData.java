package com.guigarage.chapter10.util;

import javafx.beans.property.Property;
import javafx.css.CssMetaData;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableProperty;

public abstract class AbstractPropertyBasedCssMetaData<S extends Styleable, V> extends CssMetaData<S, V> {

    private String propertyName;

    public AbstractPropertyBasedCssMetaData(String property, StyleConverter<?, V> converter, String propertyName, V defaultValue) {
        super(property, converter, defaultValue);
        this.propertyName = propertyName;
    }

    protected abstract <T extends Property<V> & StyleableProperty<V>> T getProperty(S styleable);

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public boolean isSettable(S styleable) {
        Property<V> property = getProperty(styleable);
        return property == null || !property.isBound();
    }

    @Override
    public StyleableProperty<V> getStyleableProperty(S styleable) {
        return (StyleableProperty<V>) getProperty(styleable);
    }

}
