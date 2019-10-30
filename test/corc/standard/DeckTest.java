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