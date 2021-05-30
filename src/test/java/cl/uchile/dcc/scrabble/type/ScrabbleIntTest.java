package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleIntTest {

    private ScrabbleInt sInt1, sInt2;
    private static final int VALUE_1 = -420;
    private static final int VALUE_2 = -727;
    private static final String BINARY_1 = "1111111111111111111111111111111111111111111111111111110100101001";
    private static final String BINARY_2 = "1111111111111111111111111111111111111111111111111111111001011100";

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
}
