package corc.exception;

/**
 * This {@link RuntimeException} is to be thrown whenever
 * a consumer of an {@link corc.structure.ICard} receives
 * a subtype that is not permitted.
 */
public class InvalidCardTypeException extends RuntimeException {

	public InvalidCardTypeException() {
		super("Card was not of expected type.");
	}
}
