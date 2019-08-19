package standard;

import exception.EmptyDeckException;

import java.util.ArrayList;

public class Deck extends Cardset implements structure.Deck<Card> {

    private final ArrayList<Card> CARDS = new ArrayList<>();

    public Deck() {
        this.reset();
    }

    @Override
    public Card drawCard() {
        if (this.isEmpty()) {
            throw new EmptyDeckException();
        }
        return this.removeCard(this.CARDS.size() - 1);
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
