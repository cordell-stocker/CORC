package structure;

import java.util.List;

/**
 * A collection of Card objects.
 *
 * @param <C> The subclass of Card to be stored
 */
public interface Cardset<C extends Card> extends List<C> {

    /**
     * Should randomly shuffle this. Such that the Cards
     * stored by this would not appear in the same order
     * after the sort() method is called.
     */
    void shuffle();

    /**
     * Should sort this in a consistent manner.
     *
     * Any number of calls to this method on the same
     * Deck should produce the same ordering of Cards
     * stored internally.
     */
    void sort();
}
