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
 * The Representation of the face of a card.
 * <p>
 * The implementing class SHOULD be immutable.
 * <p>
 * For example: In a standard 52 card deck,
 * the 'Five of Spades' has a face of 'Five'.
 *
 * @param <F> the implementing class. Used to reference the subclass for the {@link CardProperty} interface.
 */
public interface IFace<F extends IFace> extends CardProperty<F> {

    /**
     * SHOULD be unique to this.
     * <p>
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * 'Five'. As would the 'Five of Hearts', since
     * 'Five' is the face value. While the 'Six
     * of Spades' SHOULD return a different string.
     *
     * @return the String representation of this.
     */
    @Override
    String getName();

    /**
     * SHOULD be unique to this.
     * <p>
     * For example: In a standard 52 card deck,
     * a 'Five of Spades' would most likely return
     * '5'. As would the 'Five of Hearts', since
     * 'Five' is the face value. While the 'Six
     * of Spades' SHOULD return a different value.
     *
     * @return the integer value of this.
     */
    @Override
    int getValue();

}
