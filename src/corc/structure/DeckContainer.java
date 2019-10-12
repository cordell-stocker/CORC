package corc.structure;

/**
 * Holds an instance of a {@link IDeck} object.
 * <p>
 * This is a container to allow the passing around of an
 * IDeck that may be changed to a different instance of
 * an IDeck over time.
 */
public class DeckContainer {

    private IDeck deck;

    /**
     * @param deck the {@link IDeck} to be stored.
     */
    public void setDeck(IDeck deck) {
        this.deck = deck;
    }

    /**
     * @return the stored {@link IDeck}.
     */
    public IDeck getDeck() {
        return this.deck;
    }
}
