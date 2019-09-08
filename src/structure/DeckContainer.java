package structure;

/**
 * Holds an instance of a {@link Deck} object.
 * <p>
 * Main purpose is for the Deck interface static methods to be
 * able to set a "global" Deck object.
 */
final class DeckContainer {

    private static Deck deck;

    /**
     * @param deck the {@link Deck} to be stored.
     */
    static void setDeck(Deck deck) {
        DeckContainer.deck = deck;
    }

    /**
     * @return the stored {@link Deck}.
     */
    static Deck getDeck() {
        return DeckContainer.deck;
    }
}
