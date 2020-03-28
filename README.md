# Lab 9: A programming language

In this lab, we will finally be able to create a complete programming language with its own syntax and runtime environment.

## Built on Lab 8

You need to complete **Lab 8** as you will need the Java backend to support the various programming constructs
of this programming langauge.

## Syntax

The programming language has the following syntax:

### Numbers, Variables and Arithemtics, 

We only support numbers, so we can have literals in the form of `3.1415`, `16`, or `-1.23`.
Variables can be created by assignment expressions:

```
(pi = 3.1415)
```

Then, they can be used.
```
pi * 10 * 10
```

We can perform arithmetics using prefix notation:

```
(/ (* pi (* (+ r 20) (- r 20))) 2)
```

This is the expression corresponding to: `(pi * ((r + 20) * (r - 20)) / 2)`

### Code Block

A code block is a sequence of expressions that **share** a common context.

```
{
  (i = 10)
  (j = 20)
  (+ i j)
}
```

This should evaluate to **30**, as the code block evaluates to the last expression in the block.

### Condition and Branching

We support conditions such as follows:

```
(< 1 2)
(<= 1 2)
(> 10 10)
(and (< 1 2) (> 2 1))
```

Conditions allow us to expression branching expressions:

```
(if (< r 10) 100 else 200
```

This expression is that if `r` is less than 10, then it should be 100, otherwise 200.
