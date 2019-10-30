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