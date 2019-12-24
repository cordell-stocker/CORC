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
 * Used to contain and create any necessary cards for a card game.
 * <p>
 * Cards SHOULD be stored in a 'stack' manner. So
 * if a card is added to this, that same card SHOULD
 * be the first in line to be removed.
 *
 * @param <C> the subclass of {@link ICard} to be stored.
 */
public interface IDeck<C extends ICard> extends ICardset<C> {

    /**
     * SHOULD return the most recently added card.
     * <p>
     * SHOULD throw an {@link corc.exception.EmptyDeckException} if
     * there are no cards in this Deck.
     *
     * @return the next card stored in this.
     */
    C drawCard();

    /**
     * SHOULD be called in the constructor.
     * <p>
     * SHOULD contain all logic necessary for
     * clearing any contained cards, and filling
     * this with all new cards required to play
     * the card game.
     */
    void reset();

}
