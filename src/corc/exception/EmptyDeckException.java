package corc.exception;

/**
 * This {@link RuntimeException} is to be thrown whenever an
 * {@link corc.structure.ICard} object is attempted
 * to be retrieved from an {@link corc.structure.IDeck}
 * object that is empty.
 */
public class EmptyDeckException extends RuntimeException {

	public EmptyDeckException() {
		super("Deck is empty.");
	}
}