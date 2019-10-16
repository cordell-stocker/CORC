package corc.standard;

import corc.core.Logger;
import corc.exception.EmptyDeckException;
import corc.structure.IDeck;

import java.util.List;

public class Deck extends Cardset implements IDeck<Card> {

    public Deck(List<Card> cards) {
        super(cards);
        this.reset();
    }

    /**
     * Removes and returns the next {@link Card}
     * in this Deck.
     *
     * @return the next Card in this Deck.
     */
    @Override
    public Card drawCard() {
        if (this.isEmpty()) {
            Logger.logSevere("Attempted call to Deck#drawCard() when Deck is empty.");
            throw new EmptyDeckException();
        }
        return this.removeCard(this.size() - 1);
    }

    /**
     * Empties and rebuilds this Deck with
     * all new {@link Card}s, in the default
     * order (sorted).
     */
    @Override
    public void reset() {
        this.clear();
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                this.addCard(new Card(face, suit));
            }
        }
    }
}
