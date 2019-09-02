package structure;

/**
 * Holds an instance of a {@link Deck} object.
 *
 * Main purpose is for the Deck interface static methods to be
 * able to set a "global" Deck object.
 */
final class DeckContainer {

    private static Deck deck;

    static void setDeck(Deck deck) {
        DeckContainer.deck = deck;
    }

    static Deck getDeck() {
        return DeckContainer.deck;
    }
}
