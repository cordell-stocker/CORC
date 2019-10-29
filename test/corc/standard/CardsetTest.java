package corc.standard;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardsetTest {

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

    public int getCardValue(Card card) {
        return card.getFace().getValue() + card.getSuit().getValue() * FACES.length;
    }

    @Test
    public void getCardValueTest() {
        Card card = new Card(FACES[5], SUITS[1]); // Six of Spades (6 + 13)

        int cardValue = getCardValue(card);

        assertEquals(19, cardValue);
    }

    /**
     * A Cardset after calling Cardset#shuffle() MUST NOT
     * be the same after Cardset#shuffle() is called again.
     */
    @Test
    public void shuffle() {
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
    public void sort() {
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
    public void contains() {
        Cardset cards = new Cardset(makeCards(new int[]{0,1,2}));
        Card card = new Card(FACES[5], SUITS[1]);
        cards.addCard(card);

        boolean contains = cards.contains(card);

        assertTrue(contains);
    }
}