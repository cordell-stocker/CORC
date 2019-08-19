package standard;

public class Card implements structure.Card<Card, Face, Suit> {

    private final Face FACE;
    private final Suit SUIT;

    /**
     * Shallow copy constructor.
     *
     * Since StandardFace and StandardSuit are enums,
     * setting this's Face and Suit to the other's
     * can not affect the other Card.
     *
     * @param other card to make a copy of
     */
    public Card(Card other) {
        this(other.FACE, other.SUIT);
    }

    public Card(Face face, Suit suit) {
        this.FACE = face;
        this.SUIT = suit;
    }

    /**
     * @see structure.Card#getFace()
     *
     * @return the Face representing this.
     */
    @Override
    public Face getFace() {
        return this.FACE;
    }

    /**
     * @see structure.Card#getSuit()
     * @return the Suit representing this.
     */
    @Override
    public Suit getSuit() {
        return this.SUIT;
    }

    /**
     * @see Comparable#compareTo(Object)
     *
     * @param other the other card to compare to.
     * @return positive if this comes before, negative for after, or 0 for equal ordering.
     */
    @Override
    public int compareTo(Card other) {
        int possibleFaces = Face.values().length;
        int thisVal = this.FACE.getValue() + (this.SUIT.getValue() * possibleFaces);
        int otherVal = other.FACE.getValue() + (other.SUIT.getValue() * possibleFaces);
        return thisVal - otherVal;
    }
}
