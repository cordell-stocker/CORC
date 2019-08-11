package javafx.standard;

import standard.Card;

public class CardImageView extends javafx.structure.CardImageView<Card> {

    private static final String RES_PATH = "resources/standard";
    private static final String IMG_EXT = ".png";
    private static final String BACK_URL = CardImageView.RES_PATH + "back_blue_vertical" + CardImageView.IMG_EXT;

    public CardImageView(Card card) {
        this(card, true);
    }

    public CardImageView(Card card, boolean isFaceUp) {
        super(card, CardImageView.getFrontUrlFromCard(card), CardImageView.BACK_URL, isFaceUp);
    }

    public <I extends javafx.structure.CardImageView<Card>> CardImageView(I cardImageView) {
        super(cardImageView);
    }

    private static String getFrontUrlFromCard(Card card) {
        return CardImageView.RES_PATH + card.getFace().getName().toLowerCase() + "_" +
                card.getSuit().getName().toLowerCase() + CardImageView.IMG_EXT;
    }

    @Override
    public int compareTo(javafx.structure.CardImageView<Card> o) {
        return this.getCard().compareTo(o.getCard());
    }
}
