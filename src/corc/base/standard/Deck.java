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

package corc.base.standard;

import corc.core.Logger;
import corc.exception.EmptyDeckException;
import java.util.List;

/**
 * A Deck that uses standard {@link Card}s.
 */
public class Deck extends corc.base.Deck<Card> {

    /**
     * Creates a deck that uses standard {@link Card}s.
     *
     * @param list the {@link List} to be used to store Cards in.
     */
    public Deck(List<Card> list) {
        super(list);
        this.reset();
    }

    /**
     * Removes and returns the next {@link Card}
     * in this Deck.
     *
     * @return the next Card in this Deck.
     */
    @Override
    public Card drawCard() {
        if (this.isEmpty()) {
            Logger.logSevere("Attempted call to Deck#drawCard() when Deck is empty.");
            throw new EmptyDeckException();
        }
        return this.removeCard(this.size() - 1);
    }

    /**
     * Empties and rebuilds this Deck with
     * all new {@link Card}s, in the default
     * order (sorted).
     */
    @Override
    public void reset() {
        this.clear();
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                this.addCard(new Card(face, suit));
            }
        }
    }
}
