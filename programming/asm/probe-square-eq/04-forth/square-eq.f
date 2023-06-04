\ fdrop
\ fnip
\ fdup
\ fover
\ fthird ( r1 r2 r3 – r1 r2 r3 r1 ) 

: fdiscr ( a b c -- sqrt_d ) 
  fdup
  f*
  frot frot
  4e
  f* f* 
  fsqrt ; 

: fsolve (a b c -- x1 x2)
  
  ;