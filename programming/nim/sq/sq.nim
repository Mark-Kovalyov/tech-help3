import std/strformat
import os
import strutils
import std/options

let a = 3.0
let b = 2.0
let c = 13.0

let d = b * b - 4.0 * a * c

Pair = tuple[x1: double, x2: double]

proc sq_roots(a: double, b: double, c: double): Option[Pair] =
  if d < 0.0:
    echo "Complex roots!"
    return none(Pair)
  else:
    let x1 = (-b - sqr(d)) / 2.0 * a
    let x2 = (-b + sqr(d)) / 2.0 * a
    echo fmt"x1 = {x1}"
    echo fmt"x2 = {x2}"
    return some(Pair(x1,x2))

sq_roots(a,b,c)










       
