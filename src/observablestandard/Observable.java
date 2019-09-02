package observablestandard;

import javafx.collections.ListChangeListener;
import structure.ICard;

@SuppressWarnings("unused")
public interface Observable<C extends ICard> {

    void addListener(ListChangeListener<C> listener);

    void removeListener(ListChangeListener<C> listener);
}
