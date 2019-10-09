package corc.structure;

import java.util.List;

public interface ICardsetListener<C extends ICard> {

    void cardsAdded(List<? extends C> cards);

    void cardsRemoved(List<? extends C> cards);
}
