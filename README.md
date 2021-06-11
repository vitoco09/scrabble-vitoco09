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

This program is intended to be a clone of *Scratch*, which is an ambient of block programming. This kind of programs facilitates the creation of programs to users that don't know programming languages at all.

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
- **ScrabbleBinary** a *Java String* made of only ones (1) and zeros (0). It can be a two's component binary representing a *Java signed int* or a binary following the Double (IEEE754 Double precision 64-bit) notation representing a *Java double*

From now these types are going to be called *Scrabble* types for differenciating between *Java* types.

## **Functionalities**

It's necessary to implement methods for transforming *Scrabble* types to *Java* and other *Scrabble* types. On the other hand it's also needed to implement operations between *Scrabble* types because the idea is to be able to operate these types as much as the native ones if possible.

### 1. **Transformations**
Below is a table detailing the possible transformations for *Scrabble* types. The first column indicates the type of input and the first row the type of output.

|        | **ScrabbleString** | **ScrabbleBool** | **ScrabbleFloat** | **ScrabbleInt** | **ScrabbleBinary** |
| --- | :---: | :---: | :---: | :---: | :---: | 
| **ScrabbleString** | Yes | No | No | No | No |
| **ScrabbleBool** | Yes | Yes | No | No | No |
| **ScrabbleFloat** | Yes | No | Yes | No | No |
| **ScrabbleInt** | Yes | No | Yes | Yes | Yes |
| **ScrabbleBinary** | Yes | No | Yes | Yes | Yes |

### 2. **Operations**
Below is a table detailing the possible operations for *Scrabble* types. The first column indicates the left operand and the first row indicates the right operand.


|        | **ScrabbleString** | **ScrabbleBool** | **ScrabbleFloat** | **ScrabbleInt** | **ScrabbleBinary** |
| --- | :---: | :---: | :---: | :---: | :---: | 
| **ScrabbleString** | + | + | + | + | + |
| **ScrabbleBool** |  | ∧, ∨ |  |  | ∧, ∨ |
| **ScrabbleFloat** |  |  | +, -, x, ÷ | +, -, x, ÷ | +, -, x, ÷ |
| **ScrabbleInt** |  |  | +, -, x, ÷ | +, -, x, ÷ | +, -, x, ÷ |
| **ScrabbleBinary** |  | ∧, ∨ | ***+, -, x, ÷*** | +, -, x, ÷ | +, -, x, ÷ |

The first detail is that a **ScrabbleString** operated with any *Scrabble* type is defined as the concatenation of the string values of these objects.

It's important to mention that the output type is preffered to be the type of the left operand in most of cases. However, in cases like **ScrabbleInt** plus **ScrabbleFloat** is not possible to return an **Scrabbleint** because of the decimal part of the *Java double* stored in **ScrabbleFloat**.

Another exception is when a **ScrabbleBool** is operated with a **ScrabbleBinary**. The logical operations in binaries are assumed to be applied bit to bit, which means that a **ScrabbleBool** must be treated as a binary full of ones (if true) or zeros (if false) when being operated with another binary. This process returns a **ScrabbleBinary** since it's impossible to save that amount of information on a boolean.

The **ScrabbleBinary** to **ScrabbleFloat** operation was accidentally implemented, but since it complements the other operations it was decided to leave it there. Is's implementation uses the Double (IEEE754 Double precision 64-bit) notation for the binaries, making these special binaries different from the ones used for representing a *signed int* (two's component), which is something that must be avoided when trying to operate two binaries.

## **Class Hierarchy**
