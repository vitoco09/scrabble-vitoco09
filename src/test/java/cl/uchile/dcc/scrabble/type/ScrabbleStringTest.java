package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleStringTest {

    private ScrabbleString sString;
    private static final String VALUE_1 = "Holas";
    private static final String VALUE_2 = "Chaos";

    @BeforeEach
    void setUp() {
        sString = new ScrabbleString(VALUE_1);
    }

    @Test
    void constructorTest() {
        var expectedString = new ScrabbleString(VALUE_1);
        assertEquals(expectedString, sString, "Constructor error");
        assertEquals(expectedString.hashCode(), sString.hashCode(), "Constructor Hash error");

            var notExpectedString = new ScrabbleString(VALUE_2);
        assertNotEquals(notExpectedString, sString, "Constructor error");
        assertNotEquals(notExpectedString.hashCode(), sString.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        var expectedString = new ScrabbleString(VALUE_1);
        assertEquals(expectedString, sString, "toScrabbleString error");
        assertEquals(expectedString.hashCode(), sString.hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toStringTest() {
        String expected = VALUE_1;
        assertEquals(expected, sString.toString(), "toString error");
    }

}
