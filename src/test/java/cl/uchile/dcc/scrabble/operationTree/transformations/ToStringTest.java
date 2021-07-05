package cl.uchile.dcc.scrabble.operationTree.transformations;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.type.ScrabbleInt;
import cl.uchile.dcc.scrabble.type.ScrabbleString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests verifying functionality of ToStringTest
 */
public class ToStringTest {

    private ToStringTree tree;

    @BeforeEach
    void setUp() {
        tree = new ToStringTree(
                new ScrabbleInt(727)
        );
    }

    @Test
    void ToStringTest() {
        IType result = tree.getResult();
        assertEquals(result, new ScrabbleString("727"));
    }

}
