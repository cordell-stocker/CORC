package observablestandard;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import standard.Card;
import structure.Binder;

import java.util.*;

public class Cardset implements structure.Cardset<Card>, Observable<Card> {

    private final SimpleListProperty<Card> CARDS;

    public Cardset() {
        this.CARDS = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    @Override
    public boolean addCard(Card card) {
        return this.CARDS.add(card);
    }

    @Override
    public void addCard(int index, Card element) {
        this.CARDS.add(index, element);
    }

    @Override
    public boolean addCards(Card[] cards) {
        Collection<Card> asList = Arrays.asList(cards);
        return this.CARDS.addAll(asList);
    }

    @Override
    public boolean addCards(Collection<Card> cards) {
        return this.CARDS.addAll(cards);
    }

    @Override
    public boolean addCards(int index, Collection<? extends Card> cards) {
        return this.CARDS.addAll(index, cards);
    }

    @Override
    public boolean removeCard(Card card) {
        return this.CARDS.remove(card);
    }

    @Override
    public Card removeCard(int index) {
        return this.CARDS.remove(index);
    }

    @Override
    public boolean removeCards(Card[] cards) {
        Collection<Card> asList = Arrays.asList(cards);
        return this.CARDS.removeAll(asList);
    }

    @Override
    public boolean removeCards(Collection<Card> cards) {
        return this.CARDS.removeAll(cards);
    }

    @Override
    public Card getCard(int index) {
        return this.CARDS.get(index);
    }

    @Override
    public Card[] getCards() {
        Card[] arr = new Card[this.CARDS.size()];
        arr = this.CARDS.toArray(arr);
        return arr;
    }

    @Override
    public Card setCard(int index, Card element) {
        return this.CARDS.set(index, element);
    }

    @Override
    public boolean retainCards(Collection<?> c) {
        return this.CARDS.retainAll(c);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.CARDS);
    }

    @Override
    public void sort() {
        Collections.sort(this.CARDS);
    }

    @Override
    public void bind(Card[] cards) {
        Thread thread = Binder.makeBinder(cards, this);
        thread.start();
    }

    @Override
    public int size() {
        return this.CARDS.size();
    }

    @Override
    public boolean isEmpty() {
        return this.CARDS.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.CARDS.contains(o);
    }

    @Override
    public Iterator<Card> iterator() {
        return this.CARDS.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.CARDS.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.CARDS.toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.CARDS.containsAll(c);
    }

    @Override
    public void clear() {
        this.CARDS.clear();
    }

    @Override
    public int indexOf(Object o) {
        return this.CARDS.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.CARDS.lastIndexOf(o);
    }

    @Override
    public ListIterator<Card> listIterator() {
        return this.CARDS.listIterator();
    }

    @Override
    public ListIterator<Card> listIterator(int index) {
        return this.CARDS.listIterator(index);
    }

    @Override
    public List<Card> subList(int fromIndex, int toIndex) {
        return this.CARDS.subList(fromIndex, toIndex);
    }

    @Override
    public void addListener(ListChangeListener<Card> listener) {
        this.CARDS.addListener(listener);
    }

    @Override
    public void removeListener(ListChangeListener<Card> listener) {
        this.CARDS.removeListener(listener);
    }
}
