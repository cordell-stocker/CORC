package structure;

/**
 * The Representation of the face of a card.
 * <p>
 * SHOULD be immutable.
 * <p>
 * For example: In a standard 52 card deck,
 * the 'Five of Spades' has a face of 'Five'.
 *
 * @param <F> the object implementing this. Used to reference the subclass for the Comparable interface.
 */
public interface IFace<F extends IFace> extends CardProperty<F> {

    /**
     * SHOULD be unique to this Face.
     * <p>
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * 'Five'. As would the 'Five of Hearts', since
     * 'Five' is the face value. While the 'Six
     * of Spades' SHOULD return a different string.
     *
     * @return The String representation of this Face.
     */
    @Override
    String getName();

    /**
     * SHOULD be unique to this Face.
     * <p>
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * '5'. As would the 'Five of Hearts', since
     * 'Five' is the face value. While the 'Six
     * of Spades' SHOULD return a different value.
     *
     * @return The integer value of this Face.
     */
    @Override
    int getValue();
}
