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
        while (c.next()) {
            if (c.wasAdded()) {
                for (Card card : c.getAddedSubList()) {
                    CardImageView cardImageView = new CardImageView(card);
                    this.addCardImageView(cardImageView);
                }
            }
            if (c.wasRemoved()) {
                List<CardImageView> toRemove = new ArrayList<>();
                for (Card card : c.getRemoved()) {
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
    }
}
