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

import corc.structure.ICard;
import corc.structure.IDeck;

import java.util.List;

/**
 * A base deck object for a card game.
 * <p>
 * Subclasses will need to implement the methods required
 * by the {@link IDeck} interface. Since this generic version
 * is unable to construct the generic type {@link ICard}s.
 *
 * @param <C> the subclass of {@link ICard} to be used.
 */
public abstract class Deck<C extends ICard> extends Cardset<C> implements IDeck<C> {

    /**
     * Creates a Deck
     *
     * @param list the {@link List} to be used to store the cards in.
     */
    public Deck(List<C> list) {
        super(list);
    }

}
