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
package corc.standard;

import org.junit.*;
import static org.junit.Assert.*;

public class CardTest {

    private static final Face[] FACES = Face.values();
    private static final Suit[] SUITS = Suit.values();

    @Test
    public void compareTo_GreaterThan_FaceTest() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[2], SUITS[0]);

        int compared = greaterCard.compareTo(lesserCard);

        assertTrue(compared > 0);
    }

    @Test
    public void compareTo_GreaterThan_SuitTest() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[1], SUITS[1]);

        int compared = greaterCard.compareTo(lesserCard);

        assertTrue(compared > 0);
    }

    @Test
    public void compareTo_LessThan_FaceTest() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[2], SUITS[0]);

        int compared = lesserCard.compareTo(greaterCard);

        assertTrue(compared < 0);
    }

    @Test
    public void compareTo_LessThan_SuitTest() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[1], SUITS[1]);

        int compared = lesserCard.compareTo(greaterCard);

        assertTrue(compared < 0);
    }

    @Test
    public void compareTo_EqualsTest() {
        Card card1 = new Card(FACES[1], SUITS[0]);
        Card card2 = new Card(FACES[1], SUITS[0]);
        Card card3 = new Card(FACES[5], SUITS[2]);
        Card card4 = new Card(FACES[5], SUITS[2]);

        int compared1 = card1.compareTo(card2);
        int compared2 = card3.compareTo(card4);

        assertEquals(0, compared1);
        assertEquals(0, compared2);
    }

    @Test
    public void equalsTest() {
        Card card1 = new Card(FACES[0], SUITS[1]);
        Card card2 = new Card(FACES[0], SUITS[1]);
        Card card3 = new Card(FACES[1], SUITS[1]);

        boolean cardsAreSame = card1.equals(card2);
        boolean cardsAreDifferent = !card1.equals(card3);

        assertTrue(cardsAreSame);
        assertTrue(cardsAreDifferent);
    }

}