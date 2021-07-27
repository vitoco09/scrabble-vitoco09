package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.gui.nodes.TreeNode;
import cl.uchile.dcc.scrabble.operationTree.Component;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Controller: Connects the graphic interface with the scrabble objects.
 */
public class Controller {
    private TreeNode mainTreeNode = null;

    /**
     * Controller: Connects the graphic interface with the scrabble objects.
     * @param treeNode it's the main tree of the program.
     */
    public Controller(TreeNode treeNode) {
        this.mainTreeNode = treeNode;
    }

    /**
     * getMainTreeNode: Getter for mainTreeNode.
     * @return mainTreeNode
     */
    public TreeNode getMainTreeNode() {
        return this.mainTreeNode;
    }

    /**
     * setTreeNode: Setter for treeNode
     * @param treeNode new mainTreeNode.
     */
    public void setTreeNode(TreeNode treeNode) {
        this.mainTreeNode = treeNode;
    }
}
