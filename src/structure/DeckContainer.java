package structure;

/**
 * Holds an instance of a {@link IDeck} object.
 * <p>
 * Main purpose is for the Deck interface static methods to be
 * able to set a "global" Deck object.
 */
final class DeckContainer {

    private static IDeck deck;

    /**
     * @param deck the {@link IDeck} to be stored.
     */
    static void setDeck(IDeck deck) {
        DeckContainer.deck = deck;
    }

    /**
     * @return the stored {@link IDeck}.
     */
    static IDeck getDeck() {
        return DeckContainer.deck;
    }
}
