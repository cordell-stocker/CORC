package javafxextend.standard;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafxextend.structure.AbstractVisualHand;
import standard.Card;

import java.util.ArrayList;
import java.util.List;

public class VisualHand extends AbstractVisualHand<Card, CardImageView> {

    public VisualHand(Pane handPane) {
        super(handPane);
    }

    @Override
    protected void update(ListChangeListener.Change<? extends Card> c) {
        List<CardImageView> toAdd = new ArrayList<>();
        List<CardImageView> toRemove = new ArrayList<>();
        while (c.next()) {
            if (c.wasAdded()) {
                for (Card card : c.getAddedSubList()) {
                    CardImageView cardImageView = new CardImageView(card);
                    toAdd.add(cardImageView);
                }
            }
            if (c.wasRemoved()) {
                for (Card card : c.getRemoved()) {
                    for (CardImageView cardImageView : this.getSavedCardImageViews()) {
                        if (cardImageView.getCard() == card) {
                            toRemove.add(cardImageView);
                            break;
                        }
                    }
                }
            }
        }
        for (CardImageView cardImageView : toRemove) {
            this.removeCardImageView(cardImageView);
        }
        for (CardImageView cardImageView : toAdd) {
            this.addCardImageView(cardImageView);
        }
    }
}
