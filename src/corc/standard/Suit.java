/*
Copyright 2019, Cordell Stocker (cordellstocker@gmail.com)
All rights reserved.

This file is part of CORC.

    CORC is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CORC is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CORC.  If not, see <https://www.gnu.org/licenses/>.
*/
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
