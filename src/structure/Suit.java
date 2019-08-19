package structure;

/**
 * The Representation of the suit of a card.
 *
 * For example: In a standard 52 card deck,
 * the 'Five of Spades' has a suit of 'Spades'.
 *
 * @param <S> The subclass interfacing this.
 */
public interface Suit<S extends Suit> extends CardProperty<S> {

    /**
     * Should be unique to this Suit.
     *
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * 'Spades'. As would the 'Five of Hearts', since
     * 'Spades' is the suit. While the 'Six
     * of Spades' would return a different string.
     *
     * @return The word representation of this Suit.
     */
    @Override
    String getName();

    /**
     * Should be unique to this Suit.
     *
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' could return
     * '2'. As would the 'Five of Hearts', since
     * 'Spades' is the suit value. While the 'Six
     * of Spades' would return a different value.
     *
     * @return The integer value of this Suit.
     */
    @Override
    int getValue();
}
