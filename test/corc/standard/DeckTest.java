package corc.standard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {

    private static final Face[] FACES = Face.values();
    private static final Suit[] SUITS = Suit.values();

    public List<Card> makeCards(int[] cardValues) {
        List<Card> cards = new ArrayList<>();
        int suitValue;
        int faceValue;
        Card card;

        for (int cardValue : cardValues) {
            faceValue = cardValue % FACES.length;
            suitValue = cardValue / FACES.length;
            card = new Card(FACES[faceValue], SUITS[suitValue]);
            cards.add(card);
        }

        return cards;
    }

    /**
     * Last Card in, first Card out
     */
    @Test
    public void drawCard() {
        Deck deck = new Deck(new ArrayList<>());
        Card card = new Card(FACES[6], SUITS[1]);
        deck.addCard(card);

        Card drawnCard = deck.drawCard();

        assertEquals(card, drawnCard);
    }

    @Test
    public void reset() {
        Deck deck = new Deck(new ArrayList<>());
        deck.clear();

        deck.reset();

        boolean containsAllCards = true;
        List<Card> allCards = new ArrayList<>();
        for (Suit suit : SUITS) {
            for (Face face : FACES) {
                allCards.add(new Card(face, suit));
            }
        }

        for (Card card : allCards) {
            containsAllCards = deck.contains(card) && containsAllCards;
        }

        assertTrue(containsAllCards);
    }
}