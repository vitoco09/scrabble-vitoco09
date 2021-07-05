package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests verifying functionality of ToFloatTest
 */
public class ToFloatTest {

    private ToFloatTree tree;

    @BeforeEach
    void setUp() {
        tree = new ToFloatTree(
                new ScrabbleInt(420)
        );
    }

    @Test
    void ToFloatTest() {
        IType result = tree.getResult();
        assertEquals(result, new ScrabbleFloat(420.0d));
    }

}
