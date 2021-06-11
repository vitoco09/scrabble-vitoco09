package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

/**
 * Implementation of a Scrabble string as a class.
 * @author Victor Vidal Paz
 */
public class ScrabbleString extends AbstractType {

    private final String value;

    /**
     * Constructor of ScrabbleString.
     * @param string Java String.
     */
    public ScrabbleString(String string) {
        this.value = string;
    }

    /**
     * getValue: Getter of this class's value.
     * @return Java String being the value of this instance.
     */
    public String getValue() {
        return value;
    }

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of the Scrabble string.
     */
    @Override
    public String toString() { return this.getValue(); }

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value. In this case the string is returned by default since it makes no sense to
     * negate a string.
     */
    @Override
    public IType negate() {
        return new ScrabbleString(this.getValue());
    }

    /**
     * hashCode: Override from Object, used for proper hashing of the types using its value.
     * @return int being the hash code of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleString.class, value);
    }

    /**
     * equals: Override from Object, used for comparing two different objects.
     * @param obj Object to compare.
     * @return boolean that determines if two objects have the exact same values and share the same instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleString) {
            var o = (ScrabbleString) obj;
            return this.getValue().equals(o.getValue());
        }
        return false;
    }

    /**
     * add: Operation that adds a Scrabble string with a Scrabble type. By default this sum is done by transforming
     * the type to string and then concatenating it's values.
     * @param sType ScrabbleType concatenated to the right.
     * @return ScrabbleString containing the concatenation as its value.
     */
    public ScrabbleString add(IType sType) {
        return new ScrabbleString(this.getValue() + sType.toString());
    }

}
