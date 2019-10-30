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

import static org.junit.Assert.*;

public class DeckTest {

    /**
     * Last Card in, first Card out
     */
    @Test
    public void drawCardTest() {
        Deck deck = new Deck(new ArrayList<>());
        Card card = new Card(Face.SEVEN, Suit.SPADES);
        deck.addCard(card);

        Card drawnCard = deck.drawCard();

        assertEquals(card, drawnCard);
    }

    @Test
    public void resetTest() {
        Deck deck = new Deck(new ArrayList<>());
        deck.clear();

        deck.reset();

        boolean containsAllCards = true;
        List<Card> allCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                allCards.add(new Card(face, suit));
            }
        }

        for (Card card : allCards) {
            containsAllCards = deck.contains(card) && containsAllCards;
        }

        assertTrue(containsAllCards);
    }
}