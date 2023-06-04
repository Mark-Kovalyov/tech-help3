# Scala Typeclass


```scala
def sort[A](list: List[A])(implicit ord: Ordering[A]): List[A] = {
  list.sorted(ord)
}
```

