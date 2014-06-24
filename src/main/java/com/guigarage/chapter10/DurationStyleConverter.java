package com.guigarage.chapter10;

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class DurationStyleConverter extends StyleConverter<String, Duration> {

    private static DurationStyleConverter instance;

    public static DurationStyleConverter getInstance() {
        if(instance == null) {
            instance = new DurationStyleConverter();
        }
        return instance;
    }

    @Override
    public Duration convert(ParsedValue<String, Duration> value, Font font) {
        String cssProperty = value.getValue();
        if(cssProperty.endsWith("ms")) {
            return Duration.millis(Long.parseLong(cssProperty.substring(0, cssProperty.length() - 2)));
        } else if(cssProperty.endsWith("s")) {
            return Duration.seconds(Long.parseLong(cssProperty.substring(0, cssProperty.length() - 1)));
        }
        return Duration.millis(Long.parseLong(cssProperty));
    }
}
