package src.main.Week3.libraries;

import java.util.EnumSet;

public enum Genre {
    DETECTIVE("Detective"),
    NOVEL("Novel"),
    ROMAN("Roman");

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}