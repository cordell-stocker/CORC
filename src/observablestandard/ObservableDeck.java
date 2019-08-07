package observablestandard;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import standard.StandardCard;
import standard.StandardFace;
import standard.StandardSuit;
import structure.Deck;

public class ObservableDeck extends ObservableCardset implements Deck<StandardCard>, Observable<StandardCard> {

    private final SimpleListProperty<StandardCard> CARDS;

    public ObservableDeck() {
        this.CARDS = new SimpleListProperty<>(FXCollections.observableArrayList());
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

    @Override
    public void addListener(ListChangeListener<StandardCard> listener) {
        this.CARDS.addListener(listener);
    }

    @Override
    public void removeListener(ListChangeListener<StandardCard> listener) {
        this.CARDS.removeListener(listener);
    }
}
