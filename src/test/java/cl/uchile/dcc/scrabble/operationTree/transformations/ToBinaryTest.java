package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests verifying functionality of ToBinaryTest
 */
public class ToBinaryTest {

    private ToBinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = new ToBinaryTree(
                new ScrabbleInt(1747702)
        );
    }

    @Test
    void ToBinaryTest() {
        IType result = tree.getResult();
        assertEquals(result, new ScrabbleBinary("0000000000000000000000000000000000000000000110101010101011110110"));
    }

}
