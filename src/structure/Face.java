package structure;

/**
 * The Representation of the face of a card.
 *
 * For example: In a standard 52 card deck,
 * the 'Five of Spades' has a face of 'Five'.
 *
 * @param <F> The subclass interfacing this.
 */
public interface Face<F extends Face> extends CardProperty<F> {

    /**
     * Should be unique to this Face.
     *
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * 'Five'. As would the 'Five of Hearts', since
     * 'Five' is the face value. While the 'Six
     * of Spades' would return a different string.
     *
     * @return The word representation of this Face.
     */
    String getName();

    /**
     * Should be unique to this Face.
     *
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * '5'. As would the 'Five of Hearts', since
     * 'Five' is the face value. While the 'Six
     * of Spades' would return a different value.
     *
     * The main purpose of this method is to be
     * used in the Comparable interface method(s).
     *
     * @return The integer value of this Face.
     */
    int getValue();
}
