package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.type.ScrabbleBool;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests verifying functionality of ToBoolTest
 */
public class ToBoolTest {

    private ToBoolTree tree;

    @BeforeEach
    void setUp() {
        tree = new ToBoolTree(
                new ScrabbleBool(false)
        );
    }

    @Test
    void ToBoolTest() {
        IType result = tree.getResult();
        assertEquals(result, new ScrabbleBool(false));
    }

}
