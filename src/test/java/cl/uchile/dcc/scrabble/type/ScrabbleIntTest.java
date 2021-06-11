package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Testing for ScrabbleInt class
 * @author Victor Vidal Paz
 */
public class ScrabbleIntTest {

    private ScrabbleInt sInt1, sInt2;
    private static final int VALUE_1 = -420;
    private static final int VALUE_2 = -727;
    private static final String BINARY_1 = "1111111111111111111111111111111111111111111111111111110100101001";
    private static final String BINARY_2 = "1111111111111111111111111111111111111111111111111111111001011100";
    private static final String BINARY_3 = "0000000000000000000000000000000000000000000000000000000000001100";
    private static final String BINARY_4 = "1111111111111111111111111111111111111111111111111111001011111011";

    @BeforeEach
    void setUp() {
        sInt1 = new ScrabbleInt(VALUE_1);
        sInt2 = new ScrabbleInt(VALUE_2);
    }

    @Test
    void constructorTest() {
        var expectedInt = new ScrabbleInt(VALUE_1);
        assertEquals(expectedInt, sInt1, "Constructor error");
        assertEquals(expectedInt.hashCode(), sInt1.hashCode(), "Constructor Hash error");

        var notExpectedInt = new ScrabbleInt(VALUE_2);
        assertNotEquals(notExpectedInt, sInt1, "Constructor error");
        assertNotEquals(notExpectedInt.hashCode(), sInt1.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        String aString = String.valueOf(VALUE_1);
        var expectedString = new ScrabbleString(aString);
        assertEquals(expectedString, sInt1.toScrabbleString(), "ToScrabbleString error");
        assertEquals(expectedString.hashCode(), sInt1.toScrabbleString().hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toScrabbleFloatTest() {
        var expectedFloat = new ScrabbleFloat(VALUE_1);
        assertEquals(expectedFloat, sInt1.toScrabbleFloat(), "ToScrabbleFloat error");
        assertEquals(expectedFloat.hashCode(), sInt1.toScrabbleFloat().hashCode(), "ToScrabbleFloat Hash error");
    }

    @Test
    void toScrabbleIntTest() {
        var expectedInt = new ScrabbleInt(VALUE_1);
        assertEquals(expectedInt, sInt1.toScrabbleInt(), "toScrabbleInt error");
        assertEquals(expectedInt, sInt1.toScrabbleInt(), "toScrabbleInt error");
    }

    @Test
    void toScrabbleBinaryTest() {
        var expectedBinary1 = new ScrabbleBinary(BINARY_1);
        assertEquals(expectedBinary1, sInt2.toScrabbleBinary(), "toScrabbleBinary error");
        assertEquals(expectedBinary1.hashCode(), sInt2.toScrabbleBinary().hashCode(), "toScrabbleBinary Hash error");

        var expectedBinary2 = new ScrabbleBinary(BINARY_2);
        assertEquals(expectedBinary2, sInt1.toScrabbleBinary(), "toScrabbleBinary error");
        assertEquals(expectedBinary2.hashCode(), sInt1.toScrabbleBinary().hashCode(), "toScrabbleBinary Hash error");
    }

    @Test
    void toStringTest() {
        String expected = Integer.toString(VALUE_1);
        assertEquals(expected, sInt1.toString(), "toString error");
    }

    @Test
    void negateTest() {
        var expected = new ScrabbleInt(420);
        assertEquals(expected, sInt1.negate(), "negateTest error");
    }

    @Test
    void addTest() {
        var expectedInt1 = new ScrabbleInt(VALUE_1 + VALUE_2);
        assertEquals(expectedInt1, sInt1.add(sInt2));

        var expectedFloat = new ScrabbleFloat(VALUE_1 + 32.526);
        assertEquals(expectedFloat, sInt1.add(new ScrabbleFloat(32.526)));

        var expectedInt2 = new ScrabbleInt(VALUE_1 + 12);
        assertEquals(expectedInt2, sInt1.add(new ScrabbleBinary(BINARY_3)), "add Error: error when adding a binary");

        var expectedInt3 = new ScrabbleInt(VALUE_2 + (-3333));
        assertEquals(expectedInt3, sInt2.add(new ScrabbleBinary(BINARY_4)), "add Error: error when adding a binary");
    }

    @Test
    void subtractTest() {
        var expectedInt1 = new ScrabbleInt(VALUE_1 - VALUE_2);
        assertEquals(expectedInt1, sInt1.subtract(sInt2));

        var expectedFloat = new ScrabbleFloat(VALUE_1 - 32.526);
        assertEquals(expectedFloat, sInt1.subtract(new ScrabbleFloat(32.526)));

        var expectedInt2 = new ScrabbleInt(VALUE_1 - 12);
        assertEquals(expectedInt2, sInt1.subtract(new ScrabbleBinary(BINARY_3)), "subtract Error: error when subtracting a binary");

        var expectedInt3 = new ScrabbleInt(VALUE_2 - (-3333));
        assertEquals(expectedInt3, sInt2.subtract(new ScrabbleBinary(BINARY_4)), "subtract Error: error when subtracting a binary");
    }

    @Test
    void multiplyTest() {
        var expectedInt1 = new ScrabbleInt(VALUE_1 * VALUE_2);
        assertEquals(expectedInt1, sInt1.multiply(sInt2));

        var expectedFloat = new ScrabbleFloat(VALUE_1 * 32.526);
        assertEquals(expectedFloat, sInt1.multiply(new ScrabbleFloat(32.526)));

        var expectedInt2 = new ScrabbleInt(VALUE_1 * 12);
        assertEquals(expectedInt2, sInt1.multiply(new ScrabbleBinary(BINARY_3)), "multiply Error: error when multiplying a binary");

        var expectedInt3 = new ScrabbleInt(VALUE_2 * (-3333));
        assertEquals(expectedInt3, sInt2.multiply(new ScrabbleBinary(BINARY_4)), "multiply Error: error when multiplying a binary");
    }

    @Test
    void divideTest() {
        var expectedInt1 = new ScrabbleInt(VALUE_1 / VALUE_2);
        assertEquals(expectedInt1, sInt1.divide(sInt2));

        var expectedFloat = new ScrabbleFloat(VALUE_1 / 32.526);
        assertEquals(expectedFloat, sInt1.divide(new ScrabbleFloat(32.526)));

        var expectedInt2 = new ScrabbleInt(VALUE_1 / 12);
        assertEquals(expectedInt2, sInt1.divide(new ScrabbleBinary(BINARY_3)), "divide Error: error when dividing a binary");

        var expectedInt3 = new ScrabbleInt(VALUE_2 / (-3333));
        assertEquals(expectedInt3, sInt2.divide(new ScrabbleBinary(BINARY_4)), "divide Error: error when dividing a binary");
    }
}
