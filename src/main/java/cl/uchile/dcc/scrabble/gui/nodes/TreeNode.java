package cl.uchile.dcc.scrabble.gui.nodes;

import cl.uchile.dcc.scrabble.controller.Controller;
import cl.uchile.dcc.scrabble.operationTree.Component;
import cl.uchile.dcc.scrabble.type.IType;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

/**
 * TreeNode: Represents a Scrabble Component inside the graphical interface.
 */
public class TreeNode {
    private final int imgHeight;
    private final int imgWidth;
    private Component tree;
    private ImageView sprite;
    private int hPos;
    private int vPos;
    private Label type = new Label("null");
    private Label value = new Label();
    private boolean focused = false;

    /**
     * TreeNode: Represents a Scrabble Component inside the graphical interface.
     * @param scene Scene which TreeNode belongs to.
     * @param hPos Horizontal Position.
     * @param vPos Vertical Position.
     * @param imgHeight Height of sprite.
     * @param imgWidth Width of sprite.
     * @param spritePath Path of sprite.
     * @param tree Scrabble Component being represented.
     * @throws FileNotFoundException In case sprite image is not found.
     */
    public TreeNode(final @NotNull Scene scene, final int hPos, final int vPos,
                    final int imgHeight, final int imgWidth, final String spritePath, Component tree)
            throws FileNotFoundException {
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.hPos = hPos;
        this.vPos = vPos;
        this.tree = tree;
        addSprite(spritePath);
        sprite.setOnMouseClicked(this::setMouseTriggers);
        sprite.setOnMouseEntered(this::setFocusTriggers);
        startAnimator();
    }

    /**
     * setTree: Setter for tree
     * @param tree Scrabble Component.
     */
    public void setTree(Component tree) {
        this.tree = tree;
    }

    /**
     * getTree: Getter for tree.
     * @return Scrabble Component.
     */
    public Component getTree() {
        return this.tree;
    }

    /**
     * getNode: Getter for sprite. Its name is for an easier interpretation.
     * @return sprite.
     */
    public ImageView getNode() {
        return this.sprite;
    }

    /**
     * setPosition: Method for setting the TreeNode in an specific place.
     * @param horizontalDistance Position in x axis.
     * @param verticalDistance Position in y axis.
     */
    private void setPosition(int horizontalDistance, int verticalDistance) {
        hPos = horizontalDistance;
        vPos = verticalDistance;
    }

    /**
     * addSprite: Method for adding a sprite to TreeNode. Used inside constructor.
     * @param spritePath Path of sprite.
     * @throws FileNotFoundException If the image is not found.
     */
    private void addSprite(final String spritePath) throws FileNotFoundException {
        FileInputStream spriteImage = new FileInputStream(spritePath);
        sprite = new ImageView(new Image(spriteImage));
        sprite.setX(hPos);
        sprite.setY(vPos);
        sprite.setFitWidth(imgWidth);
        sprite.setFitHeight(imgHeight);
    }

    /**
     * startAnimator: Method that gives free movement to TreeNode.
     */
    private void startAnimator() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                sprite.setX(hPos);
                sprite.setY(vPos);
            }
        };
        timer.start();
    }

    /**
     * setMouseTriggers: Method that encapsulates mouse triggers in the scene.
     * @param mouseEvent Event happening during the detection.
     */
    private void setMouseTriggers(MouseEvent mouseEvent) {
        switch (mouseEvent.getButton()) {
            case PRIMARY:
                if (focused) {
                    setPosition((int)mouseEvent.getX() - imgWidth/2, (int)mouseEvent.getY() - imgHeight/2);
                }
            case SECONDARY:

            default:
        }
    }

    /**
     * setFocusTriggers: Method that encapsulates focus triggers in the scene.
     * @param mouseEvent Event happening during the detection.
     */
    private void setFocusTriggers(MouseEvent mouseEvent) {
        focused = 2 * (mouseEvent.getX() - hPos) / imgWidth + 2 * (mouseEvent.getY() - vPos) / imgHeight < 1;
    }

}
