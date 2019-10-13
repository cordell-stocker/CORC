package corc.standard;

import corc.structure.Binder;
import corc.structure.ICardset;
import corc.structure.ICardsetListener;

import java.util.*;

public class Cardset implements ICardset<Card> {

    private final List<ICardsetListener<Card>> LISTENERS = new ArrayList<>();
    private final List<Card> CARDS;

    public Cardset(List<Card> cards) {
        this.CARDS = cards;
    }

    /**
     * @param card Card to be added.
     * @return true (as specified by {@link Collection#add(Object)}.
     * @see List#add(Object)
     */
    @Override
    public boolean addCard(Card card) {
        this.fireCardsAdded(new Card[]{card});
        return this.CARDS.add(card);
    }

    /**
     * @param index index at which the specified element is to be inserted
     * @param card  element to be inserted
     * @see List#add(int, Object)
     */
    @Override
    public void addCard(int index, Card card) {
        this.fireCardsAdded(new Card[]{card});
        this.CARDS.add(index, card);
    }

    /**
     * @param cards Cards to be added.
     * @return true if this list changed as a result of the call.
     * @see List#addAll(Collection)
     */
    @Override
    public boolean addCards(Card[] cards) {
        this.fireCardsAdded(cards);
        return this.CARDS.addAll(Arrays.asList(cards));
    }

    /**
     * @param cards Card to be added.
     * @return true if this list changed as a result of the call.
     * @see List#addAll(Collection)
     */
    @Override
    public boolean addCards(List<Card> cards) {
        this.fireCardsAdded(cards);
        return this.CARDS.addAll(cards);
    }

    /**
     * @param index index at which to insert the first element from the
     *              specified collection.
     * @param cards collection containing elements to be added to this list.
     * @return <tt>true</tt> if this list changed as a result of the call.
     * @see List#addAll(int, Collection)
     */
    @Override
    public boolean addCards(int index, List<? extends Card> cards) {
        this.fireCardsAdded(cards);
        return this.CARDS.addAll(index, cards);
    }

    /**
     * @param card Card to be removed
     * @return true if this Cardset contained the specified Card.
     * @see List#remove(Object)
     */
    @Override
    public boolean removeCard(Card card) {
        this.fireCardsRemoved(new Card[]{card});
        return this.CARDS.remove(card);
    }

    /**
     * @param index the index of the Card to be removed
     * @return the Card previously contained at the specified position.
     * @see List#remove(int)
     */
    @Override
    public Card removeCard(int index) {
        Card card = this.CARDS.remove(index);
        this.fireCardsRemoved(new Card[]{card});
        return card;
    }

    /**
     * @param cards Card to be removed from this.
     * @return true if this Cardset changed as a result of the call.
     * @see List#removeAll(Collection)
     */
    @Override
    public boolean removeCards(Card[] cards) {
        this.fireCardsRemoved(cards);
        return this.CARDS.removeAll(Arrays.asList(cards));
    }

    /**
     * @param cards Cards to be removed from this.
     * @return true if this Cardset changed as a result of the call.
     * @see List#removeAll(Collection)
     */
    @Override
    public boolean removeCards(List<Card> cards) {
        this.fireCardsRemoved(cards);
        return this.CARDS.removeAll(cards);
    }

    /**
     * @param index specified card to get.
     * @return the card at the specified location.
     * @see List#get(int)
     */
    @Override
    public Card getCard(int index) {
        return this.CARDS.get(index);
    }

    /**
     * Should return the cards stored in this, but not the direct
     * reference to any internal variables.
     *
     * @return array of the stored cards.
     */
    @Override
    public Card[] getCards() {
        int size = this.CARDS.size();
        Card[] cards = new Card[size];
        for (int i = 0; i < size; i++) {
            cards[i] = this.CARDS.get(i);
        }
        return cards;
    }

    /**
     * @param index index of the element to replace
     * @param card  element to be stored at the specified position
     * @return the element previously at the specified position
     * @see List#set(int, Object)
     */
    @Override
    public Card setCard(int index, Card card) {
        Card oldCard = this.CARDS.set(index, card);
        this.fireCardsRemoved(new Card[]{oldCard});
        this.fireCardsAdded(new Card[]{card});
        return oldCard;
    }

    /**
     * @param cards collection containing elements to be retained in this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @see List#retainAll(Collection)
     */
    @Override
    public boolean retainCards(List<?> cards) {
        List<Card> removedCards = new ArrayList<>();
        for (Card card : this) {
            if (!cards.contains(card)) {
                removedCards.add(card);
            }
        }
        if (removedCards.size() > 0) {
            this.fireCardsRemoved(removedCards);
        }
        //noinspection SuspiciousMethodCalls
        return this.CARDS.retainAll(cards);
    }

