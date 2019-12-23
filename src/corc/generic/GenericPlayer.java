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

package corc.generic;

import corc.structure.CardsetListener;
import corc.structure.ICard;
import corc.structure.ListenableCardset;
import corc.structure.Nameable;

public class GenericPlayer<C extends ICard> implements Nameable, ListenableCardset<C> {

    private final String NAME;
    private final GenericCardset<C> CARDSET;

    /**
     * Creates a player object that has a name and a {@link GenericCardset}.
     *
     * @param name    the name for this player.
     * @param cardset the Cardset this player uses.
     */
    public GenericPlayer(String name, GenericCardset<C> cardset) {
        this.NAME = name;
        this.CARDSET = cardset;
    }

    /**
     * @return the name of this player.
     */
    @Override
    public String getName() {
        return this.NAME;
    }

    /**
     * Adds an {@link CardsetListener} to this player's stored {@link GenericCardset}.
     *
     * @param listener the CardsetListener to be called whenever there
     *                 is a change to the stored Cardset.
     */
    public void addCardsetListener(CardsetListener<C> listener) {
        this.CARDSET.addCardsetListener(listener);
    }

    /**
     * Removes an {@link CardsetListener} from this player's stored {@link GenericCardset}.
     *
     * @param listener the CardsetListener to remove from the stored Cardset.
     */
    public void removeCardsetListener(CardsetListener<C> listener) {
        this.CARDSET.removeCardsetListener(listener);
    }
}
