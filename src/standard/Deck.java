package standard;

import exception.EmptyDeckException;
import structure.IDeck;

import java.util.List;

public class Deck extends Cardset implements IDeck<Card> {

    public Deck(List<Card> cards) {
        super(cards);
        this.reset();
    }

    @Override
    public Card drawCard() {
        if (this.isEmpty()) {
            throw new EmptyDeckException();
        }
        return this.removeCard(this.size() - 1);
    }

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
