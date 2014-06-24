package com.guigarage.chapter10.util;

import javafx.css.*;
import javafx.scene.control.Control;
import javafx.scene.control.SkinBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CssHelper {

    public static List<CssMetaData<? extends Styleable, ?>> createCssMetaDataList(List<CssMetaData<? extends Styleable, ?>> baseList, CssMetaData<? extends Styleable, ?>... metaData) {
        List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<>(baseList);
        styleables.addAll(Arrays.asList(metaData));
        return Collections.unmodifiableList(styleables);
    }

    public static List<CssMetaData<? extends Styleable, ?>> createCssMetaDataList(CssMetaData<? extends Styleable, ?>... metaData) {
        return createCssMetaDataList(new ArrayList<>(), metaData);
    }

    public static <S extends Styleable, V> StyleableObjectProperty<V> createProperty(DefaultPropertyBasedCssMetaData<S, V> metaData, S styleable) {
        return new SimpleStyleableObjectProperty<V>(metaData, styleable, metaData.getPropertyName(), metaData.getInitialValue(styleable));
    }

    public static <S extends Control, V> StyleableObjectProperty<V> createProperty(SkinPropertyBasedCssMetaData<S, V> metaData, SkinBase<S> skin) {
        return new SimpleStyleableObjectProperty<V>(metaData, skin, metaData.getPropertyName(), metaData.getInitialValue(skin.getSkinnable()));
    }

    public static <S extends Styleable, V> DefaultPropertyBasedCssMetaData<S, V> createMetaData(String property, StyleConverter<?, V> converter, String propertyName, V defaultValue) {
        return new DefaultPropertyBasedCssMetaData<S, V>(property, converter, propertyName, defaultValue);
    }

    public static <S extends Control, V> SkinPropertyBasedCssMetaData<S, V> createSkinMetaData(String property, StyleConverter<?, V> converter, String propertyName, V defaultValue) {
        return new SkinPropertyBasedCssMetaData<S, V>(property, converter, propertyName, defaultValue);
    }
}
