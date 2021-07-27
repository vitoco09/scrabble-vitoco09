package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.controller.Controller;
import cl.uchile.dcc.scrabble.gui.nodes.TreeNode;
import cl.uchile.dcc.scrabble.operationTree.*;
import cl.uchile.dcc.scrabble.operationTree.transformations.*;
import cl.uchile.dcc.scrabble.type.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Víctor Vidal Paz
 */
public class Scrabble extends Application {

  private static final String RESOURCE_PATH = "src/main/resources/";
  private static final Double fontSize = 3.0;
  private String pseudoCodeString = "null";
  private Stage window;
  private Scene mainScene, opSelectScene, transSelectScene, valueSelectScene, pseudoCodeScene;
  private Label ans, pseudoCodeLabel;
  private TextField valueField;
  private Controller controller;


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    window = primaryStage;
    window.setTitle("S C R A B B L E W A V E");

    Group root = new Group();
    VBox selectOpLayout = new VBox(5);
    VBox selectTransLayout = new VBox(5);
    VBox selectTypeLayout = new VBox(5);
    VBox pseudoCodeLayout = new VBox(5);
    mainScene = new Scene(root, 1280, 720);
    opSelectScene = new Scene(selectOpLayout, 250, 400);
    transSelectScene = new Scene(selectTransLayout, 250, 400);
    valueSelectScene = new Scene(selectTypeLayout, 250, 400);
    pseudoCodeScene = new Scene(pseudoCodeLayout, 640, 480);

    Label title = new Label("S C R A B B L E W A V E");
    title.setStyle("-fx-font-size: "+fontSize+"em;");
    title.setLayoutX(640); title.setLayoutY(50);
    var background =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.jpg")));
    playVaporWave();

    ans = new Label("Result: ");
    ans.setStyle("-fx-font-size: "+4.0d+"em;");
    ans.setLayoutX(700); ans.setLayoutY(500);

    valueField = new TextField();
    valueField.setMaxWidth(80);
    valueField.setPromptText("Value");

    controller = new Controller(new TreeNode(mainScene, 500, 500, 200, 200,
            RESOURCE_PATH + "approachcircle.png", null));

    selectOpLayout.setAlignment(Pos.BASELINE_CENTER);
    Label layout1 = new Label("Select the operation");
    selectOpLayout.getChildren().addAll(layout1, new Label(), addButton(), subtractButton(),
            multiplyButton(), divideButton(), andButton(), orButton(), negateButton(),
            new Label(), backButton());

    selectTransLayout.setAlignment(Pos.BASELINE_CENTER);
    Label layout2 = new Label("Select the transformation");
    selectTransLayout.getChildren().addAll(layout2, new Label(), toStringButton(), toIntButton(),
            toFloatButton(), toBoolButton(), toBinaryButton(), new Label(), backButton());

    selectTypeLayout.setAlignment(Pos.BASELINE_CENTER);
    Label layout3 = new Label("Introduce the value and select it's type");
    selectTypeLayout.getChildren().addAll(layout3, new Label(), valueField, stringButton(), intButton(),
            floatButton(), boolButton(), binaryButton(), new Label(), backButton());

    pseudoCodeLabel = new Label(pseudoCodeString);
    pseudoCodeLayout.getChildren().addAll(new Label("Pseudo-Code"), new Label(), pseudoCodeLabel,
            new Label(), backButton());

    root.getChildren().add(background);
    root.getChildren().add(title);
    root.getChildren().add(ans);
    root.getChildren().add(newOperation());
    root.getChildren().add(newTransformation());
    root.getChildren().add(newValue());
    root.getChildren().add(clearAll());
    root.getChildren().add(pseudoCode());
    root.getChildren().add(resultButton());
    root.getChildren().add(controller.getMainTreeNode().getNode());

