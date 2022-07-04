package by.divergenny.traveler.exception;

public class BaseException extends RuntimeException {

    private String message;

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

}
