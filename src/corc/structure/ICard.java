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
 * The representation of a card for a card game.
 * <p>
 * SHOULD be implemented as an immutable object.
 *
 * @param <C> the object implementing this. Used to reference the subclass for the Comparable interface.
 */
@SuppressWarnings("unused")
public interface ICard<C extends ICard> extends Comparable<C> {

    /**
     * @return All the CardProperties contained by this.
     */
    CardProperty[] getCardProperties();

    /**
     * @return A String describing this.
     */
    String getDescription();
}
