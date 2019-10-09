package corc.standard;

import corc.structure.ISuit;

/**
 * Internal ordering is: HEARTS, SPADES, DIAMONDS, CLUBS.
 */
public enum Suit implements ISuit<Suit> {
    HEARTS, SPADES, DIAMONDS, CLUBS;

    /**
     * Returns the String name in all uppercase.
     * <p>
     * Examples: "HEARTS" and "SPADES"
     *
     * @return the String representation of this.
     */
    @Override
    public String getName() {
        return this.toString();
    }

    /**
     * Returns a value between 0 and 3
     * <p>
     * Examples: A "HEARTS" returns 0, "SPADES" returns 2, etc.
     *
     * @return the integer value of this.
     */
    @Override
    public int getValue() {
        return this.ordinal();
    }
}
