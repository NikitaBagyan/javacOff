package src.main.Week6.project.game;

public enum GameStatus {

    INITIALIZING("initializing"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed");

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
