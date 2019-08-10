package observablestandard;

import javafx.collections.ListChangeListener;
import structure.Card;

public interface Observable<C extends Card> {

    void addListener(ListChangeListener<C> listener);

    void removeListener(ListChangeListener<C> listener);
}
