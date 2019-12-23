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

import corc.structure.CardProperty;
import corc.structure.ICard;
import corc.structure.IFace;
import corc.structure.ISuit;

public class Card<F extends IFace, S extends ISuit> implements ICard<Card> {

    private final F FACE;
    private final S SUIT;

    public Card(F face, S suit) {
        this.FACE = face;
        this.SUIT = suit;
    }

    /**
     * Copy constructor.
     * Uses the exact same instances of F and S from
     * the other Card for this new Card.
     *
     * @param card the Card to be copied.
     */
    public Card(Card<F, S> card) {
        this(card.FACE, card.SUIT);
    }

    /**
     * @return the Face representing this.
     */
    public F getFace() {
        return this.FACE;
    }

    /**
     * @return the Suit representing this.
     */
    public S getSuit() {
        return this.SUIT;
    }

    @Override
    public CardProperty[] getCardProperties() {
        return new CardProperty[]{this.FACE, this.SUIT};
    }

    @Override
    public String getDescription() {
        return String.format("Face: %s, Suit: %s", this.FACE.toString(), this.SUIT.toString());
    }

    /**
     * Compares this Card to the other Card by face value only.
     *
     * @param other the other Card.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Card other) {
        int thisVal = this.FACE.getValue();
        int otherVal = other.FACE.getValue();
        return thisVal - otherVal;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
