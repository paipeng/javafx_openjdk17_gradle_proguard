package com.paipeng;

import javafx.scene.paint.Color;

import java.util.Locale;
import java.util.ResourceBundle;

public class CommonUtils {
    public static Locale getCurrentLanguageLocale() {
        Locale locale;
        if (true) {
            locale = new Locale("zh", "Zh");

        } else {
            locale = new Locale("en", "En");

        }
        return locale;
    }

    public static ResourceBundle getStringResource() {
        ResourceBundle resources = ResourceBundle.getBundle("bundles.languages", getCurrentLanguageLocale());
        return resources;
    }

    public static String getString(String key) {
        try {
            ResourceBundle resources = ResourceBundle.getBundle("bundles.languages", getCurrentLanguageLocale());
            return resources.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
