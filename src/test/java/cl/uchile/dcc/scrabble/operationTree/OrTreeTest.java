package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.type.IType;
import cl.uchile.dcc.scrabble.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.type.ScrabbleBool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrTreeTest {

    private OrTree simpleTree, mixedTree;

    @BeforeEach
    void setUp() {
        simpleTree = new OrTree(
                new ScrabbleBool(true),
                new ScrabbleBool(false)
        );

        mixedTree = new OrTree(
                new ScrabbleBool(false),
                new ScrabbleBinary("0000000000000000000000000000000000000000000110101010101011110110")
        );
    }

    @Test
    void OrTest() {
        IType result1 = simpleTree.getResult();
        assertEquals(result1, new ScrabbleBool(true));

        IType result2 = mixedTree.getResult();
        assertEquals(result2, new ScrabbleBinary("0000000000000000000000000000000000000000000110101010101011110110"));

        IType result3 = new OrTree(simpleTree, mixedTree).getResult();
        assertEquals(result3, new ScrabbleBinary("1111111111111111111111111111111111111111111111111111111111111111"));
    }

}
