package src.main.Week6.project.game;

public enum ShotResult {
    MISS("miss"),
    HIT("hit"),
    SUNK("sunk");

    private final String description;

    ShotResult(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
