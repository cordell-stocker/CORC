package standard;

import structure.Card;

public class StandardCard implements Card<StandardCard, StandardFace, StandardSuit> {

    private final StandardFace FACE;
    private final StandardSuit SUIT;

    /**
     * Shallow copy constructor.
     *
     * Since StandardFace and StandardSuit are enums,
     * setting this's Face and Suit to the other's
     * can not affect the other Card.
     *
     * @param other card to make a copy of
     */
    public StandardCard(StandardCard other) {
        this(other.FACE, other.SUIT);
    }

    public StandardCard(StandardFace face, StandardSuit suit) {
        this.FACE = face;
        this.SUIT = suit;
    }

    /**
     * @see Card#getFace()
     *
     * @return the Face representing this.
     */
    @Override
    public StandardFace getFace() {
        return this.FACE;
    }

    /**
     * @see Card#getSuit()
     * @return the Suit representing this.
     */
    @Override
    public StandardSuit getSuit() {
        return this.SUIT;
    }

    /**
     * @see Comparable#compareTo(Object)
     *
     * @param other the other card to compare to.
     * @return positive if this comes before, negative for after, or 0 for equal ordering.
     */
    @Override
    public int compareTo(StandardCard other) {
        int possibleFaces = StandardFace.values().length;
        int thisVal = this.FACE.getValue() + (this.SUIT.getValue() * possibleFaces);
        int otherVal = other.FACE.getValue() + (other.SUIT.getValue() * possibleFaces);
        return thisVal - otherVal;
    }
}
