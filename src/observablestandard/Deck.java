package observablestandard;

import exception.EmptyDeckException;
import standard.Card;
import standard.Face;
import standard.Suit;

@SuppressWarnings("unused")
public class Deck extends Cardset implements structure.Deck<Card>, Observable<Card> {

    public Deck() {
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
