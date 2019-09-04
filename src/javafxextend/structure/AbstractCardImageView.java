package javafxextend.structure;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import structure.ICard;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractCardImageView<C extends ICard> extends ImageView implements Comparable<AbstractCardImageView<C>> {

    private final String FRONT_URL, BACK_URL;
    private final C CARD;

    private boolean isFaceUp = true;

    public AbstractCardImageView(C card, String frontUrl, String backUrl, boolean isFaceUp) {
        this.CARD = card;
        this.FRONT_URL = frontUrl;
        this.BACK_URL = backUrl;
        this.isFaceUp = isFaceUp;
        this.update();
    }

    public <I extends AbstractCardImageView<C>> AbstractCardImageView(I cardImageView) {
        this(cardImageView.getCard(), cardImageView.getFrontUrl(), cardImageView.getBackUrl(), cardImageView.isFaceUp());
    }

    private void update() {
        String url = this.isFaceUp ? this.FRONT_URL : this.BACK_URL;
        this.setImage(new Image(url));
    }

    public void setIsFaceUp(boolean isFaceUp) {
        if (this.isFaceUp != isFaceUp) {
            this.isFaceUp = isFaceUp;
            this.update();
        }
    }

    public boolean isFaceUp() {
        return this.isFaceUp;
    }

    public C getCard() {
        return this.CARD;
    }

    public String getFrontUrl() {
        return this.FRONT_URL;
    }

    public String getBackUrl() {
        return this.BACK_URL;
    }

}
