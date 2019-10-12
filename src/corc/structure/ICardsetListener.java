package corc.structure;

import java.util.List;

/**
 * Implementations of this MAY perform actions
 * whenever the methods are called.
 * <p>
 * The {@link ICardsetListener#cardsAdded(List)} SHOULD be
 * called whenever the {@link ICardset}, containing a reference
 * of this class, has {@link ICard}s added. With only the added
 * ICards given to the parameter.
 * <p>
 * Likewise the {@link ICardsetListener#cardsRemoved(List)} SHOULD
 * be called whenever the ICardset, containing a reference of this
 * class, has ICards removed. With only the added ICards given to
 * the parameter.
 *
 * @param <C> The subclass of {@link ICard} to be used.
 */
public interface ICardsetListener<C extends ICard> {

	/**
	 * MAY perform actions when called.
	 * <p>
	 * MAY use the given cards.
	 *
	 * @param cards the cards that have been added.
	 */
    void cardsAdded(List<? extends C> cards);

    /**
     * MAY perform actions when called.
     * <p>
     * MAY use the given cards.
     *
     * @param cards the cards that have been removed.
     */
	void cardsRemoved(List<? extends C> cards);
}
