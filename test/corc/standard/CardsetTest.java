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

import static corc.standard.Util.getCardValue;
import static corc.standard.Util.makeCards;
import static org.junit.Assert.*;

public class CardsetTest {

    /**
     * A Cardset after calling Cardset#shuffle() MUST NOT
     * be the same after Cardset#shuffle() is called again.
     */
    @Test
    public void shuffleTest() {
        int size = 16;
        int[] cardValues = new int[size];
        for (int i = 0; i < size; i++) {
            cardValues[i] = i;
        }
        Cardset cards = new Cardset(makeCards(cardValues));

        // First round
        cards.shuffle();
        int[] firstRound = new int[size];
        for (int i = 0; i < cards.size(); i++) {
            firstRound[i] = getCardValue(cards.getCard(i));
        }

        // Second round
        cards.shuffle();
        int[] secondRound = new int[size];
        for (int i = 0; i < size; i++) {
            secondRound[i] = getCardValue(cards.getCard(i));
        }

        boolean isNotDifferent = true;
        for (int i = 0; i < size; i++) {
            isNotDifferent = (firstRound[i] == secondRound[i]) && isNotDifferent;
        }

        assertFalse(isNotDifferent);
    }

    @Test
    public void sortTest() {
        Cardset cards = new Cardset(makeCards(new int[]{12, 51, 32, 6, 18, 17, 2, 48}));

        cards.sort();

        boolean isSorted = true;
        int previousCardValue = -1;
        int currentCardValue;
        for (Card card : cards) {
            currentCardValue = getCardValue(card);
            if (currentCardValue < previousCardValue) {
                isSorted = false;
            }
        }

        assertTrue(isSorted);
    }

    @Test
    public void containsTest() {
        Cardset cards = new Cardset(makeCards(new int[]{0,1,2}));
        Card card = new Card(Face.FOUR, Suit.SPADES);
        cards.addCard(card);

        boolean contains = cards.contains(card);

        assertTrue(contains);
    }
}