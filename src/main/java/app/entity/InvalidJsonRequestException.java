package app.entity;

public class InvalidJsonRequestException extends RuntimeException {
    public InvalidJsonRequestException(String message) {
        super(message);
    }
}
