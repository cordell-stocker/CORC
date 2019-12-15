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
package corc.structure;

/**
 * The Representation of the suit of a card.
 * <p>
 * SHOULD be immutable.
 * <p>
 * For example: In a standard 52 card deck,
 * the 'Five of Spades' has a suit of 'Spades'.
 * <p>
 * Many card games have a notion of face and
 * suit, so these are included in CORC.
 *
 * @param <S> the object implementing this. Used to reference the subclass for the Comparable interface.
 */
public interface ISuit<S extends ISuit> extends CardProperty<S> {

    /**
     * SHOULD be unique to this suit.
     * <p>
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * 'Spades'. As would the 'Five of Hearts', since
     * 'Spades' is the suit. While the 'Six
     * of Spades' SHOULD return a different string.
     *
     * @return The String representation of this suit.
     */
    @Override
    String getName();

    /**
     * SHOULD be unique to this suit.
     * <p>
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' could return
     * '2'. As would the 'Five of Hearts', since
     * 'Spades' is the suit value. While the 'Six
     * of Spades' SHOULD return a different value.
     *
     * @return The integer value of this suit.
     */
    @Override
    int getValue();
}
