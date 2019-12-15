/*
Copyright 2019, Cordell Stocker (cordellstocker@gmail.com)
All rights reserved.

This file is part of CORC.

    CORC is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CORC is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CORC.  If not, see <https://www.gnu.org/licenses/>.
*/
package corc.structure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A collection of Card objects.
 *
 * @param <C> The subclass of {@link ICard} to be stored
 */
public interface ICardset<C extends ICard> extends Iterable<C> {

    /**
     * @param card Card to be added.
     * @return true (as specified by {@link Collection#add(Object)}.
     * @see List#add(Object)
     */
    boolean addCard(C card);

    /**
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @see List#add(int, Object)
     */
    void addCard(int index, C element);

    /**
     * @param cards Cards to be added.
     * @return true if this list changed as a result of the call.
     * @see List#addAll(Collection)
     */
    boolean addCards(C[] cards);

    /**
     * @param cards Card to be added.
     * @return true if this list changed as a result of the call.
     * @see List#addAll(Collection)
     */
    boolean addCards(List<C> cards);

    /**
     * @param index index at which to insert the first element from the
     *              specified collection.
     * @param c     collection containing elements to be added to this list.
     * @return true if this list changed as a result of the call.
     * @see List#addAll(int, Collection)
     */
    boolean addCards(int index, List<? extends C> c);

    /**
     * @param card Card to be removed
     * @return true if this Cardset contained the specified Card.
     * @see List#remove(Object)
     */
    boolean removeCard(C card);

    /**
     * @param index the index of the Card to be removed
     * @return the Card previously contained at the specified position.
     * @see List#remove(int)
     */
    C removeCard(int index);

    /**
     * @param cards Card to be removed from this.
     * @return true if this Cardset changed as a result of the call.
     * @see List#removeAll(Collection)
     */
    boolean removeCards(C[] cards);

    /**
     * @param cards Cards to be removed from this.
     * @return true if this Cardset changed as a result of the call.
     * @see List#removeAll(Collection)
     */
    boolean removeCards(List<C> cards);

    /**
     * @param index specified card to get.
     * @return the card at the specified location.
     * @see List#get(int)
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
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @see List#set(int, Object)
     */
    C setCard(int index, C element);

    /**
     * @param c collection containing elements to be retained in this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @see List#retainAll(Collection)
     */
    boolean retainCards(List<?> c);

    /**
     * SHOULD randomly shuffle this. Such that the Cards
     * stored by this would not appear in the same order
     * as another Cardset after the sort() method is called
     * on the other.
     * Set logic: Cardset1.shuffle() != Cardset2.sort()
     * <p>
     * This method SHOULD NOT shuffle the same pattern on
     * each call. (e.x. SHOULD NOT always swap index 1 and 17).
     * While there can be a possibility that two Cardsets result
     * in the same order after this method, the chance should be
     * unlikely.
     * Set logic: Cardset1.shuffle() != Cardset2.shuffle()
     */
    void shuffle();

    /**
     * SHOULD sort this in a consistent manner.
     * <p>
     * Any number of calls to this method on the same
     * Deck should produce the same ordering of Cards
     * stored internally.
     * Set logic: Cardset1.sort() == Cardset2.sort()
     * Cardset1.sort() == Cardset1.sort()
     */
    void sort();

    /**
     * Binds a normal array to this list.
     *
     * @param cards array to be bound.
     */
    void bind(C[] cards);

    /**
     * @return the number of elements in this list
     * @see List#size()
     */
    int size();

    /**
     * @return <tt>true</tt> if this list contains no elements
     * @see List#isEmpty()
     */
    boolean isEmpty();

    /**
     * @param o element whose presence in this list is to be tested.
     * @return <tt>true</tt> if this list contains the specified element
     * @see List#contains(Object)
     */
    boolean contains(Object o);

    /**
     * @return an Iterator.
     * @see Iterable#iterator()
     */
    Iterator<C> iterator();

    /**
     * @return an array containing all of the elements in this list in proper
     * sequence
     * @see List#toArray()
     */
    Object[] toArray();

    /**
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     * @see List#toArray(Object[])
     */
    <T> T[] toArray(T[] a);

    /**
     * @param c collection to be checked for containment in this list
     * @return <tt>true</tt> if this list contains all of the elements of the
     * specified collection
     * @see List#containsAll(Collection)
     */
    boolean containsAll(List<?> c);

    /**
     * @see List#clear()
     */
    void clear();

    /**
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @see List#indexOf(Object)
     */
    int indexOf(Object o);

    /**
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @see List#lastIndexOf(Object)
     */
    int lastIndexOf(Object o);

    /**
     * @return a list iterator over the elements in this list (in proper
     * sequence)
     * @see List#listIterator()
     */
    ListIterator<C> listIterator();

    /**
     * @param index index of the first element to be returned from the
     *              list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list
     * @see List#listIterator(int)
     */
    ListIterator<C> listIterator(int index);

    /**
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @see List#subList(int, int)
     */
    List<C> subList(int fromIndex, int toIndex);
}
