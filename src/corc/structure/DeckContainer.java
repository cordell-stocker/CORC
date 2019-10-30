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

/**
 * Holds an instance of a {@link IDeck} object.
 * <p>
 * This is a container to allow the passing around of an
 * IDeck that may be changed to a different instance of
 * an IDeck over time.
 */
public class DeckContainer {

    private IDeck deck;

    /**
     * @param deck the {@link IDeck} to be stored.
     */
    public void setDeck(IDeck deck) {
        this.deck = deck;
    }

    /**
     * @return the stored {@link IDeck}.
     */
    public IDeck getDeck() {
        return this.deck;
    }
}
