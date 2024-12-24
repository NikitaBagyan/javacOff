package src.main.Week6.project.client;

public class GameOverException extends RuntimeException {
    public GameOverException(String message) {
        super(message);
    }

    public GameOverException(String message, Throwable cause) {
        super(message, cause);
    }
}