package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndTreeTest {

    private AndTree simpleTree, mixedTree;

    @BeforeEach
    void setUp() {
        simpleTree = new AndTree(
                new ScrabbleBool(true),
                new ScrabbleBool(false)
        );

        mixedTree = new AndTree(
                new ScrabbleBool(true),
                new ScrabbleBinary("0000000000000000000000000000000000000000000110101010101011110110")
        );
    }

    @Test
    void AndTest() {
        IType result1 = simpleTree.getResult();
        assertEquals(result1, new ScrabbleBool(false));

        IType result2 = mixedTree.getResult();
        assertEquals(result2, new ScrabbleBinary("0000000000000000000000000000000000000000000110101010101011110110"));

        IType result3 = new AndTree(simpleTree, mixedTree).getResult();
        assertEquals(result3, new ScrabbleBinary("0000000000000000000000000000000000000000000000000000000000000000"));
    }

}
