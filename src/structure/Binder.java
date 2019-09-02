package structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public abstract class Binder extends Thread {

    /**
     * The returned Thread object will have daemon set to true,
     * and have been started.
     * <p>
     * This method will creates large amounts of garbage. As such, this method
     * SHOULD be avoided whenever possible.
     *
     * @param cards   an array of cards to bind to the list.
     * @param cardset a list to be bound to the array of cards.
     * @param <C>     subclass of Card.
     * @param <T>     subclass of Cardset.
     * @return a thread that is already started which will ensure only elements in the array appear in the list.
     */
    public static <C extends ICard, T extends ICardset<C>> Thread bind(C[] cards, T cardset) {
        Thread thread = new Thread(() -> {
            List<C> boundAsList;
            cardset.clear();
            cardset.addCards(cards);
            ArrayList<C> cardsToAdd = new ArrayList<>();
            ArrayList<C> cardsToRemove = new ArrayList<>();

            while (Thread.currentThread().isAlive()) {
                boundAsList = Arrays.asList(cards);

                // Check for added cards
                cardsToAdd.clear();
                for (C boundCard : boundAsList) {
                    if (!cardset.contains(boundCard)) {
                        cardsToAdd.add(boundCard);
                    }
                }

                // Check for removed cards
                cardsToRemove.clear();
                for (C existing : cardset) {
                    if (!boundAsList.contains(existing)) {
                        cardsToRemove.add(existing);
                    }
                }

                // Add and remove cards
                cardset.addCards(cardsToAdd);
                cardset.removeCards(cardsToRemove);
            }
        });
        thread.setDaemon(true);
        thread.start();

        return thread;
    }
}
