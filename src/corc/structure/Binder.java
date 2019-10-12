package corc.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides functionality for binding
 * lists together. Whether they be regular arrays
 * or some implementation of a list.
 */
public abstract class Binder extends Thread {

	/**
	 * The returned Thread object will have daemon set to true,
	 * and have been started.
	 * <p>
	 * Will have a refreshRate of 100ms.
	 *
	 * @param source an array of cards to bind to the list.
	 * @param dest   a {@link ICardset} to be bound to the array of cards.
	 * @param <C>    subclass of Card.
	 * @param <T>    subclass of Cardset.
	 * @return a thread that is already started which will ensure only
	 * elements in the array will appear in the list.
	 * @see Binder#bind(ICard[], ICardset, long)
	 */
	public static <C extends ICard, T extends ICardset<C>> Thread bind(C[] source, T dest) {
		return Binder.bind(source, dest, 100);
	}

	/**
	 * The returned Thread object will have daemon set to true,
	 * and have been started.
	 *
	 * @param source      an array of cards to bind to the list.
	 * @param dest        a {@link ICardset} to be bound to the array of cards.
	 * @param <C>         subclass of Card.
	 * @param <T>         subclass of Cardset.
	 * @param refreshRate the total milliseconds to wait between each check.
	 * @return a thread that is already started which will ensure only
	 * elements in the array will appear in the list.
	 */
	public static <C extends ICard, T extends ICardset<C>> Thread bind(C[] source, T dest, long refreshRate) {
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
					Thread.sleep(refreshRate);
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
