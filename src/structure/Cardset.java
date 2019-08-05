package structure;

import java.util.Collection;
import java.util.List;

/**
 * A collection of Card objects.
 *
 * @param <C> The subclass of Card to be stored
 */
@SuppressWarnings("unused")
public interface Cardset<C extends Card> extends List<C> {

    /**
     * @see List#add(Object)
     *
     * @param card Card to be added.
     * @return true (as specified by {@link Collection#add(Object)}.
     */
    boolean addCard(C card);

    /**
     * Should perform the same operations as
     * addCards(Collection).
     *
     * @see List#addAll(Collection)
     *
     * @param cards Cards to be added.
     * @return true if this list changed as a result of the call.
     */
    boolean addCards(C[] cards);

    /**
     * @see List#addAll(Collection)
     *
     * @param cards Card to be added.
     * @return true if this list changed as a result of the call
     */
    boolean addCards(Collection<C> cards);

    /**
     * @see List#remove(Object)
     *
     * @param card Card to be removed
     * @return true if this Cardset contained the specified Card.
     */
    boolean removeCard(C card);

    /**
     * @see List#remove(int)
     *
     * @param index the index of the Card to be removed
     * @return the Card previously contained at the specified position.
     */
    C removeCard(int index);

    /**
     * Should perform the same operations as
     * removeCards(Collection).
     *
     * @see List#removeAll(Collection)
     *
     * @param cards Card to be removed from this.
     * @return true if this Cardset changed as a result of the call.
     */
    boolean removeCards(C[] cards);

    /**
     * @see List#removeAll(Collection)
     *
     * @param cards Cards to be removed from this.
     * @return true if this Cardset changed as a result of the call.
     */
    boolean removeCards(Collection<C> cards);

    /**
     * Should randomly shuffle this. Such that the Cards
     * stored by this would not appear in the same order
     * after the sort() method is called.
     *
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
