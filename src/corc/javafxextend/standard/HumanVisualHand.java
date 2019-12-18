package corc.javafxextend.standard;

import corc.javafxextend.OrganizablePane;
import corc.standard.Card;

public class HumanVisualHand extends VisualHand {

    private final OrganizablePane HAND_PANE;

    public HumanVisualHand(OrganizablePane handPane) {
        super(handPane);
        this.HAND_PANE = handPane;
    }

    public Card getSelectedCard() {
        CardImageView cardImageView = (CardImageView) this.HAND_PANE.getSelectedNode();
        return cardImageView.getCard();
    }

    public void deselectSelectedCard() {
        this.HAND_PANE.clearSelectedNode();
    }

    @Override
    protected void addCardImageView(CardImageView CIV) {
        this.addToSavedOnly(CIV);
        HAND_PANE.addNodeAfterLast(CIV);
    }

    @Override
    protected void removeCardImageView(CardImageView CIV) {
        this.removeFromSavedOnly(CIV);
        HAND_PANE.getChildren().remove(CIV);
        HAND_PANE.orderChildren();
    }
}
