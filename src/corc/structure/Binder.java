package corc.structure;

import java.util.ArrayList;
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
     * @param source   an array of cards to bind to the list.
     * @param dest a list to be bound to the array of cards.
     * @param <C>     subclass of Card.
     * @param <T>     subclass of Cardset.
     * @return a thread that is already started which will ensure only elements in the array appear in the list.
     */
    public static <C extends ICard, T extends ICardset<C>> Thread bind(C[] source, T dest) {
        Thread thread = new Thread(() -> {
            dest.clear();
            dest.addCards(source);

            List<C> cardsToAdd = new ArrayList<>();
            List<C> cardsToRemove = new ArrayList<>();

            boolean found;

            while (Thread.currentThread().isAlive()) {
                for (C card : source) {
                    if (card != null) {
                        found = dest.contains(card);
                        if (!found) {
                            cardsToAdd.add(card);
                        }
                    }
                }
                if (cardsToAdd.size() > 0) {
                    dest.addCards(cardsToAdd);
                    cardsToAdd.clear();
                }

                for (C card : dest) {
                    found = false;
                    for (C test : source) {
                        if (test == card) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        cardsToRemove.add(card);
                    }
                }
                if (cardsToRemove.size() > 0) {
                    dest.removeCards(cardsToRemove);
                    cardsToRemove.clear();
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        return thread;
    }

}
