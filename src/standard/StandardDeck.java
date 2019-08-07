package standard;

import structure.Binder;
import structure.Deck;

import java.util.*;

public class StandardDeck extends Deck<StandardCard> {

    private final ArrayList<StandardCard> CARDS = new ArrayList<>();

    public StandardDeck() {
        this.reset();
    }

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
    public StandardCard[] getCards() {
        StandardCard[] arr = new StandardCard[this.CARDS.size()];
        arr = this.CARDS.toArray(arr);
        return arr;
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

    @Override
    public StandardCard drawCard() {
        return this.removeCard(this.CARDS.size() - 1);
    }

    @Override
    public void reset() {
        this.clear();
        for (StandardSuit suit : StandardSuit.values()) {
            for (StandardFace face : StandardFace.values()) {
                this.addCard(new StandardCard(face, suit));
            }
        }
    }
}
