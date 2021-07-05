package cl.uchile.dcc.scrabble.operationTree;

import cl.uchile.dcc.scrabble.operationTree.transformations.ToBinaryTree;
import cl.uchile.dcc.scrabble.operationTree.transformations.ToBoolTree;
import cl.uchile.dcc.scrabble.operationTree.transformations.ToIntTree;
import cl.uchile.dcc.scrabble.operationTree.transformations.ToStringTree;
import cl.uchile.dcc.scrabble.type.*;
import cl.uchile.dcc.scrabble.type.typeFactory.ScrabbleFloatFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    private Component eigenTree, robustTree, shyTree, unlovelyTree, horribleTree;

    @BeforeEach
    void setUp() {
        eigenTree = new SubtractTree(
                new MultiplyTree(
                        new ScrabbleFloat(Math.sqrt(5)),
                        new ScrabbleFloat(Math.sqrt(5))
                ),
                new ToIntTree(
                        new ScrabbleBinary("0".repeat(61) + "101")
                )
        );
        robustTree = new ToStringTree(
                new SubtractTree(
                        new ScrabbleFloat(1428.57124857),
                        new ToIntTree(
                                new AndTree(
                                        new ScrabbleBool(true),
                                        new ScrabbleBinary("0".repeat(54) + "1111001101")
                                )
                        )
                )
        );
        shyTree = new ToBoolTree(
                new ToBoolTree(
                        new ToBoolTree(
                                new ToBoolTree(
                                        new ToBoolTree(
                                                new ToBoolTree(
                                                        new ScrabbleBool(3.1415926 == 3)
                                                )
                                        )
                                )
                        )
                )
        );
        unlovelyTree = new NegateTree(
                new AddTree(
                        new AddTree(
                                new ToIntTree(
                                        new ScrabbleInt(100)
                                ),
                                new SubtractTree(
                                        new DivideTree(
                                                new ScrabbleInt(440),
                                                new ScrabbleInt(11)
                                        ),
                                        new ScrabbleInt(0)
                                )
                        ),
                        new OrTree(
                              new ScrabbleBinary("0".repeat(62) + "01"),
                              new ScrabbleBinary("0".repeat(62) + "10")
                        )
                )
        );
        horribleTree = new ToBinaryTree(
                new MultiplyTree(
                        new ScrabbleBinary("0100010011011111111000010101010011110100010101111110101000010011"),
                        new ScrabbleFloat(6.626E-34)
                )
        );
    }

    @Test
    void ComplexTreeTest() {
        ScrabbleFloat expected1 = (ScrabbleFloat) eigenTree.getResult();
        assertTrue(expected1.getValue() - 0 <= 1E-10);
        ScrabbleString expected2 = (ScrabbleString) robustTree.getResult();
        assertEquals("455.5712485700001", expected2.getValue());
        ScrabbleBool expected3 = (ScrabbleBool) shyTree.getResult();
        assertFalse(expected3.getValue());
        ScrabbleInt expected4 = (ScrabbleInt) unlovelyTree.getResult();
        assertEquals(-143, expected4.getValue());
        ScrabbleBinary expected5 = (ScrabbleBinary) horribleTree.getResult();
        assertEquals("011110111111011011010111001100000001110000110110111000100001010", expected5.getValue());
    }

}
