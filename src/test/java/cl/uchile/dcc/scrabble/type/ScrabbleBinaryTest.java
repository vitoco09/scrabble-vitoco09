package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleBinaryTest {

    private ScrabbleBinary sBinary1;
    private ScrabbleBinary sBinary2;
    private final String VALUE_1 = "0000000000000000000000000000000000000000000000000000001011010111"; // 64-bit for
    private final String VALUE_2 = "1111111111111111111111111111111111111111111111111111111001011100"; // double rep.
    private final int NUM_1 = 727;
    private final int NUM_2 = -420;
    private final double DOUBLE_1 = 4.995053634E-315;

    @BeforeEach
    void setUp() {
        sBinary1 = new ScrabbleBinary(VALUE_1);
        sBinary2 = new ScrabbleBinary(VALUE_2);
    }

    @Test
    void constructorTest() {
        var expectedBinary = new ScrabbleBinary(VALUE_1);
        assertEquals(expectedBinary, sBinary1, "Constructor error");
        assertEquals(expectedBinary.hashCode(), sBinary1.hashCode(), "Constructor Hash error");

        var notExpectedBinary = new ScrabbleBinary(VALUE_2);
        assertNotEquals(notExpectedBinary, sBinary1, "Constructor error");
        assertNotEquals(notExpectedBinary.hashCode(), sBinary1.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        var expectedString = new ScrabbleString(VALUE_1);
        assertEquals(expectedString, sBinary1.toScrabbleString(), "ToScrabbleString error");
        assertEquals(expectedString.hashCode(), sBinary1.toScrabbleString().hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toScrabbleFloatTest() {
        var expectedFloat = new ScrabbleFloat(DOUBLE_1);
        assertEquals(expectedFloat, sBinary1.toScrabbleFloat(), "ToScrabbleFloat error");
        assertEquals(expectedFloat.hashCode(), sBinary1.toScrabbleFloat().hashCode(), "ToScrabbleFloat Hash error");
    }

    @Test
    void toScrabbleInt() {
        var expectedInt1 = new ScrabbleInt(NUM_1);
        assertEquals(expectedInt1, sBinary1.toScrabbleInt(), "toScrabbleInt error");
        assertEquals(expectedInt1.hashCode(), sBinary1.toScrabbleInt().hashCode(), "toScrabbleInt Hash error");

        var expectedInt2 = new ScrabbleInt(NUM_2);
        assertEquals(expectedInt2, sBinary2.toScrabbleInt(), "toScrabbleInt error");
        assertEquals(expectedInt2.hashCode(), sBinary2.toScrabbleInt().hashCode(), "toScrabbleInt Hash error");
    }

    @Test
    void toScrabbleBinaryTest() {
        var expectedBinary = new ScrabbleBinary(VALUE_1);
        assertEquals(expectedBinary, sBinary1.toScrabbleBinary(), "toScrabbleBinary error");
        assertEquals(expectedBinary.hashCode(), sBinary1.toScrabbleBinary().hashCode(), "toScrabbleBinary Hash error");
    }

    @Test
    void toStringTest() {
        String expected = VALUE_1;
        assertEquals(expected, sBinary1.toString(), "toString error");
    }

}
