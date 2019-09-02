package exception;

@SuppressWarnings("unused")
public class InvalidCardTypeException extends RuntimeException {

    public InvalidCardTypeException() {
        super("Card was not of expected type.");
    }
}
