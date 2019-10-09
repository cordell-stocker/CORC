package corc.standard;

import corc.structure.CardProperty;
import corc.structure.ICard;

public class Card implements ICard<Card> {

    private final Face FACE;
    private final Suit SUIT;

    /**
     * Shallow copy constructor.
     * <p>
     * Since StandardFace and StandardSuit are enums,
     * setting this's Face and Suit to the other's
     * can not affect the other Card.
     *
     * @param other card to make a copy of.
     */
    public Card(Card other) {
        this(other.FACE, other.SUIT);
    }

    public Card(Face face, Suit suit) {
        this.FACE = face;
        this.SUIT = suit;
    }

    /**
     * @return the Face representing this.
     */
    public Face getFace() {
        return this.FACE;
    }

    /**
     * @return the Suit representing this.
     */
    public Suit getSuit() {
        return this.SUIT;
    }

    /**
     * @param other the other card to compare to.
     * @return positive if this comes before, negative for after, or 0 for equal ordering.
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(Card other) {
        int possibleFaces = Face.values().length;
        int thisVal = this.FACE.getValue() + (this.SUIT.getValue() * possibleFaces);
        int otherVal = other.FACE.getValue() + (other.SUIT.getValue() * possibleFaces);
        return thisVal - otherVal;
    }

    @Override
    public CardProperty[] getCardProperties() {
        return new CardProperty[]{this.FACE, this.SUIT};
    }

    @Override
    public String getDescription() {
        return String.format("%s OF %s", this.FACE.getName(), this.SUIT.getName());
    }
}
