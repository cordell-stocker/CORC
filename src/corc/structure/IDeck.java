package corc.structure;

import corc.exception.MissingDeckException;

/**
 * A collection of cards used for a card game.
 * <p>
 * Cards SHOULD be stored in a 'stack' manner. So
 * if a Card is added to this, that same Card SHOULD
 * be the first in line to be removed.
 * <p>
 * Any game using this class SHOULD implement their
 * own version of Deck, and then use the {@link IDeck#setDeck(IDeck)}
 * method to follow the singleton design pattern throughout
 * a game implementation.
 *
 * @param <C> The subclass of {@link ICard} to be stored.
 */
@SuppressWarnings("unused")
public interface IDeck<C extends ICard> extends ICardset<C> {

    /**
     * Throws an {@link corc.exception.MissingDeckException} if
     * no deck has been set.
     *
     * @return The stored Deck to be used across a game.
     */
    static IDeck getDeck() {
        if (DeckContainer.getDeck() == null) {
            throw new MissingDeckException();
        }
        return DeckContainer.getDeck();
    }

    /**
     * @param deck The Deck to be used across a game.
     */
    static void setDeck(IDeck deck) {
        DeckContainer.setDeck(deck);
    }

    /**
     * SHOULD throw an {@link corc.exception.EmptyDeckException} if
     * there are no cards in this Deck.
     * <p>
     * SHOULD return the most recently added card.
     *
     * @return The next Card object stored in this.
     */
    C drawCard();

    /**
     * SHOULD contain all logic necessary for
     * clearing any contained cards, and filling
     * itself with all new cards required to play
     * a card game.
     * <p>
     * SHOULD be called in the constructor.
     */
    void reset();

}
