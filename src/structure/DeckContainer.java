package structure;

public class DeckContainer {

    private static Deck deck;

    public static void setDeck(Deck deck) {
        DeckContainer.deck = deck;
    }

    public static Deck getDeck() {
        return DeckContainer.deck;
    }
}
