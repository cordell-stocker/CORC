/*
 * Copyright 2019, Cordell Stocker (cordellstocker@gmail.com)
 * All rights reserved.
 *
 * This file is part of CORC.
 *
 *     CORC is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     CORC is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with CORC.  If not, see <https://www.gnu.org/licenses/>.
 */

package corc.structure;

import corc.core.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides functionality for binding
 * lists/arrays together.
 */
public abstract class Binder extends Thread {

    /**
     * @param source an array of cards to bind to the list.
     * @param dest   a {@link ICardset} to be bound to the array of cards.
     * @param <C>    subclass of Card.
     * @param <T>    subclass of Cardset.
     * @return a thread that is already started which will ensure only
     * elements in the array will appear in the list.
     * @see Binder#bind(ICard[], ICardset, long)
     * Will have a refreshRate of 100ms.
     */
    public static <C extends ICard, T extends ICardset<C>> Thread bind(C[] source, T dest) {
        return Binder.bind(source, dest, 100);
    }

    /**
     * Binds the contents of an {@link ICardset} to an {@link ICard}[].
     * Only ICards that appear in the array, will appear in the ICardset.
     * This is a one way binding. ICards directly added to the ICardset will
     * be removed.
     * <p>
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
            try {
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

                    Thread.sleep(refreshRate);
                }
            } catch (Exception e) {
                Logger.logFatal("Binding encountered fatal error.", e);
            }
        });

        thread.setDaemon(true);
        thread.start();

        return thread;
    }

}
