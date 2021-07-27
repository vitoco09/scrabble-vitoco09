# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

This program is intended to be a clone of *Scratch*, which is a block programming environment. This kind of programs facilitates the creation of programs to users that don't know programming languages at all.

Below is detailed the implementation of this program. This is still a work in progress, so it is subject to periodic changes.

# **Data Types**
This program implements new types other than *Java* types. The main idea is to store these *Java* types inside this new types for then making it easier to create and operate them in specific ways.

For this program there are three basic types:

- **String**: Object containing a native *Java String*.
- **Boolean**: Object containing a native *Java Boolean* (***true*** or ***false***). 
- **Number**: Object containing a native Java numeral (*int*, *double*, or a binary stored as a *String*)

With this in mind, the program implements five Java classes with the following types of values stored.

- **ScrabbleString**: a *Java String*
- **ScrabbleBool**: a *Java boolean*
- **ScrabbleFloat**: a *Java double*
- **ScrabbleInt**: a *Java int*
- **ScrabbleBinary** a *Java String* made of only ones (1) and zeros (0). It can be a two's component binary representing a *Java signed int*, or a binary following the Double (IEEE754 Double precision 64-bit) notation representing a *Java double*

From now these types are going to be called *Scrabble* types for differentiating between *Java* types.

## **Functionalities**

It's necessary to implement methods for transforming *Scrabble* types to *Java* and other *Scrabble* types. On the other hand it's also needed to implement operations between *Scrabble* types because the idea is to be able to operate these types as much as the native ones if possible.

### 1. **Transformations**
Below is a table detailing the possible transformations for *Scrabble* types. The first column indicates the type of input, and the first row the type of output.

|        | **ScrabbleString** | **ScrabbleBool** | **ScrabbleFloat** | **ScrabbleInt** | **ScrabbleBinary** |
| --- | :---: | :---: | :---: | :---: | :---: | 
| **ScrabbleString** | Yes | No | No | No | No |
| **ScrabbleBool** | Yes | Yes | No | No | No |
| **ScrabbleFloat** | Yes | No | Yes | No | No |
| **ScrabbleInt** | Yes | No | Yes | Yes | Yes |
| **ScrabbleBinary** | Yes | No | Yes | Yes | Yes |

### 2. **Operations**
Below is a table detailing the possible operations for *Scrabble* types. The first column indicates the left operand, and the first row indicates the right operand.


|        | **ScrabbleString** | **ScrabbleBool** | **ScrabbleFloat** | **ScrabbleInt** | **ScrabbleBinary** |
| --- | :---: | :---: | :---: | :---: | :---: | 
| **ScrabbleString** | + | + | + | + | + |
| **ScrabbleBool** |  | ∧, ∨ |  |  | ∧, ∨ |
| **ScrabbleFloat** |  |  | +, -, x, ÷ | +, -, x, ÷ | +, -, x, ÷ |
| **ScrabbleInt** |  |  | +, -, x, ÷ | +, -, x, ÷ | +, -, x, ÷ |
| **ScrabbleBinary** |  | ∧, ∨ | ***+, -, x, ÷*** | +, -, x, ÷ | +, -, x, ÷ |

The first detail is that a **ScrabbleString** operated with any *Scrabble* type is defined as the concatenation of the string values of these objects.

It's important to mention that the output type is preferred to be the type of the left operand in most of the cases. However, in cases like **ScrabbleInt** plus **ScrabbleFloat** is not possible to return an **ScrabbleInt** because of the decimal part of the *Java double* stored in **ScrabbleFloat**.

Another exception is when a **ScrabbleBool** is operated with a **ScrabbleBinary**. The logical operations in binaries are assumed to be applied bit to bit, which means that a **ScrabbleBool** must be treated as a binary full of ones (if true) or zeros (if false) when being operated with another binary. This process returns a **ScrabbleBinary** since it's impossible to save that amount of information in a boolean.

