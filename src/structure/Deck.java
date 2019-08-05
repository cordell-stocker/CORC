package structure;

/**
 * A collection of cards used for a card game.
 *
 * Any game using this class should implement their
 * own version of Deck, and then use the Deck.setDeck(Deck)
 * method to follow the singleton design pattern throughout
 * a game implementation.
 *
 * @param <C> The subclass of Card to be stored.
 */
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

}
