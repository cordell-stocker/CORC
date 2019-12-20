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

import corc.standard.Cardset;

public interface ListenableCardset<C extends ICard> {

    /**
     * Adds a {@link CardsetListener} to a {@link Cardset}.
     *
     * @param listener adds the listener to a Cardset.
     */
    void addCardsetListener(CardsetListener<C> listener);

    /**
     * Removes a {@link CardsetListener} from a {@link Cardset}.
     *
     * @param listener removes the listener from a Cardset.
     */
    void removeCardsetListener(CardsetListener<C> listener);

}
