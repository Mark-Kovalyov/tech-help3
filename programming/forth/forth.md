# Forth

## Principles

* Keep it simple
* Do not speculate
* Do it yourself motherfucker

## Compillers

* BigForth
  * https://bigforth.sourceforge.net/
* Gforth 
  * https://gforth.org/
  * https://github.com/forthy42/gforth
* YForth
  * https://manpages.ubuntu.com/manpages/kinetic/man1/yforth.1.html
* VFX Forth
  * https://vfxforth.com/pricing
* Android Forth
  * https://sourceforge.net/projects/androidforth/
* SwiftForth
  * https://www.forth.com/swiftforth/#Complete_source_code
  * SwiftForth brings the fast, powerful, ANS Forth programming language to Windows, Linux, and macOS

## Other compilers with Forth
* cc64 : cc64 is a small-C compiler, written in Forth (here's why), targeting the 
  6502 CPU. It's hosted on the Commodore C64, on the C16 with 64k RAM and the 
  Plus4, and on the new Commander X16, and runtime targets are also available 
  for all 3 platforms, on each host, allowing cross-compilation.
  * https://github.com/pzembrod/cc64

## Games on Forth
  * Oscal Toledo-s site:
    * https://github.com/nanochess
  * GameBoy Forth http://gbforth.org/examples.html
  * A Forth-based Game Boy development kit 
    * https://github.com/ams-hackers/gbforth
  * Star Flight : The team coded the game mostly in Forth (unusual language, 
    even for its time) with a few key routines written in x86 assembler. Forth was 
    chosen since it is easier to use than assembler and more compact. 
    This was important because the game had to fit into 128 KB of RAM.
    * https://github.com/s-macke/starflight-reverse
    * Where to get binary?

## Forth and Hardware
  * ESP8266
    * https://www.youtube.com/watch?v=WrTm5QlWnaE
  * Forth on FPGA https://github.com/jamesbowman/j1
  * Forthright : This is a port of Jones Forth to the ESP-8266 microcontroller : 
    * https://github.com/niclash/forthright
  * STM32F103c86t6 ARM STM32 System dev board for arduino 
    * Aliexpress: $1.78
    * 
  * Microchip 8-bit PIC18F and 16-bit PIC24, 30, 33 and the Atmel Atmega
    * https://www.flashforth.com/

## Forums
  * About ASM and little bit Forth : https://wasm.in/
  * http://www.forth.org.ru/
  * FForum - http://www.fforum.winglion.ru/index.php

## Others
  * Some scala-forth https://exercism.org/tracks/scala/exercises/forth
  * Standard : https://forth-standard.org/
  * A Brief Introduction to Forth Programming http://www.mosaic-industries.com/embedded-systems/sbc-single-board-computers/freescale-hcs12-9s12-c-language/instrument-control/microcontroller-forth-language

```
$ sudo apt install gforth
...
$ gforth -v
gforth 0.7.3
```

## See words
```
words
```
see word definition
```
see hello
```



## Include dependency

```
s" file.fs" included
```

## Run code and tests
```
gforth code.fs tests.fs -e bye
```

## Integer and Fixed point

* Fixed-point arithmetic
  * arithmetic which deals with numbers which do not themselves indicate 
    the location of decimal points. Instead, for any group of numbers, 
    the program assumes the location of the decimal point or keeps the decimal location for all such numbers as a separate number.

|Word|Effect|
|----|------|
|1+  |
|2-  |
|2*  |Multiply two
|2/  |Div two
|ABS |absolute val
|NEGATE|change sign
|MIN|(n1 n2 -- n3)
|MAX|(n1 n2 -- n3)
|>R   |?
|R>   |?               
|R@   |?
|*/   |
|*/MOD|

start-slash operator (n1 n2 n3 -- n1*n2/n3)
```
3 4 6 ok
*/ ok
. 2 ok
```
multiply-divide-and-mod (n1 n2 n3 -- (n1*n2/n3) (n1*n2%n3)
```
*/MOD
``` 


## Floating point operations

```
f* multiply
f/ div
f+ plus
f- minus 
```




## Stack operations

|Integer op|Floating point op|Effect                        |Possible low level call |
|----------|-----------------|------------------------------|------------------------|
|DUP       |FDUP             |a b -- a b b                  |0 PEEK                  |
|DROP      |FDROP            |a b c -- a b                  |                        |
|SWAP      |FSWAP            |a b c -- a c b                |1 ROLL                  |
|ROT       |FROT             |a b c -- b c a                |2 ROLL                  |
|OVER      |FOVER            |a b c -- a b c b              |1 PEEK                  |
|NIP       |FNIP ?           |a b c -- a c                  |                        |
|TUCK      |FTUCK ?          |a b c -- a c b c              |                        |
|    ?     |FTHIRD ?         |Undefined word ,                                       |
|    ?     |FFOURTH ?        |Undefined word                                         |
|PICK      |FPICK ?          |Stack underflow ( f:... u – f:... r )                  |
|    ?     |F-ROT ?          |Undefined word                                         |




                              

## Twins stack operations


2DUP 

## Constants

```
60 constant SEC_IN_MIN
1000 constant MS_IN_SEC

\ 1000 * (60 * (60 * h + m) + s)

: past ( h m s -- ms ) rot 60 * rot + 60 * + 1000 * ;

: past2 ( h m s -- ms ) rot SEC_IN_MIN * rot + SEC_IN_MIN * + MS_IN_SEC * ;



```


## Conditions
```
: abs ( a -- moda ) dup 0 < if negate endif ;
```
```
: xmin ( n n -- n ) 2dup < if drop else nip endif ;
: xmax ( n n -- n ) 2dup >= if drop else nip endif ;
```

## Loops

Syntax:
```
FORMULA: limit index DO ... LOOP
```

```
: RECTANGLE  
   256 0 
   DO 
     I 16 MOD 0= IF CR THEN ." *" 
   LOOP ;

: MONTHS 12 1 DO I . LOOP ;


```
## Indefinite Loops

```
BEGIN ... UNTIL
```

## Emacs and Gforth

```
https://gforth.org/manual/Emacs-and-Gforth.html
```

## Variables

```
variable zen  ok
10  ok
.s <1> 10  ok
zen  ok
.s <2> 10 140079006446856  ok
!  ok
.s <0>  ok
zen ? 10  ok
```
add value to zen-variable
```
4 ok
+!
zen ? 14 ok
```
## Constants

```
256 constant maxbyte
```


