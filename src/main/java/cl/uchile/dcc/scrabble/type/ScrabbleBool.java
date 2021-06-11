package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

/**
 * Implementation of a Scrabble boolean as a class. It stores a Java boolean value, so there are only two possible
 * Scrabble booleans with different values.
 * @author Victor Vidal Paz
 */
public class ScrabbleBool extends AbstractType implements ILogical {

    private final boolean value;

    /**
     * Constructor of ScrabbleBool.
     * @param bool Java boolean.
     */
    public ScrabbleBool(boolean bool) {
        this.value = bool;
    }

    /**
     * getValue: Getter of this class's value.
     * @return Java boolean being the value of this instance.
     */
    public boolean getValue() { return value; }

    /**
     * toString: Method for transforming a Scrabble type to a Java String.
     * @return String representing the value of the Scrabble boolean. If true, then returns "1". If not, then "0".
     */
    @Override
    public String toString() {
        return value ? "1" : "0";
    }

    /**
     * negate: Method for negating the value of a Scrabble type.
     * @return IType with the negated value. In this case the boolean value is negated.
     */
    @Override
    public IType negate() {
        return new ScrabbleBool(!this.getValue());
    }

    /**
     * hashCode: Override from Object, used for proper hashing of the types using its value.
     * @return int being the hash code of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBool.class, value);
    }

    /**
     * equals: Override from Object, used for comparing two different objects.
     * @param obj Object to compare.
     * @return boolean that determines if two objects have the exact same values and share the same instance.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBool) {
            var o = (ScrabbleBool) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    public ScrabbleBool toScrabbleBool() {
        return new ScrabbleBool(this.getValue());
    }

    /**
     * and: Logical conjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the conjunction. It can be a ScrabbleBool or a ScrabbleBinary.
     */
    @Override
    public ILogical and(ILogical sLogical) {
        String left = this.toString(), right = sLogical.toString();
        if (right.length() == 1) {
            return new ScrabbleBool(left.equals(right) && left.equals("1"));
        } else {
            if (left.equals("1")) {
                return new ScrabbleBinary(right);
            } else {
                return new ScrabbleBinary("0".repeat(64));
            }
        }
    }

    /**
     * or: Logical disjunction operator between two Scrabble logical types.
     * @param sLogical ScrabbleLogical type to operate on the right side.
     * @return ILogical being the result of the disjunction. It can be a ScrabbleBool or a ScrabbleBinary.
     */
    @Override
    public ILogical or(ILogical sLogical) {
        String left = this.toString(), right = sLogical.toString();
        if (right.length() == 1) {
            if (left.equals("1")) {
                return new ScrabbleBool(true);
            } else {
                return new ScrabbleBool(right.equals("1"));
            }
        } else {
            if (left.equals("1")) {
                return new ScrabbleBinary("1".repeat(64));
            } else {
                return new ScrabbleBinary(right);
            }
        }
    }

}
