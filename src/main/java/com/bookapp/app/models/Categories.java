package com.bookapp.app.models;

import java.util.ArrayList;
import java.util.List;

public enum Categories {
    KIDS("Kids"),
    THRILLER("Thriller"),
    HORROR("Horror"),
    SCIENCE_FICTION("Science Fiction");

    private String description;

    Categories(String description) {
        this.description = description;
    }

    public static List<String> getDescriptions() {
        List<String> descriptions = new ArrayList<>();
        descriptions.add(Categories.KIDS.getDescription());
        descriptions.add(Categories.THRILLER.getDescription());
        descriptions.add(Categories.HORROR.getDescription());
        descriptions.add(Categories.SCIENCE_FICTION.getDescription());
        return descriptions;
    }

    public String getDescription() {
        return description;
    }
}
