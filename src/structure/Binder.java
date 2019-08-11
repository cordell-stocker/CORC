package structure;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Binder extends Thread {

    private static long cycle = 100;

    @SuppressWarnings("unused")
    public static void setCycle(long cycle) {
        Binder.cycle = cycle;
    }

    /**
     * The returned Thread object will have daemon set to true.
     *
     * @param cards an array of cards to bind to the list.
     * @param cardset a list to be bound to the array of cards.
     * @param <C> subclass of Card.
     * @param <T> subclass of Cardset.
     * @return a thread that once started will ensure only elements in the array appear in the list.
     */
    public static <C extends Card, T extends Cardset<C>> Thread makeBinder(C[] cards, T cardset) {
        Thread thread = new Thread(() -> {
            ArrayList<C> boundAsList;
            cardset.clear();
            cardset.addCards(cards);
            ArrayList<C> addCards = new ArrayList<>();
            ArrayList<C> removeCards = new ArrayList<>();

            while (Thread.currentThread().isAlive()) {
                boundAsList = new ArrayList<>(Arrays.asList(cards));

                // Check for added cards
                addCards.clear();
                for (C boundCard : cards) {
                    if (!cardset.contains(boundCard)) {
                        addCards.add(boundCard);
                    }
                }
                cardset.addCards(addCards);

                // Check for removed cards
                removeCards.clear();
                for (C existing : cardset.getCards()) {
                    if (!boundAsList.contains(existing)) {
                        removeCards.add(existing);
                    }
                }
                cardset.removeCards(removeCards);

                try {
                    Thread.sleep(Binder.cycle);
                } catch (InterruptedException ex) {
                    break;
                }
            }
        });
        thread.setDaemon(true);

        return thread;
    }
}
