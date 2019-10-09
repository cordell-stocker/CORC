package corc.exception;

public class EmptyDeckException extends RuntimeException {

    public EmptyDeckException() {
        super("Deck is empty.");
    }
}
