package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.type.ScrabbleBool;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static cl.uchile.dcc.scrabble.type.typeFactory.AbstractTypeFactory.scrabbleTypes;
import static org.junit.jupiter.api.Assertions.*;

public class ScrabbleTypeFactoryTest {

    private final List<IType> results = new ArrayList<>();

    @BeforeEach
    void setUp() {
        results.add(ScrabbleBinaryFactory.getScrabbleType("0000000000000000000000000000000000000000000110101010101011110110")); // 1747702
        results.add(ScrabbleIntFactory.getScrabbleType(314159));
        results.add(ScrabbleBinaryFactory.getScrabbleType("0000000000000000000000000000000000000000000110101010101011110110")); // 1747702
        results.add(ScrabbleStringFactory.getScrabbleType("Hello World"));
        results.add(ScrabbleBoolFactory.getScrabbleType(true));
        results.add(ScrabbleIntFactory.getScrabbleType(1747702));
        results.add(ScrabbleBoolFactory.getScrabbleType(true));
        results.add(ScrabbleFloatFactory.getScrabbleType(6.626E-34));
    }

    @Test
    void FunctionalityTest() {
        assertSame(results.get(0), results.get(2));
        assertEquals(6, scrabbleTypes.values().size());
        results.add(ScrabbleStringFactory.getScrabbleType("Hello World"));
        assertSame(results.get(3), results.get(8));
        assertEquals(6, scrabbleTypes.values().size());
        assertEquals(9, results.size());
    }

    @Test
    void DictionaryTest() {
        assertEquals(new ScrabbleInt(314159), scrabbleTypes.get("INT 314159"));
        assertEquals(new ScrabbleBool(true), scrabbleTypes.get("BOOL true"));
        assertEquals(new ScrabbleBinary("0000000000000000000000000000000000000000000110101010101011110110"),
                scrabbleTypes.get("BINARY 0000000000000000000000000000000000000000000110101010101011110110"));
    }
}
