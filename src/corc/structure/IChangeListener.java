package corc.structure;

public interface IChangeListener<T> {

    void valueChanged(T oldValue, T newValue);
}