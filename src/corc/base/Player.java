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

package corc.base;

import corc.structure.CardsetListener;
import corc.structure.ICard;
import corc.structure.IPlayer;

/**
 * A general player object that contains a {@link Cardset}.
 * This serves as a base class for game implementations.
 * <p>
 * Subclasses SHOULD retain a local reference of the Cardset passed to the
 * constructor, as there is no getter method for the Cardset from this.
 * <p>
 * Subclasses SHOULD NOT provide a way of getting a reference to the internal
 * Cardset. By following this rule, direct access to the Cardset is
 * restricted to only this and the subclass.
 * <p>
 * If methods of the Cardset would need to be called (such as
 * {@link Cardset#addCard(ICard)}), those methods SHOULD be replicated
 * in the subclass, and control how the Cardset is affected. To see a
 * clear example, look at {@link Player#addCardsetListener(CardsetListener)}.
 *
 * @param <C> the subclass of {@link ICard} that this player will hold in its {@link Cardset}.
 */
public abstract class Player<C extends ICard> implements IPlayer<C> {

    private final String NAME;
    private final Cardset<C> CARDSET;

    /**
     * Creates a player object that has a name and a {@link Cardset}.
     *
     * @param name    the name for this player.
     * @param cardset the Cardset this player uses.
     */
    public Player(String name, Cardset<C> cardset) {
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
     * Adds an {@link CardsetListener} to this player's stored {@link Cardset}.
     *
     * @param listener the CardsetListener to be called whenever there
     *                 is a change to the stored Cardset.
     */
    public void addCardsetListener(CardsetListener<C> listener) {
        this.CARDSET.addCardsetListener(listener);
    }

    /**
     * Removes an {@link CardsetListener} from this player's stored {@link Cardset}.
     *
     * @param listener the CardsetListener to remove from the stored Cardset.
     */
    public void removeCardsetListener(CardsetListener<C> listener) {
        this.CARDSET.removeCardsetListener(listener);
    }
}
