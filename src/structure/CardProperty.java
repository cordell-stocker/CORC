package structure;

/**
 * Any attribute of a {@link ICard} object should be a subclass of this.
 * This interface allows for consistency when attempting to read an attribute
 * of a Card.
 * <p>
 * A CardProperty SHOULD be immutable.
 * <p>
 * No two fundamentally different instances of a CardProperty should return the
 * same results for both {@link #getName()} and {@link #getValue()}. At least one
 * of those methods should return a different value.
 * <p>
 * In Mahjong, all cards (tiles) in the "Dots" sub-category would likely all return
 * "Dots" from getName(). However, there are nine different possible amounts of dots
 * on each card. This example does not break the given rule.
 * And in a standard 52 card deck, when looking at the face properties of a
 * "Five of Spades" and a "Five of Hearts". The face properties can return the same
 * values for both methods. Since the faces by themselves are fundamentally the same.
 * This rule is difficult to break in general (given the need for cards in a game to
 * be distinguishable from the other cards in the same game).
 * <p>
 * A clear example is a card in a standard 52 card deck, has a suit and a face.
 * Each would be a separate CardProperty contained by a Card object.
 * <p>
 * Another example would be in Mahjong, cards (tiles) belong to a category,
 * and each category has sub-categories. In this example, a subclass of CardProperty,
 * may contain another, different subclass of CardProperty.
 * So in "Old Hong Kong Mahjong", a Card object might have an attribute "category".
 * The category.getName() method would return one of: Simples, Honors, or Bonus.
 * category would also most likely contain a sub-category. So Simples would contain
 * an attribute (that is a subclass of CardProperty) of Dots, Bamboo, or Characters.
 *
 * @param <P> the object implementing this. Used for the Comparable interface.
 */
public interface CardProperty<P extends CardProperty> extends Comparable<P> {

    /**
     * Should be a unique common name of this
     * CardProperty.
     * <p>
     * For example: If the property is the face
     * of the card in a standard 52 card deck,
     * then any card with 'Five' as the face
     * should return the same string. As the
     * property is only concerned about the face
     * (any two cards with a face of "Five" are
     * fundamentally the same, even though they
     * might have different suits).
     * While any other card, such as a 'Six' would return
     * something different as its common name.
     * <p>
     * In general, this method can be used to get a
     * common name for this CardProperty.
     *
     * @return The string representation of this property.
     */
    String getName();

    /**
     * Should be unique to the common name of this
     * CardProperty.
     * <p>
     * For example: If the property is the face
     * of the card in a standard 52 card deck,
     * then any card with 'Five' as the face,
     * should return the same value. While any
     * other card, such as a 'Six' would return
     * something different.
     * <p>
     * The main purpose of this method is to be
     * used in the implementation of the Comparable
     * interface.
     * <p>
     * In general, this method should be used to
     * distinguish between unique types of a
     * common name for this CardProperty.
     *
     * @return The integer value of this property.
     */
    int getValue();
}
