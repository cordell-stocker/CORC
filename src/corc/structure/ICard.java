/*
 * Copyright 2019, Cordell Stocker (cordellstocker@gmail.com)
 * All rights reserved.
 *
 * This file is part of CORC.
 *
 *     CORC is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     CORC is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with CORC.  If not, see <https://www.gnu.org/licenses/>.
 */

package corc.structure;

/**
 * The representation of a card for a card game.
 * <p>
 * SHOULD be implemented as an immutable object.
 *
 * @param <C> the implementing object. Used to reference the subclass for the {@link Comparable} interface.
 */
public interface ICard<C extends ICard> extends Comparable<C> {

    /**
     * Cards of the same class SHOULD return arrays of the
     * same order. For example: in a standard 52 card deck,
     * cards have a face and a suit (likely to be two properties
     * contained by the implemented {@link ICard}). If this
     * method returns [face, suit] for one card, this method
     * should use the same order for all cards of the same
     * type.
     *
     * Following the same rules as above, if an implementing
     * class is subclassed, the subclass should return an
     * array following the same order as the superclass before
     * including its additional properties. If the cards described
     * above also contain a picture of a popular character as
     * well as the super class's face and suit, this method would
     * return [face, suit, picture]. This allows for subclasses
     * to be used as its super class without breaking any logic
     * that may rely on the order of the properties.
     *
     * @return all the CardProperties contained by this.
     */
    CardProperty[] getCardProperties();

    /**
     * @return a String describing this.
     */
    String getDescription();
}
