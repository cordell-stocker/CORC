package structure;

/**
 * The representation of a card for a card game.
 * <p>
 * SHOULD be implemented as an immutable object.
 *
 * @param <C> The class interfacing this. Used for the Comparable interface.
 */
@SuppressWarnings("unused")
public interface ICard<C extends ICard> extends Comparable<C> {

    /**
     * @return All the CardProperties contained by this Card.
     */
    CardProperty[] getCardProperties();

    /**
     * @return A String describing this Card.
     */
    String getDescription();
}
