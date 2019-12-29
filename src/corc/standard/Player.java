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

package corc.standard;

/**
 * A general player that uses the standard {@link Cardset}.
 *
 * @see corc.generic.Player
 */
public abstract class Player extends corc.generic.Player<Card> {

    /**
     * Creates a player that uses a standard {@link Cardset}.
     *
     * @param name    the name for this player.
     * @param cardset the Cardset this player uses.
     * @see corc.generic.Player
     */
    public Player(String name, Cardset cardset) {
        super(name, cardset);
    }
}
