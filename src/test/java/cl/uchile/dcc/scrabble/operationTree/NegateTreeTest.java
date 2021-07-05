package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegateTreeTest {

    private NegateTree tree1, tree2, tree3;

    @BeforeEach
    void setUp() {
        tree1 = new NegateTree(
                new ScrabbleInt(727)
        );
        tree2 = new NegateTree(
                new ScrabbleBool(true)
        );
        tree3 = new NegateTree(
                new ScrabbleBinary("110101010101011110110")  // Length does not matter in test.
        );
    }

    @Test
    void NegateTest() {
        IType result1 = tree1.getResult();
        assertEquals(result1, new ScrabbleInt(-727));

        IType result2 = tree2.getResult();
        assertEquals(result2, new ScrabbleBool(false));

        IType result3 = tree3.getResult();
        assertEquals(result3, new ScrabbleBinary("001010101010100001001"));
    }
}
