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
(if (< r 10) 
  100
  200)
```

This expression is that if `r` is less than 10, then it should be 100, otherwise 200.

Since code blocks are expressions, they can be used freely as part of the if-else construct:

```
(if (< r 10) {
  (pi = 3.1415)
  (* pi (* r r))
} {
  200
})
```

### While Loop

Here is an example of the while-loop:

```
{
  (i = 0)
  (sum = 0)
  (while (< i 10) {
    (sum = (+ sum i))
    (i = (+ i 1))
  })
}
```

It computes the sum of `0 + 1 + 2 + ... + 9`.

### Function Declaration and Invocation

Here is an example how functions can be declared and used.

```
{
  (def add [i j] (+ i j))
  (def double [i] (* 2 i))
  
  (add (double 10) (double 20))
}
```

Again, complex functions might use blocks as the body.  Here is a program that computes
the square root using the [Babylonian method](https://blogs.sas.com/content/iml/2016/05/16/babylonian-square-roots.html).

```
{
  (epsilon = 0.001)

  (def abs [x] (if (< x 0) (- 0 x) x))

  (def avg [x y] (/ (+ x y) 2))

  (def sqrt [x] {
    (y = x)
    (y2 = (* y y))
    (while (> (abs (- x y2)) epsilon) {
        (y = (avg y (/ x y)))
        (y2 = (* y y))
    })
    y
  })
  
  ...
}
```

Note that while `abs` and `avg` are simple functions, `sqrt` uses a code block as its body as it requires
multiple expressions.

# Your Tasks

1. Complete the classes required in Lab 8.

  > The templates found in `src/numlang/*.java` as _unimplemented_.  You should copy the full implementation
  from **Lab 8** to `src/numlang/`.
  
2. Author a grammar as illustrated above.  Note your grammar *must* accept all 9 sample programs given.

  > You need to complete `src/ProgLang.g4`.
  
3. Modify the grammar with SDD _attributes_ and _actions_ so that the parser will
evaluate the expressions.  At the top level, the _program_ target should also print the expression
as a string, and its evaluated result.

3. Make sure you can pass all the tests.

  > `make check` will perform verification against all test cases.  The test programs are provided
  in `tests/*.proglang`.

# Helpers

The Makefile given comes with helper facilities:

- `make check` checks against **all** test cases.  You may want to run individual test cases as you tackle
with the grammar.

- `make run file=tests/1.proglang` will run only the file specified by `file=...`.

- `make debug file=tests/1.proglang` will run the file specified, and it will print out the parse tree so you can
examine how the parser interpretes the program.
