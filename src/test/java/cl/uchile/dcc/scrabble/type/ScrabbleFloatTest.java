package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleFloatTest {

    private ScrabbleFloat sFloat;
    private final double VALUE_1 = 5.4;

    @BeforeEach
    void setUp() {
        sFloat = new ScrabbleFloat(VALUE_1);
    }

    @Test
    void constructorTest() {
        var expectedFloat = new ScrabbleFloat(VALUE_1);
        assertEquals(expectedFloat, sFloat, "Constructor error");
        assertEquals(expectedFloat.hashCode(), sFloat.hashCode(), "Constructor Hash error");

        var notExpectedFloat = new ScrabbleFloat(VALUE_1 + 420.69);
        assertNotEquals(notExpectedFloat, sFloat, "Constructor error");
        assertNotEquals(notExpectedFloat.hashCode(), sFloat.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        String aString = String.valueOf(VALUE_1);
        var expectedString = new ScrabbleString(aString);
        assertEquals(expectedString, sFloat.toScrabbleString(), "ToScrabbleString error");
        assertEquals(expectedString.hashCode(), sFloat.toScrabbleString().hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toScrabbleFloatTest() {
        var expectedFloat = new ScrabbleFloat(VALUE_1);
        assertEquals(expectedFloat, sFloat.toScrabbleFloat(), "ToScrabbleFloat error");
        assertEquals(expectedFloat.hashCode(), sFloat.toScrabbleFloat().hashCode(), "ToScrabbleFloat Hash error");
    }

    @Test
    void toStringTest() {
        String expected = Double.toString(VALUE_1);
        assertEquals(expected, sFloat.toString(), "toString error");
    }

}
