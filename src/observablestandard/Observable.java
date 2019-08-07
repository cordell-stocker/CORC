package observablestandard;

import javafx.collections.ListChangeListener;
import structure.Card;

public interface Observable<C extends Card> {

    public void addListener(ListChangeListener<C> listener);

    public void removeListener(ListChangeListener<C> listener);
}
