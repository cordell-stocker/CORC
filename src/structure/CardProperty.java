package structure;

@SuppressWarnings("unused")
public interface CardProperty<P extends CardProperty> extends Comparable<P> {

    /**
     * Should be unique to the property.
     *
     * For example: If the property is the face
     * of the card in a standard 52 card deck,
     * then any card with 'Five' as the face
     * should return the same string. While any
     * other card, such as a 'Six' would return
     * something different.
     *
     * @return The string representation of this property.
     */
    String getName();

    /**
     * Should be unique to the property.
     *
     * For example: If the property is the face
     * of the card in a standard 52 card deck,
     * then any card with 'Five' as the face,
     * should return the same value. While any
     * other card, such as a 'Six' would return
     * something different.
     *
     * The main purpose of this method is to be
     * used in the Comparable interface method(s).
     *
     * @return The integer value of this property.
     */
    int getValue();
}
