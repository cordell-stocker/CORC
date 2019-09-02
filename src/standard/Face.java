package standard;

import structure.IFace;

/**
 * Internal ordering is: ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING.
 */
public enum Face implements IFace<Face> {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    /**
     * Returns the string in all uppercase.
     * <p>
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
