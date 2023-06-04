# Currying

```
def sum(f : Int => Int)(a:Int, b:Int) : Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)
```

## Expansion of Multiple Parameters Lists:

By repeating the process N times:
```
def f(args1)...(args(n-1))(args(n)) = E
```

```
def f(args1 => (args2 = > ...... (argsn => E)...))
```
This style of definition and function application is
called currying, named for its instigator Haskell Brooks
Curry (1900-1982).

In fact, the idea goes back even futhrer to Shonfinkel and Frege
but the term "currying" has stuck.
