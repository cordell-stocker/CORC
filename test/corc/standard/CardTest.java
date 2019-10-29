package corc.standard;

import org.junit.*;
import static org.junit.Assert.*;

public class CardTest {

    private static final Face[] FACES = Face.values();
    private static final Suit[] SUITS = Suit.values();

    @Test
    public void compareTo_GreaterThan_Face() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[2], SUITS[0]);

        int compared = greaterCard.compareTo(lesserCard);

        assertTrue(compared > 0);
    }

    @Test
    public void compareTo_GreaterThan_SUIT() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[1], SUITS[1]);

        int compared = greaterCard.compareTo(lesserCard);

        assertTrue(compared > 0);
    }

    @Test
    public void compareTo_LessThan_Face() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[2], SUITS[0]);

        int compared = lesserCard.compareTo(greaterCard);

        assertTrue(compared < 0);
    }

    @Test
    public void compareTo_LessThan_SUIT() {
        Card lesserCard = new Card(FACES[1], SUITS[0]);
        Card greaterCard = new Card(FACES[1], SUITS[1]);

        int compared = lesserCard.compareTo(greaterCard);

        assertTrue(compared < 0);
    }

    @Test
    public void compareTo_Equals_1() {
        Card card1 = new Card(FACES[1], SUITS[0]);
        Card card2 = new Card(FACES[1], SUITS[0]);

        int compared = card1.compareTo(card2);

        assertEquals(0, compared);
    }

    @Test
    public void compareTo_Equals_2() {
        Card card1 = new Card(FACES[5], SUITS[2]);
        Card card2 = new Card(FACES[5], SUITS[2]);

        int compared = card1.compareTo(card2);

        assertEquals(0, compared);
    }

}