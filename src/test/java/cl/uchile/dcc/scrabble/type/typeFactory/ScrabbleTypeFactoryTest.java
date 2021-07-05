package cl.uchile.dcc.scrabble.type.typeFactory;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static cl.uchile.dcc.scrabble.type.typeFactory.AbstractTypeFactory.scrabbleTypes;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrabbleBinaryFactoryTest {

    private List<IType> results = new ArrayList<>();

    @BeforeEach
    void setUp() {
        results.add(ScrabbleBinaryFactory.getScrabbleType("0000000000000000000000000000000000000000000110101010101011110110")); // 1747702
        results.add(ScrabbleBinaryFactory.getScrabbleType("0000000000000000000000000000000000000000000000000000000011111111")); // 255
        results.add(ScrabbleBinaryFactory.getScrabbleType("0000000000000000000000000000000000000000000110101010101011110110")); // 1747702
        results.add(ScrabbleBinaryFactory.getScrabbleType("1111111111111111111111111111111111111111111111111111111111010000")); // -48
    }

    @Test
    void BinaryTest() {
        assertEquals(results.get(0), results.get(2));
        assertEquals(3, scrabbleTypes.values().toArray().length);
        results.add(ScrabbleBinaryFactory.getScrabbleType("1111111111111111111111111111111111111111111111111111111111010000")); // -48
        assertEquals(3, scrabbleTypes.values().size());
        assertEquals(5, results.size());
    }

}
