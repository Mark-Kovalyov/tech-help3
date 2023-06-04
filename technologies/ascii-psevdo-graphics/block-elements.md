# Unicode block elements

## Quadrants
```scala
val Q00 = 0x2596 // ▖	Quadrant lower left
val Q01 = 0x2597 // ▗	Quadrant lower right
val Q02 = 0x2598 // ▘	Quadrant upper left
val Q03 = 0x2599 // ▙	Quadrant upper left and lower left and lower right
val Q04 = 0x259A // ▚	Quadrant upper left and lower right
val Q05 = 0x259B // ▛	Quadrant upper left and upper right and lower left
val Q06 = 0x259C // ▜	Quadrant upper left and upper right and lower right
val Q07 = 0x259D // ▝	Quadrant upper right
val Q08 = 0x259E // ▞	Quadrant upper right and lower left
val Q09 = 0x259F // ▟	Quadrant upper right and lower left and lower right
```

## Half blocks
```scala
val UHB = 0x2580 // ▀ Upper half block
val LHB = 0x2584 // ▄ Lower half block
```

## Shade blocks
```scala
val SP = 0x0020 //    Space        (0% filling)
val LS = 0x2591 // ░	Light shade  (1/8 = 12.5%  filling)
val MS = 0x2592 // ▒	Medium shade (1/3 = 33 % filling)
val DS = 0x2593 // ▓	Dark shade   (3/4 = 75% filling)
val FB = 0x2588 // █	Full block  (100% filling)
```

## Combinations of shade blocks + colors
