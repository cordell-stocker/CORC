package standard;

import structure.Face;

/**
 * Internal ordering is: ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING.
 */
public enum StandardFace implements Face<StandardFace> {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    /**
     * Returns the string in all uppercase.
     *
     * Examples: "ACE", "THREE", "JACK"
     *
     * @return string representation of this.
     */
    @Override
    public String getName() {
        return this.toString();
    }

    /**
     * Returns a value between 1 and 13
     *
     * @return integer value of this.
     */
    @Override
    public int getValue() {
        return this.ordinal() + 1;
    }
}
