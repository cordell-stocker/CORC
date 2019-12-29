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
 * A general player interface that SHOULD contain a {@link ICardset}.
 * This serves as a base interface for implementations.
 * <p>
 * Subclasses SHOULD NOT provide a way of getting a reference to the
 * internal Cardset. By following this rule, direct access to the
 * Cardset is restricted to only this and the subclass.
 * <p>
 * If methods of the Cardset would need to be called (such as
 * {@link ICardset#addCard(ICard)}), those methods SHOULD be replicated
 * (wrapped) in the subclass, and control how the Cardset is affected.
 *
 * @param <C> the subclass of {@link ICard} that this player will hold
 *            in its {@link ICardset}.
 */
public interface IPlayer<C extends ICard> extends Nameable, ListenableCardset<C> {
}
