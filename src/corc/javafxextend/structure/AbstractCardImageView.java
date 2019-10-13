package corc.javafxextend.structure;

import corc.core.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import corc.structure.ICard;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractCardImageView<C extends ICard> extends ImageView implements Comparable<AbstractCardImageView<C>> {

    private final String FRONT_URL, BACK_URL;
    private final C CARD;

    private boolean isFaceUp;

    public AbstractCardImageView(C card, String frontUrl, String backUrl, boolean isFaceUp) {
        this.CARD = card;
        this.FRONT_URL = frontUrl;
        this.BACK_URL = backUrl;
        this.isFaceUp = isFaceUp;
        this.update();
    }

    public <T extends AbstractCardImageView<C>> AbstractCardImageView(T cardImageView) {
        this(
                cardImageView.getCard(),
                cardImageView.getFrontUrl(),
                cardImageView.getBackUrl(),
                cardImageView.isFaceUp()
        );
    }

    private void update() {
        String url = this.isFaceUp ? this.FRONT_URL : this.BACK_URL;
        try {
            Image image = new Image(url);
            this.setImage(image);
            Logger.logInfo(
                    "Created CardImageView with Card: " + this.CARD + ", using URLS: " +
                            this.FRONT_URL + " :: " + this.BACK_URL
            );
        } catch (IllegalArgumentException e) {
            Logger.logSevere("Failed to create CardImageView with Card: " + this.CARD +
                    ", using URLS: " + this.FRONT_URL + " :: " + this.BACK_URL);
        }
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
