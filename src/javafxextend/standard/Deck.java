package javafxextend.standard;

import exception.EmptyDeckException;
import standard.Card;
import standard.Face;
import standard.Suit;
import structure.IDeck;

@SuppressWarnings("unused")
public class Deck extends Cardset implements IDeck<Card>, ObservableList<Card> {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size() - 1; i++) {
            sb.append(this.getCard(i).getDescription()).append(", ");
        }
        if (this.size() > 0) {
            sb.append(this.getCard(this.size() - 1).getDescription()).append("]");
        }
        return sb.toString();
    }

}
