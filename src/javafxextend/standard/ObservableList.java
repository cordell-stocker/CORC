package javafxextend.standard;

import javafx.collections.ListChangeListener;
import structure.ICard;

@SuppressWarnings("unused")
public interface ObservableList<C extends ICard> {

    void addListener(ListChangeListener<C> listener);

    void removeListener(ListChangeListener<C> listener);
}
