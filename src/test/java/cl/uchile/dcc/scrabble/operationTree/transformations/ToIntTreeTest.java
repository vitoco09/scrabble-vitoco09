package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests verifying functionality of ToIntTest
 */
public class ToIntTreeTest {

    private ToIntTree tree;

    @BeforeEach
    void setUp() {
        tree = new ToIntTree(
                new ScrabbleBinary("0000000000000000000000000000000000000000000110101010101011110110")
        );
    }

    @Test
    void ToIntTest() {
        IType result = tree.getResult();
        assertEquals(result, new ScrabbleInt(1747702));
    }

}
