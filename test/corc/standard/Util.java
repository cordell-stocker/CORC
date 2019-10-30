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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Util {

    private static final Face[] FACES = Face.values();
    private static final Suit[] SUITS = Suit.values();

    static List<Card> makeCards(int[] cardValues) {
        List<Card> cards = new ArrayList<>();

        for (int cardValue : cardValues) {
            cards.add(makeCard(cardValue));
        }

        return cards;
    }

    static Card makeCard(int cardValue) {
        int faceValue = cardValue % FACES.length;
        int suitValue = cardValue / FACES.length;
        return new Card(FACES[faceValue], SUITS[suitValue]);
    }

    static int getCardValue(Card card) {
        return card.getFace().getValue() + card.getSuit().getValue() * FACES.length;
    }

    @Test
    public void makeCardTest() {
        Card card1 = new Card(FACES[2], SUITS[1]); // Three of Spades (2 + (1 * 13)) = 15
        Card card2 = new Card(FACES[7], SUITS[2]); // Eight of Diamonds (7 + (2 * 13)) = 33

        Card test1 = makeCard(15);
        Card test2 = makeCard(33);

        assertEquals(card1, test1);
        assertEquals(card2, test2);
    }

    @Test
    public void getCardValueTest() {
        Card card1 = new Card(Face.SIX, Suit.SPADES); // 6 + (1 * 13) = 19
        Card card2 = new Card(Face.JACK, Suit.HEARTS); // 11 + (0 * 13) = 11

        int cardValue1 = getCardValue(card1);
        int cardValue2 = getCardValue(card2);

        assertEquals(19, cardValue1);
        assertEquals(11, cardValue2);
    }
}
