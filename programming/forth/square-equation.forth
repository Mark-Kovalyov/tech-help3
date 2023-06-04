: 3DUP
  DUP
  2OVER
  ROT ;

: 3FDUP
  FDUP
  2FOVER
  FROT ;

: SQUAR-EQ
  SWAP
  DUP
  *
  ROT ROT
  4
  * * ;

