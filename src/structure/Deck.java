package structure;

import exception.MissingDeckException;

/**
 * A collection of cards used for a card game.
 *
 * Cards should be stored in a 'stack' manner. So
 * if a Card is added to this, that same Card should
 * be the first in line to be removed.
 *
 * Any game using this class should implement their
 * own version of Deck, and then use the Deck.setDeck(Deck)
 * method to follow the singleton design pattern throughout
 * a game implementation.
 *
 * @param <C> The subclass of Card to be stored.
 */
@SuppressWarnings("unused")
public interface Deck<C extends Card> extends Cardset<C> {

    /**
     *
     * Throws an {@link exception.MissingDeckException} if
     * no deck has been set.
     *
     * @return The single stored Deck used across a game.
     */
    static Deck getDeck() {
        if (DeckContainer.getDeck() == null) {
            throw new MissingDeckException();
        }
        return DeckContainer.getDeck();
    }

    /**
     *
     * @param deck The Deck to be used across a game.
     */
    static void setDeck(Deck deck) {
        DeckContainer.setDeck(deck);
    }

    /**
     * Should throw an {@link exception.EmptyDeckException} if
     * there are no Cards in this.
     *
     * @return The next Card object stored in this.
     */
    C drawCard();

    /**
     * Should contain all logic necessary for
     * clearing any contained cards, and filling
     * itself with all new cards required to play
     * a card game.
     *
     * Should be called in the constructor of the subclass.
     */
    void reset();

}
