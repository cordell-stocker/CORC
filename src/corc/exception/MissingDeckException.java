package corc.exception;

/**
 * This {@link RuntimeException} is to be thrown whenever
 * the singleton {@link corc.structure.IDeck} is attempted
 * to be retrieved, but one has not been set.
 */
public class MissingDeckException extends NullPointerException {

	public MissingDeckException() {
		super("No deck was found");
	}
}
