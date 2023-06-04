# Currying

## In Haskell

```haskell
f :: a -> (b -> c)     -- ==  f :: a -> b -> c
```

## In Scala

```scala
def strcat(s1: String)(s2: String) = s1 + s2
```
