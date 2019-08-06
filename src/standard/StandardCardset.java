package standard;

import structure.Cardset;

import java.util.*;

public class StandardCardset implements Cardset<StandardCard> {

    private final ArrayList<StandardCard> CARDS = new ArrayList<>();

    @Override
    public boolean addCard(StandardCard card) {
        return this.CARDS.add(card);
    }

    @Override
    public void addCard(int index, StandardCard element) {
        this.CARDS.add(index, element);
    }

    @Override
    public boolean addCards(StandardCard[] cards) {
        Collection<StandardCard> asList = Arrays.asList(cards);
        return this.CARDS.addAll(asList);
    }

    @Override
    public boolean addCards(Collection<StandardCard> cards) {
        return this.CARDS.addAll(cards);
    }

    @Override
    public boolean addCards(int index, Collection<? extends StandardCard> cards) {
        return this.CARDS.addAll(index, cards);
    }

    @Override
    public boolean removeCard(StandardCard card) {
        return this.CARDS.remove(card);
    }

    @Override
    public StandardCard removeCard(int index) {
        return this.CARDS.remove(index);
    }

    @Override
    public boolean removeCards(StandardCard[] cards) {
        Collection<StandardCard> asList = Arrays.asList(cards);
        return this.CARDS.removeAll(asList);
    }

    @Override
    public boolean removeCards(Collection<StandardCard> cards) {
        return this.CARDS.removeAll(cards);
    }

    @Override
    public StandardCard getCard(int index) {
        return this.CARDS.get(index);
    }

    @Override
    public StandardCard setCard(int index, StandardCard element) {
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
    public void bind(StandardCard[] cards) {
        throw new UnsupportedOperationException();
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
    public Iterator<StandardCard> iterator() {
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
    public ListIterator<StandardCard> listIterator() {
        return this.CARDS.listIterator();
    }

    @Override
    public ListIterator<StandardCard> listIterator(int index) {
        return this.CARDS.listIterator(index);
    }

    @Override
    public List<StandardCard> subList(int fromIndex, int toIndex) {
        return this.CARDS.subList(fromIndex, toIndex);
    }
}
