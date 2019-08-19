package exception;

public class MissingDeckException extends NullPointerException {

    public MissingDeckException() {
        super("No deck was found");
    }
}
