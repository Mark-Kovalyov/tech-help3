# Psevdo graphics

```scala
// Lines and corners
val VERT  = 0x2502.toChar  // │
val HOR   = 0x2500.toChar  // ─
val CROSS = 0x253c.toChar  // ┼

val LT    = 0x250c.toChar  // ┌
val RT    = 0x2510.toChar  // ┐
val RB    = 0x2518.toChar  // ┘
val LB    = 0x2514.toChar  // └

val CB    = 0x2534.toChar  // ┴
val CT    = 0x252C.toChar  // ┬
val CL    = 0x251C.toChar  // ├
val CR    = 0x2524.toChar  // ┤

// Rounded corners
val RBR   = 0x256d.toChar // ╭
val LBR   = 0x256e.toChar // ╮
val LTR   = 0x256f.toChar // ╯
val RTR   = 0x2570.toChar // ╰
```

## With ortho-corners
```
┌──────┬────┐
│Cool  │Mode│
┝──────┼────┤
└──────┴────┘
```

## Sample with rounded corners
```
╭──────┬────╮
│Cool  │Mode│
┝──────┼────┤
╰──────┴────╯
```