    window.setScene(mainScene);
    window.show();
  }

  private void setPseudoCodeString(String pseudoCodeString) {
    pseudoCodeLabel.setText(pseudoCodeString);
  }

  // Buttons

  private @NotNull Button newOperation() {
    var button = new Button("Add Operation");
    button.setLayoutX(70);
    button.setLayoutY(200);
    button.setFocusTraversable(true);
    button.setOnAction(e -> window.setScene(opSelectScene));
    return button;
  }

  private @NotNull Button newTransformation() {
    var button = new Button("Add Transformation");
    button.setLayoutX(70);
    button.setLayoutY(300);
    button.setFocusTraversable(true);
    button.setOnAction(e -> window.setScene(transSelectScene));
    return button;
  }

  private @NotNull Button newValue() {
    var button = new Button("Add Value");
    button.setLayoutX(70);
    button.setLayoutY(400);
    button.setFocusTraversable(true);
    button.setOnAction(e -> window.setScene(valueSelectScene));
    return button;
  }

  private @NotNull Button clearAll() {
    var button = new Button("Clear Tree");
    button.setLayoutX(1100);
    button.setLayoutY(200);
    button.setFocusTraversable(true);
    button.setOnAction(e ->  {
      controller.getMainTreeNode().setTree(null);
      setPseudoCodeString("null");
      ans.setText("Result: ");
    });
    return button;
  }

  private @NotNull Button backButton() {
    var button = new Button("Back");
    button.setFocusTraversable(true);
    button.setOnAction(e -> window.setScene(mainScene));
    return button;
  }

  private @NotNull Button pseudoCode() {
    var button = new Button("Show PseudoCode");
    button.setLayoutX(1100);
    button.setLayoutY(300);
    button.setFocusTraversable(true);
    button.setOnAction(e -> window.setScene(pseudoCodeScene));
    return button;
  }

  private @NotNull Button resultButton() {
    var button = new Button("Show Result");
    button.setLayoutX(1100);
    button.setLayoutY(400);
    button.setFocusTraversable(true);
    button.setOnAction(e -> {
      ans.setText("Result = " + controller.getMainTreeNode().getTree().getResult());
      setPseudoCodeString(controller.getMainTreeNode().getTree().pseudoCodeString());
    });
    return button;
  }

  // Operations

  private @NotNull Button addButton() {
    var button = new Button("Add");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new AddTree(new ScrabbleInt(0), new ScrabbleInt(0));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button subtractButton() {
    var button = new Button("Subtract");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new SubtractTree(new ScrabbleInt(0), new ScrabbleInt(0));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button multiplyButton() {
    var button = new Button("Multiply");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new MultiplyTree(new ScrabbleInt(1), new ScrabbleInt(1));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button divideButton() {
    var button = new Button("Divide");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new DivideTree(new ScrabbleInt(1), new ScrabbleInt(1));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button andButton() {
    var button = new Button("Logical Conjunction");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new AndTree(new ScrabbleBool(true), new ScrabbleBool(true));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button orButton() {
    var button = new Button("Logical Disjunction");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new OrTree(new ScrabbleBool(true), new ScrabbleBool(true));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button negateButton() {
    var button = new Button("Negate");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new NegateTree(new ScrabbleInt(0));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  // Transformations

  private @NotNull Button toStringButton() {
    var button = new Button("To String");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ToStringTree(new ScrabbleInt(0));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button toIntButton() {
    var button = new Button("To Int");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ToIntTree(new ScrabbleInt(0));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button toFloatButton() {
    var button = new Button("To Float");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ToFloatTree(new ScrabbleInt(0));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button toBoolButton() {
    var button = new Button("To Boolean");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ToBoolTree(new ScrabbleBool(true));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button toBinaryButton() {
    var button = new Button("To Binary");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ToBinaryTree(new ScrabbleInt(0));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  // Values

  private @NotNull Button stringButton() {
    var button = new Button("String");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ScrabbleString(valueField.getText());
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button intButton() {
    var button = new Button("Int");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ScrabbleInt(Integer.parseInt(valueField.getText()));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button floatButton() {
    var button = new Button("Float");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ScrabbleFloat(Double.parseDouble(valueField.getText()));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button boolButton() {
    var button = new Button("Boolean");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ScrabbleBool(Boolean.parseBoolean(valueField.getText()));
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private @NotNull Button binaryButton() {
    var button = new Button("Binary");
    button.setFocusTraversable(false);
    button.setOnAction(e -> {
      Component newNode = new ScrabbleBinary(valueField.getText());
      Component tree = controller.getMainTreeNode().getTree();
      if (tree == null) {
        controller.getMainTreeNode().setTree(newNode);
      }
      window.setScene(mainScene);
    });
    return button;
  }

  private static void playVaporWave() {
    String audioFilePath = RESOURCE_PATH + "macintosh.wav";
    try {
      var sound = AudioSystem.getClip();
      try (var audioInputStream = AudioSystem.getAudioInputStream(
              new File(audioFilePath))) {
        sound.open(audioInputStream);
        FloatControl gainControl =
                (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
        sound.start();
      }
    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }
  }



}