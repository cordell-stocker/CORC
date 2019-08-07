package structure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A collection of Card objects.
 *
 * @param <C> The subclass of Card to be stored
 */
@SuppressWarnings("unused")
public interface Cardset<C extends Card> extends Iterable<C>{

    /**
     * @see List#add(Object)
     *
     * @param card Card to be added.
     * @return true (as specified by {@link Collection#add(Object)}.
     */
    boolean addCard(C card);

    /**
     * @see List#add(int, Object)
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void addCard(int index, C element);

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
     * @see List#addAll(int, Collection)
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     */
    boolean addCards(int index, Collection<? extends C> c);

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
     * @see List#get(int)
     *
     * @param index specified card to get.
     * @return the card at the specified location.
     */
    C getCard(int index);

    /**
     * Should return the cards stored in this, but not the direct
     * reference to any internal variables.
     *
     * @return array of the stored cards.
     */
    C[] getCards();

    /**
     * @see List#set(int, Object)
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    C setCard(int index, C element);

    /**
     * @see List#retainAll(Collection)
     *
     * @param c collection containing elements to be retained in this list
     * @return <tt>true</tt> if this list changed as a result of the call
     */
    boolean retainCards(Collection<?> c);

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

    /**
     * Binds a normal array to this list.
     *
     * @param cards array to be bound.
     */
    void bind(C[] cards);

    /**
     * @see List#size()
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * @see List#isEmpty()
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    boolean isEmpty();

    /**
     * @see List#contains(Object)
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    boolean contains(Object o);

    /**
     * @see Iterable#iterator()
     *
     * @return an Iterator.
     */
    Iterator<C> iterator();

    /**
     * @see List#toArray()
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence
     */
    Object[] toArray();

    /**
     * @see List#toArray(Object[])
     *
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     */
    <T> T[] toArray(T[] a);

    /**
     * @see List#containsAll(Collection)
     *
     * @param  c collection to be checked for containment in this list
     * @return <tt>true</tt> if this list contains all of the elements of the
     *         specified collection
     */
    boolean containsAll(Collection<?> c);

    /**
     * @see List#clear()
     */
    void clear();

    /**
     * @see List#indexOf(Object)
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    int indexOf(Object o);

    /**
     * @see List#lastIndexOf(Object)
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    int lastIndexOf(Object o);

    /**
     * @see List#listIterator()
     *
     * @return a list iterator over the elements in this list (in proper
     *         sequence)
     */
    ListIterator<C> listIterator();

    /**
     * @see List#listIterator(int)
     *
     * @param index index of the first element to be returned from the
     *        list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     */
    ListIterator<C> listIterator(int index);

    /**
     * @see List#subList(int, int)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     */
    List<C> subList(int fromIndex, int toIndex);
}
