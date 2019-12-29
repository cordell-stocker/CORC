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

import corc.structure.CardProperty;
import corc.structure.ICard;

public class Card implements ICard<Card> {

    private final Face FACE;
    private final Suit SUIT;

    /**
     * Copy constructor.
     * <p>
     * Since StandardFace and StandardSuit are enums,
     * setting this's Face and Suit to the other's
     * can not affect the other Card.
     *
     * @param other card to make a copy of.
     */
    public Card(Card other) {
        this(other.FACE, other.SUIT);
    }

    /**
     * Creates a new Card object.
     *
     * @param face the {@link Face} of this Card.
     * @param suit the {@link Suit} of this Card.
     */
    public Card(Face face, Suit suit) {
        this.FACE = face;
        this.SUIT = suit;
    }

    /**
     * @return the Face representing this.
     */
    public Face getFace() {
        return this.FACE;
    }

    /**
     * @return the Suit representing this.
     */
    public Suit getSuit() {
        return this.SUIT;
    }

    /**
     * @param other the other card to compare to.
     * @return positive if this comes before, negative for after, or 0 for equal ordering.
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(Card other) {
        int possibleFaces = Face.values().length;
        int thisVal = this.FACE.getValue() + (this.SUIT.getValue() * possibleFaces);
        int otherVal = other.FACE.getValue() + (other.SUIT.getValue() * possibleFaces);
        return thisVal - otherVal;
    }

    @Override
    public CardProperty[] getCardProperties() {
        return new CardProperty[]{this.FACE, this.SUIT};
    }

    @Override
    public String getDescription() {
        return String.format("%s OF %s", this.FACE.getName(), this.SUIT.getName());
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (o instanceof Card) {
            boolean matchFace = this.FACE.getValue() == ((Card) o).FACE.getValue();
            boolean matchSuit = this.SUIT.getValue() == ((Card) o).SUIT.getValue();
            isEqual = matchFace && matchSuit;
        }
        return isEqual;
    }

    @Override
    public String toString() {
        return getDescription();
    }

}
