package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Testing for ScrabbleFloat class.
 * @author Victor Vidal Paz
 */
public class ScrabbleFloatTest {

    private ScrabbleFloat sFloat1, sFloat2;
    private final double VALUE_1 = 5.4;
    private final double VALUE_2 = 3.14159;
    private static final String BINARY_1 = "0100000000101000000000000000000000000000000000000000000000000000";
    private static final String BINARY_2 = "1100000010101010000010100000000000000000000000000000000000000000";

    @BeforeEach
    void setUp() {
        sFloat1 = new ScrabbleFloat(VALUE_1);
        sFloat2 = new ScrabbleFloat(VALUE_2);
    }

    @Test
    void constructorTest() {
        var expectedFloat = new ScrabbleFloat(VALUE_1);
        assertEquals(expectedFloat, sFloat1, "Constructor error");
        assertEquals(expectedFloat.hashCode(), sFloat1.hashCode(), "Constructor Hash error");

        var notExpectedFloat = new ScrabbleFloat(VALUE_1 + 420.69);
        assertNotEquals(notExpectedFloat, sFloat1, "Constructor error");
        assertNotEquals(notExpectedFloat.hashCode(), sFloat1.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        String aString = String.valueOf(VALUE_1);
        var expectedString = new ScrabbleString(aString);
        assertEquals(expectedString, sFloat1.toScrabbleString(), "ToScrabbleString error");
        assertEquals(expectedString.hashCode(), sFloat1.toScrabbleString().hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toScrabbleFloatTest() {
        var expectedFloat = new ScrabbleFloat(VALUE_1);
        assertEquals(expectedFloat, sFloat1.toScrabbleFloat(), "ToScrabbleFloat error");
        assertEquals(expectedFloat.hashCode(), sFloat1.toScrabbleFloat().hashCode(), "ToScrabbleFloat Hash error");
    }

    @Test
    void toStringTest() {
        String expected = Double.toString(VALUE_1);
        assertEquals(expected, sFloat1.toString(), "toString error");
    }

    @Test
    void negateTest() {
        var expected = new ScrabbleFloat(-VALUE_2);
        assertEquals(expected, sFloat2.negate(), "negateTest error");
    }

    @Test
    void addTest() {
        var expectedFloat1 = new ScrabbleFloat(VALUE_1 + VALUE_2);
        assertEquals(expectedFloat1, sFloat1.add(sFloat2));

        var expectedFloat2 = new ScrabbleFloat(VALUE_1 + 69);
        assertEquals(expectedFloat2, sFloat1.add(new ScrabbleInt(69)));

        var expectedFloat3 = new ScrabbleFloat(VALUE_1 + 12.0);
        assertEquals(expectedFloat3, sFloat1.add(new ScrabbleBinary(BINARY_1)), "add error: error when adding a binary");

        var expectedFloat4 = new ScrabbleFloat(VALUE_2 + (-3333.0));
        assertEquals(expectedFloat4, sFloat2.add(new ScrabbleBinary(BINARY_2)), "add error: error when adding a binary");
    }

    @Test
    void subtractTest() {
        var expectedFloat1 = new ScrabbleFloat(VALUE_1 - VALUE_2);
        assertEquals(expectedFloat1, sFloat1.subtract(sFloat2));

        var expectedFloat2 = new ScrabbleFloat(VALUE_1 - 69);
        assertEquals(expectedFloat2, sFloat1.subtract(new ScrabbleInt(69)));

        var expectedFloat3 = new ScrabbleFloat(VALUE_1 - 12.0);
        assertEquals(expectedFloat3, sFloat1.subtract(new ScrabbleBinary(BINARY_1)), "subtract error: error when subtracting a binary");

        var expectedFloat4 = new ScrabbleFloat(VALUE_2 - (-3333.0));
        assertEquals(expectedFloat4, sFloat2.subtract(new ScrabbleBinary(BINARY_2)), "subtract error: error when subtracting a binary");
    }

    @Test
    void multiplyTest() {
        var expectedFloat1 = new ScrabbleFloat(VALUE_1 * VALUE_2);
        assertEquals(expectedFloat1, sFloat1.multiply(sFloat2));

        var expectedFloat2 = new ScrabbleFloat(VALUE_1 * 69);
        assertEquals(expectedFloat2, sFloat1.multiply(new ScrabbleInt(69)));

        var expectedFloat3 = new ScrabbleFloat(VALUE_1 * 12.0);
        assertEquals(expectedFloat3, sFloat1.multiply(new ScrabbleBinary(BINARY_1)), "multiply error: error when multiplying a binary");

        var expectedFloat4 = new ScrabbleFloat(VALUE_2 * (-3333.0));
        assertEquals(expectedFloat4, sFloat2.multiply(new ScrabbleBinary(BINARY_2)), "multiply error: error when multiplying a binary");
    }

    @Test
    void divideTest() {
        var expectedFloat1 = new ScrabbleFloat(VALUE_1 / VALUE_2);
        assertEquals(expectedFloat1, sFloat1.divide(sFloat2));

        var expectedFloat2 = new ScrabbleFloat(VALUE_1 / 69);
        assertEquals(expectedFloat2, sFloat1.divide(new ScrabbleInt(69)));

        var expectedFloat3 = new ScrabbleFloat(VALUE_1 / 12.0);
        assertEquals(expectedFloat3, sFloat1.divide(new ScrabbleBinary(BINARY_1)), "divide error: error when dividing a binary");

        var expectedFloat4 = new ScrabbleFloat(VALUE_2 / (-3333.0));
        assertEquals(expectedFloat4, sFloat2.divide(new ScrabbleBinary(BINARY_2)), "divide error: error when dividing a binary");
    }

    /**
     * Tests of null methods for coverage, it's assumed that a null return should not be possible.
     */
    @Test
    void nullTest() {
        assertNull(sFloat1.toScrabbleInt());
        assertNull(sFloat1.and(sFloat2));
        assertNull(sFloat1.or(sFloat2));
        assertNull(sFloat1.toScrabbleBool());
        assertNull(sFloat1.toScrabbleBinary());
        assertNull(sFloat1.addToString(new ScrabbleString("Hello World")));
    }
}