The **ScrabbleBinary** to **ScrabbleFloat** operation was accidentally implemented, but since it complements the other operations it was decided to leave it there. Its implementation uses the Double (IEEE754 Double precision 64-bit) notation for the binaries, making these special binaries different from the ones used for representing a *signed int* (two's component), which is something that must be avoided when trying to operate two binaries.

### 3. **Abstract Syntax Tree for complex operations**

An **Abstract Syntax Tree** (AST) is a program representation using a tree where every instruction is a node inside the tree. The principal reason for using this type of tree is because it's easy to make an inorder traversal for arithmetic operations.

With this in mind, the tree is implemented via a Composite design as follows.

- **Component**: Corresponds to the "composite" object. Any class that implements this interface will be able to be used as a node of a tree. An important detail is that this interface implements a method that can get the result of a full operation inside an AST. This interface is implemented by **AbstractTypeTree** (as a tree) and extended by **IType** (as a leaf)
- **AbstractTypeTree**: Abstract class that implements the base for a working AST. This class immediately stores the result of its operation for an easy return. This abstract class is extended by all the specific operation and transformation trees.

The operation trees are listed below.

- **AddTree**: Class that implements a binary tree with the sum operation in the parent node.
- **SubtractTree**: Class that implements a binary tree with the subtraction operation in the parent node.
- **MultiplyTree**: Class that implements a binary tree with the multiplication operation in the parent node.
- **DivideTree**: Class that implements a binary tree with the division operation in the parent node.

- **AndTree**: Class that implements a binary tree with the logical conjunction operation in the parent node.
- **OrTree**: Class that implements a binary tree with the logical disjunction operation in the parent node.

- **NegateTree**: Class that implements a unary tree with the numeral negation or logical conjugation operation in the parent node.

Finally, the transformation trees are implemented as follows.

- **ToStringTree**: Class that implements a unary tree with the type-to-string transformation in the parent node.
- **ToIntTree**: Class that implements a unary tree with the num-to-int transformation in the parent node.
- **ToFloatTree**: Class that implements a unary tree with the num-to-float transformation in the parent node.
- **ToBoolTree**: Class that implements a unary tree with the bool-to-bool transformation in the parent node. Despite it's redundancy, it's added for aesthetic reasons
- **ToBinaryTree**: Class that implements a unary tree with the num-to-binary transformation in the parent node.

This implementation allows a quite simple writing for creating an AST. An example of an AST is shown in the code below.

```java
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
```

The result of this tree is -143.

### 4. **Memory optimizations**

Since invoking Scrabble Types can be quite memory dependant, it's recommendable to implement a way to save memory. This program also implements a Flyweight design, which can reduce the memory allocation by a wide amount.

It's implemented via an abstract class with a static map, where every new Scrabble Type created is saved inside with different keys, and if it was already created it's just returned from inside. This specific behaviour is the responsible for all the memory savings.

The class hierarchy is listed below.

- **AbstractTypeFactory**: Abstract class that implements the static map.
- **ScrabbleStringFactory**: Class that extends from the abstract class, which can create ScrabbleString objects or reuse the already existing ones.
- **ScrabbleIntFactory**: Class that extends from the abstract class, which can create ScrabbleInt objects or reuse the already existing ones.
- **ScrabbleFloatFactory**: Class that extends from the abstract class, which can create ScrabbleFloat objects or reuse the already existing ones.
- **ScrabbleBoolFactory**: Class that extends from the abstract class, which can create ScrabbleBool objects or reuse the already existing ones.
- **ScrabbleBinaryFactory**: Class that extends from the abstract class, which can create ScrabbleBinary objects or reuse the already existing ones.

The usage of these classes reside in a static method called ```getScrabbleType(NativeType value)```, which emulates the process of creating or reusing the Scrabble Types and replaces the usual ```new ScrabbleType(value)```.

The negation operation was implemented to every *Scrabble* type. For all **ScrabbleNumber** the negation is the additive inverse of the number and for all **ScrabbleBool** the negation is simply the logical negation (!true = false, !false = true).  For **ScrabbleString** it makes no sense to negate a string, so by default the negation returns a clone of the **ScrabbleString**.

### Class Hierarchy (UML)

![Class Hierarchy](https://github.com/CC3002-Metodologias/scrabble-vitoco09/blob/main/UMLtarea2.png)

### Graphical Interface

This program also includes a graphical interface for making it easier to create operation trees of Scrabble Types. For inspirational purposes it's included with a background and music.

The main scene shows some buttons for selecting between operations, transformations and types, elements which are added to an operation tree according to the selected node in screen. There's also a clean button, which can return the tree to its original state as a null, and a pseudo-code button for showing a pseudo-code illustration of the tree.

This graphics interface is powered by JavaFX using IntelliJ. The model is stored inside `type` and `operationTree` folders, while its view and controller are stored inside `gui` and `controller` folders.

The program starts with an empty tree, which can be filled with new nodes. There's also the possibility of returning a sole value by setting a type as the main tree instead of an operation or a transformation, but then the program becomes unable to add more nodes because a scrabble type cannot have sons.

## Launch Instructions

Make sure to have IntelliJ installed in your system before attempting to launch this program.

1.- Import to your system the program, one way of doing this is by writing `git clone https://github.com/CC3002-Metodologias/scrabble-vitoco09` in a command line (CMD or Powershell for Windows). If this doesn't work check if you have installed git in your system.
2.- Open IntelliJ and go to file -> open... and select `scrabble-vitoco09`.
3.- Inside the project go inside src -> main -> java -> cl.uchile.dcc.scrabble -> gui, this is where the application is stored.
4.- Right click Scrabble.java and click in `Run ('Scrabble.main()')` or altenatively select Scrabble.java and do Ctrl+Mayus+F10

With these steps you should be already running the application with no problems.
