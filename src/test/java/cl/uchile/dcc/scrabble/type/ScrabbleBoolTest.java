package cl.uchile.dcc.scrabble.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrabbleBoolTest {

    private ScrabbleBool sBool;
    private final boolean BOOLEAN = true;

    @BeforeEach
    void setUp() {
        sBool = new ScrabbleBool(BOOLEAN);
    }

    @Test
    void constructorTest() {
        var expectedBool = new ScrabbleBool(BOOLEAN);
        assertEquals(expectedBool, sBool, "Constructor error");
        assertEquals(expectedBool.hashCode(), sBool.hashCode(), "Constructor Hash error");

        var notExpectedBool = new ScrabbleBool(false);
        assertNotEquals(notExpectedBool, sBool, "Constructor error");
        assertNotEquals(notExpectedBool.hashCode(), sBool.hashCode(), "Constructor Hash error");
    }

    @Test
    void toScrabbleStringTest() {
        String aString = String.valueOf(BOOLEAN);
        var expectedString = new ScrabbleString(aString);
        assertEquals(expectedString, sBool.toScrabbleString(), "ToScrabbleString error");
        assertEquals(expectedString.hashCode(), sBool.toScrabbleString().hashCode(), "toScrabbleString Hash error");
    }

    @Test
    void toScrabbleBoolTest() {
        var expectedBool = new ScrabbleBool(BOOLEAN);
        assertEquals(expectedBool, sBool.toScrabbleBool(), "toScrabbleBool error");
        assertEquals(expectedBool.hashCode(), sBool.toScrabbleBool().hashCode(), "toScrabbleBool Hash error");
    }

    @Test
    void toStringTest() {
        String expected = "true";
        assertEquals(expected, sBool.toString(), "toString error");
    }

}
