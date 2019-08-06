package standard;

import structure.Suit;

/**
 * Internal ordering is: HEARTS, SPADES, DIAMONDS, CLUBS.
 */
public enum StandardSuit implements Suit<StandardSuit> {
    HEARTS, SPADES, DIAMONDS, CLUBS;

    /**
     * Returns the string in all uppercase.
     *
     * Examples: "HEARTS" and "SPADES"
     *
     * @return string representation of this.
     */
    @Override
    public String getName() {
        return this.toString();
    }

    /**
     * Returns a value between 0 and 3
     *
     * @return integer value of this.
     */
    @Override
    public int getValue() {
        return this.ordinal();
    }
}
