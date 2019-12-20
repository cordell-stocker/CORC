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

import java.util.List;

/**
 * Implementations of this MAY perform actions
 * whenever the methods are called.
 * <p>
 * The {@link CardsetListener#cardsAdded(List)} SHOULD be
 * called whenever the {@link ICardset}, containing a reference
 * of this class, has {@link ICard}s added. With only the added
 * ICards given to the parameter.
 * <p>
 * Likewise the {@link CardsetListener#cardsRemoved(List)} SHOULD
 * be called whenever the ICardset, containing a reference of this
 * class, has ICards removed. With only the added ICards given to
 * the parameter.
 *
 * @param <C> The subclass of {@link ICard} to be used.
 */
public interface CardsetListener<C extends ICard> {

	/**
	 * MAY perform actions when called.
	 * <p>
	 * MAY use the given cards.
	 *
	 * @param cards the cards that have been added.
	 */
    void cardsAdded(List<? extends C> cards);

    /**
     * MAY perform actions when called.
     * <p>
     * MAY use the given cards.
     *
     * @param cards the cards that have been removed.
     */
	void cardsRemoved(List<? extends C> cards);
}
