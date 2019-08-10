package blackjack;

import blackjackcore.model.BlackjackController;
import blackjackcore.model.BlackjackPlayer;
import standard.*;

public class BlackjackComputerPlayer extends BlackjackPlayer {

    private final BlackjackHand hand;

    public BlackjackComputerPlayer() {
        this.hand = new BlackjackHand(this);
    }

    /**
     * For student to implement.
     *
     * Computer should draw another Card while its score
     * is below 16.
     *
     * @param controller the game controller.
     * @param deck the deck for the game.
     */
    @Override
    public void takeTurn(BlackjackController controller, Deck deck) {
        boolean playing = true;
        while (playing) {
            if (this.getScore() < 16) {
                Card card = deck.drawCard();
                this.addCard(card);
            } else {
                playing = false;
            }
        }
    }

    /**
     * For student to implement.
     *
     * Needs to wrap BlackjackHand#addCard(Card) method.
     *
     * @param card Card to be added.
     */
    @Override
    public void addCard(Card card) {
        this.hand.addCard(card);
        this.setScore(this.hand.getHandScore());
    }

    /**
     * For student to implement.
     *
     * Just needs to wrap the BlackjackHand#clearCards() method.
     */
    @Override
    public void clearCards() {
        this.hand.clearCards();
    }

    /**
     * For student to implement.
     *
     * Just needs to wrap the BlackjackHand#getCardCard() method.
     *
     * @return number of Cards in the hand.
     */
    @Override
    public int getCardCount() {
        return this.hand.getCardCount();
    }

    // Given to the students below this point.

    /**
     *
     * @return this player's score.
     */
    @Override
    public int getScore() {
        return super.getScore();
    }

    /**
     *
     * @param value the new score for this player.
     */
    @Override
    public void setScore(int value) {
        super.setScore(value);
    }
}