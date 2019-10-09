package corc.javafxextend.structure;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import corc.structure.ICard;
import corc.structure.ICardsetListener;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class AbstractVisualHand<C extends ICard, CIV extends AbstractCardImageView<C>> extends BorderPane {

    private final Pane HAND_PANE;
    private final List<CIV> CARD_IMAGE_VIEWS = new ArrayList<>();

    private volatile boolean addingCards;
    private volatile boolean removingCards;
    private ICardsetListener<C> listener = new ICardsetListener<C>() {
        @Override
        public void cardsAdded(List<? extends C> cards) {
            addingCards = true;
            Platform.runLater(() -> {
                addCards(cards);
                addingCards = false;
            });

            while (addingCards) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void cardsRemoved(List<? extends C> cards) {
            removingCards = true;
            Platform.runLater(() -> {
                removeCards(cards);
                removingCards = false;
            });

            while (removingCards) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public AbstractVisualHand(Pane handPane) {
        this.HAND_PANE = handPane;
        this.setCenter(handPane);
    }

    protected abstract void addCards(List<? extends C> cards);

    protected abstract void removeCards(List<? extends C> cards);

    protected void addCardImageView(CIV cardImageView) {
        this.addToSavedOnly(cardImageView);
        this.addToDisplayOnly(cardImageView);
    }

    protected void removeCardImageView(CIV cardImageView) {
        this.removeFromSavedOnly(cardImageView);
        this.removeFromDisplayOnly(cardImageView);
    }

    protected final void addToDisplayOnly(CIV cardImageView) {
        ObservableList<Node> children = this.HAND_PANE.getChildren();
        children.remove(cardImageView);
        children.add(cardImageView);
    }

    protected final void removeFromDisplayOnly(CIV cardImageView) {
        this.HAND_PANE.getChildren().remove(cardImageView);
    }

    protected final void addToSavedOnly(CIV cardImageView) {
        this.CARD_IMAGE_VIEWS.add(cardImageView);
    }

    protected final void removeFromSavedOnly(CIV cardImageView) {
        this.CARD_IMAGE_VIEWS.remove(cardImageView);
    }

    public ICardsetListener<C> getListener() {
        return this.listener;
    }

    public Pane getHandPane() {
        return this.HAND_PANE;
    }

    public List<CIV> getSavedCardImageViews() {
        return this.CARD_IMAGE_VIEWS;
    }

}
