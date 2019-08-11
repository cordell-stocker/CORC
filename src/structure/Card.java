package structure;

/**
 * Should be implemented as an immutable object.
 *
 * The representation of a card for a card game.
 *
 * @param <C> The class interfacing this. Used for the Comparable interface.
 * @param <F> The Face subclass used to represent the face for this card.
 * @param <S> The Suit subclass used to represent the suit for this card.
 */
public interface Card<C extends Card, F extends Face, S extends Suit> extends Comparable<C> {

    /**
     *
     * @return The Face object stored by this.
     */
    F getFace();

    /**
     *
     * @return The suit object stored by this.
     */
    S getSuit();
}
