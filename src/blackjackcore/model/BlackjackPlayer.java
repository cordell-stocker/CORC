package blackjackcore.model;

import javafx.beans.property.SimpleIntegerProperty;
import observablestandard.Cardset;
import standard.*;

public abstract class BlackjackPlayer {

    private final SimpleIntegerProperty SCORE = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty TOKENS = new SimpleIntegerProperty(0);
    private final Cardset CARDSET = new Cardset();

    public abstract void takeTurn(BlackjackController controller, Deck deck);

    public abstract void addCard(Card card);

    /**
     * For student to implement.
     *
     * Just needs to wrap the BlackjackHand#clearCards() method.
     */
    public abstract void clearCards();

    /**
     * For student to implement.
     *
     * Just needs to wrap the BlackjackHand#getCardCount() method.
     *
     * @return the number of Cards in this player's hand.
     */
    public abstract int getCardCount();

    /**
     *
     * @return this player's score.
     */
    public int getScore() {
        return this.SCORE.get();
    }

    /**
     *
     * @param value the new score for this player.
     */
    public void setScore(int value) {
        this.SCORE.set(value);
    }

    /**
     *
     * @return this player's tokens.
     */
    public int getTokens() {
        return this.TOKENS.get();
    }

    /**
     *
     * @param value the new tokens for this player.
     */
    public void setTokens(int value) {
        this.TOKENS.set(value);
    }

    /**
     * Students should not touch this method.
     *
     * @param cards Card[] to be bound to the inner observablestandard.Cardset
     */
    public void bindArray(Card[] cards) {
        this.CARDSET.bind(cards);
    }
}
