package corc.javafxextend.standard;

import javafx.scene.layout.Pane;
import corc.javafxextend.structure.AbstractVisualHand;
import corc.standard.Card;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class VisualHand extends AbstractVisualHand<Card, CardImageView> {

    public VisualHand(Pane handPane) {
        super(handPane);
    }

    @Override
    protected synchronized void addCards(List<? extends Card> cards) {
        List<CardImageView> toAdd = new ArrayList<>();
        for (Card card : cards) {
            CardImageView cardImageView = new CardImageView(card);
            toAdd.add(cardImageView);
        }
        for (CardImageView cardImageView : toAdd) {
            this.addCardImageView(cardImageView);
        }
    }

    @Override
    protected synchronized void removeCards(List<? extends Card> cards) {
        List<CardImageView> toRemove = new ArrayList<>();
        for (Card card : cards) {
            for (CardImageView cardImageView : this.getSavedCardImageViews()) {
                if (cardImageView.getCard() == card) {
                    toRemove.add(cardImageView);
                    break;
                }
            }
        }
        for (CardImageView cardImageView : toRemove) {
            this.removeCardImageView(cardImageView);
        }
    }

}
