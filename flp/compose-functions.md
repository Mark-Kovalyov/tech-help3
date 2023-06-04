# Compose functions

## In Haskell

```haskell
f x = x + 1
g x = x * 3
h1 = (f . g)
h2 = (g . f)
```

## In Scala

```scala
val f = (x:Int) => x + 1
val g = (x:Int) => x * 2

val h1 = f compose g  // == f(g(x))
val h2 = g compose f

val h3 = f andThen g  // == g(f(x))
val h2 = g andThen f
```
