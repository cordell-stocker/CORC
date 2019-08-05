package structure;

/**
 * A collection of cards used for a card game.
 *
 * Cards should be stored in a 'stack' manner. So
 * if a Card is added to this, that same Card should
 * be the first in line to be removed.
 *
 * Any game using this class should implement their
 * own version of Deck, and then use the Deck.setDeck(Deck)
 * method to follow the singleton design pattern throughout
 * a game implementation.
 *
 * @param <C> The subclass of Card to be stored.
 */
@SuppressWarnings("unused")
public abstract class Deck<C extends Card> implements Cardset<C> {

    private static Deck deck;

    /**
     *
     * @return The single stored Deck used across a game.
     */
    public static Deck getDeck() {
        return Deck.deck;
    }

    /**
     *
     * @param deck The Deck to be used across a game.
     */
    public static void setDeck(Deck deck) {
        Deck.deck = deck;
    }

    /**
     *
     * @return The next Card object stored in this.
     */
    public abstract C drawCard();

}