    /**
     * SHOULD randomly shuffle this. Such that the Cards
     * stored by this would not appear in the same order
     * as another Cardset after the sort() method is called
     * on the other.
     * Set logic: Cardset.shuffle() != Cardset.sort()
     * <p>
     * This method SHOULD NOT shuffle the same pattern on
     * each call. (e.x. SHOULD NOT always swap index 1 and 17).
     * While there can be a possibility that two Cardsets result
     * in the same order after this method, the chance should be
     * unlikely.
     * Set logic: Cardset.shuffle() != Cardset.shuffle()
     */
    @Override
    public void shuffle() {
        Collections.shuffle(this.CARDS);
    }

    /**
     * Should sort this in a consistent manner.
     * <p>
     * Any number of calls to this method on the same
     * Deck should produce the same ordering of Cards
     * stored internally.
     * Set logic: Cardset.sort() == Cardset.sort()
     */
    @Override
    public void sort() {
        Collections.sort(this.CARDS);
    }

    /**
     * Binds a normal array to this list.
     *
     * @param cards array to be bound.
     */
    @Override
    public void bind(Card[] cards) {
        Binder.bind(cards, this);
    }

    /**
     * @return the number of elements in this list
     * @see List#size()
     */
    @Override
    public int size() {
        return this.CARDS.size();
    }

    /**
     * @return <tt>true</tt> if this list contains no elements
     * @see List#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return this.CARDS.isEmpty();
    }

    /**
     * @param o element whose presence in this list is to be tested.
     * @return <tt>true</tt> if this list contains the specified element
     * @see List#contains(Object)
     */
    @Override
    public boolean contains(Object o) {
        //noinspection SuspiciousMethodCalls
        return this.CARDS.contains(o);
    }

    /**
     * @return an Iterator.
     * @see Iterable#iterator()
     */
    @Override
    public Iterator<Card> iterator() {
        return this.CARDS.iterator();
    }

    /**
     * @return an array containing all of the elements in this list in proper
     * sequence
     * @see List#toArray()
     */
    @Override
    public Object[] toArray() {
        return this.CARDS.toArray();
    }

    /**
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     * @see List#toArray(Object[])
     */
    @Override
    public <T> T[] toArray(T[] a) {
        //noinspection SuspiciousToArrayCall
        return this.CARDS.toArray(a);
    }

    /**
     * @param cards collection to be checked for containment in this list
     * @return <tt>true</tt> if this list contains all of the elements of the
     * specified collection
     * @see List#containsAll(Collection)
     */
    @Override
    public boolean containsAll(List<?> cards) {
        return this.CARDS.containsAll(cards);
    }

    /**
     * @see List#clear()
     */
    @Override
    public void clear() {
        this.fireCardsRemoved(this.CARDS);
        this.CARDS.clear();
    }

    /**
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @see List#indexOf(Object)
     */
    @Override
    public int indexOf(Object o) {
        //noinspection SuspiciousMethodCalls
        return this.CARDS.indexOf(o);
    }

    /**
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @see List#lastIndexOf(Object)
     */
    @Override
    public int lastIndexOf(Object o) {
        //noinspection SuspiciousMethodCalls
        return this.CARDS.lastIndexOf(o);
    }

    /**
     * @return a list iterator over the elements in this list (in proper
     * sequence)
     * @see List#listIterator()
     */
    @Override
    public ListIterator<Card> listIterator() {
        return this.CARDS.listIterator();
    }

    /**
     * @param index index of the first element to be returned from the
     *              list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list
     * @see List#listIterator(int)
     */
    @Override
    public ListIterator<Card> listIterator(int index) {
        return this.CARDS.listIterator(index);
    }

    /**
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @see List#subList(int, int)
     */
    @Override
    public List<Card> subList(int fromIndex, int toIndex) {
        return this.CARDS.subList(fromIndex, toIndex);
    }

    public void addCardsetListener(ICardsetListener<Card> listener) {
        this.LISTENERS.add(listener);
    }

    public void removeCardsetListener(ICardsetListener<Card> listener) {
        this.LISTENERS.remove(listener);
    }

    private void fireCardsAdded(Card[] cards) {
        List<Card> nonNullCards = new ArrayList<>();
        for (Card card : cards) {
            if (card != null) {
                nonNullCards.add(card);
            }
        }
        this.fireCardsAdded(nonNullCards);
    }

    private void fireCardsAdded(List<? extends Card> cards) {
        for (ICardsetListener<Card> listener : this.LISTENERS) {
            listener.cardsAdded(cards);
        }
    }

    private void fireCardsRemoved(Card[] cards) {
        List<Card> nonNullCards = new ArrayList<>();
        for (Card card : cards) {
            if (card != null) {
                nonNullCards.add(card);
            }
        }
        this.fireCardsRemoved(nonNullCards);
    }

    private void fireCardsRemoved(List<? extends Card> cards) {
        for (ICardsetListener<Card> listener : this.LISTENERS) {
            listener.cardsRemoved(cards);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int sizeMinusOne = this.size() - 1;
        sb.append("[");
        for (int i = 0; i < sizeMinusOne; i++) {
            sb.append(this.getCard(i).getDescription()).append(", ");
        }
        if (this.size() > 0) {
            sb.append(this.getCard(sizeMinusOne).getDescription()).append("]");
        }
        return sb.toString();
    }
}