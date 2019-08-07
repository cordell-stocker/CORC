package standard;

import structure.Deck;

import java.util.ArrayList;

public class StandardDeck extends StandardCardset implements Deck<StandardCard> {

    private final ArrayList<StandardCard> CARDS = new ArrayList<>();

    public StandardDeck() {
        this.reset();
    }

    @Override
    public StandardCard drawCard() {
        return this.removeCard(this.CARDS.size() - 1);
    }

    @Override
    public void reset() {
        this.clear();
        for (StandardSuit suit : StandardSuit.values()) {
            for (StandardFace face : StandardFace.values()) {
                this.addCard(new StandardCard(face, suit));
            }
        }
    }
}
