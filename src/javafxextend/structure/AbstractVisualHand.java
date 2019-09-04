package javafxextend.structure;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import structure.ICard;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class AbstractVisualHand<C extends ICard, CIV extends AbstractCardImageView<C>> extends BorderPane {

    private final Pane HAND_PANE;
    private final List<CIV> CARD_IMAGE_VIEWS = new ArrayList<>();
    private ListChangeListener<C> listener = this::update;

    public AbstractVisualHand(Pane handPane) {
        this.HAND_PANE = handPane;
        this.setCenter(handPane);
    }

    protected abstract void update(ListChangeListener.Change<? extends C> c);

    protected void addCardImageView(CIV cardImageView) {
        this.addToSavedOnly(cardImageView);
        this.addToDisplayOnly(cardImageView);
    }

    protected void removeCardImageView(CIV cardImageView) {
        this.removeFromSavedOnly(cardImageView);
        this.removeFromDisplayOnly(cardImageView);
    }

    protected final void addToDisplayOnly(CIV cardImageView) {
        ObservableList<Node> children = this.getChildren();
        children.remove(cardImageView);
        children.add(cardImageView);
    }

    protected final void removeFromDisplayOnly(CIV cardImageView) {
        this.getChildren().remove(cardImageView);
    }

    protected final void addToSavedOnly(CIV cardImageView) {
        this.CARD_IMAGE_VIEWS.add(cardImageView);
    }

    protected final void removeFromSavedOnly(CIV cardImageView) {
        this.CARD_IMAGE_VIEWS.remove(cardImageView);
    }

    public ListChangeListener<C> getListener() {
        return this.listener;
    }

    public Pane getHandPane() {
        return this.HAND_PANE;
    }

    public List<CIV> getSavedCardImageViews() {
        return this.CARD_IMAGE_VIEWS;
    }

}
