package corc.javafxextend.standard;

import corc.javafxextend.structure.AbstractCardImageView;
import corc.standard.Card;
import corc.standard.Face;
import corc.standard.Suit;

@SuppressWarnings({"unused", "WeakerAccess"})
public class CardImageView extends AbstractCardImageView<Card> {

    private static final String RES_PATH = "corc/resources/standard/";
    private static final String IMG_EXT = ".png";
    private static final String BACK_URL = CardImageView.RES_PATH + "back_blue_vertical" + CardImageView.IMG_EXT;

    public CardImageView() {
        super(new Card(Face.ACE, Suit.SPADES), CardImageView.BACK_URL, CardImageView.BACK_URL, true);
    }

    public CardImageView(Card card) {
        this(card, true);
    }

    public CardImageView(Card card, boolean isFaceUp) {
        super(card, CardImageView.getFrontUrlFromCard(card), CardImageView.BACK_URL, isFaceUp);
    }

    public <I extends AbstractCardImageView<Card>> CardImageView(I cardImageView) {
        super(cardImageView);
    }

    private static String getFrontUrlFromCard(Card card) {
        return CardImageView.RES_PATH + card.getFace().getName().toLowerCase() + "_" +
                card.getSuit().getName().toLowerCase() + CardImageView.IMG_EXT;
    }

    @Override
    public int compareTo(AbstractCardImageView<Card> o) {
        return this.getCard().compareTo(o.getCard());
    }
}
