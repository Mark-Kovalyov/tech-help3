# Generics in Rust/Haskell/Nim/Zig/Cargo

# Minimal of generic objects

# Mmax function with generic ariphmetic type

## C++
```cpp
template<typename T> T mmax(T x, T y) {
  return x > y ? x : y;
}
```

## Zig
```
const std = @import("std");

fn mmax(x : anytype, y : anytype) anytype {

}
```

## Nim
```nim
proc mmax[T](x,y:T) : T = if x > y : x else: y
```
```
mmin(1,2) = 1
mmin(3.1,3.2) = 3.1
mmin('a','b') = a
```

## Rust
```rust
fn mmax<T>(x: T, y: T) {
   if x > y {
     return x
   } else {
     return y
   }
}
```scala

## Scala
```
import math.Ordering

def mmax[T](x:T,y:T)(implicit ord:Ordering[T]) : T = if (ord.gt(x,y)) x else y
```
(what is Ordering trait?)
```

```
