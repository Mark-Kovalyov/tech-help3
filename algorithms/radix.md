# Convert to-, from- Radix

```scala
@tailrec
def toRadix(i : Int, radix : Int = 10, result : String = "") : String = {
  if (i > radix)
    toRadix(i / radix, radix, result + i % radix)
  else
    (if (i % radix == 0) result + "01" else result + i % radix).reverse
}
```
