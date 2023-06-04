# NIM

* Created by Andreas RUMPF in 2005
* features
  * C - performance
  * Python - productivity
  * Lisp - extensibility
* Flexible memory management
  * ORC
  * ARC
  * RefC
  * Mark & Sweep
  * Boehm (STW)
  * Go (STW)
  * None (Manual STW)
* Macros on AST
* Indentation matter
* Iterators
* Main func in not nessasary
* procedures == functions
* closures, first class Functions
* OOP
* Generics (Types as params)

(STW - Stop the world)

## Metaprogramming

```
macro timesTwo(statements: untyped): untyped =
  result = statements
  for s in statements:
    for node in s:
      if node.kind == nnkIntLit:
        node.intVal = node.intVal * 2

timesTwo:
  echo 1
  echo 2
```

## OOP
```
type
  Student = object
    name: string
    age: int

var j = Student(name:"Fred")
```

## Generic
```
type
  Cyborg*[T] = object
    invicible: bool
    dna: T

var cyberJeff = Cyborg(dna: jeff)
```

## Dump AST
```
import std/macros

dumpTree:
  var cyberFred = Cyborg[Student]
```



## Versions


Q: Nim Compiler Version 1.0.6 [Linux: amd64] Compiled at 2020-02-27

```
apt remove num

curl https://nim-lang.org/choosenim/init.sh -sSf | sh

   Switched to Nim 1.6.12
choosenim-init: ChooseNim installed in $HOME/.nimble/bin
choosenim-init: You must now ensure that the Nimble bin dir is in your PATH.
choosenim-init: Place the following line in the ~/.profile or ~/.bashrc file.
choosenim-init:     export PATH=$HOME/.nimble/bin:$PATH
```


## Links

* https://nim-lang.org/
* https://github.com/ringabout/awesome-nim

* Effient
* Expressive
* Elegant

## What

* Types
  * Object type
  * Tuple
* Functions

## Paradigms

* all

##


## Ref/Value types

## GC

## Static binding

1) Если компиллятор не может понять код то его не может понять и программист
2) Переносим работу в compile-time по максимуму
3) Кастомизируемое управление памятью
4) Метапрограммирование
5) Должен быть только один язык програмирования

## На язык оказали влияние

* Object Pascal
* Datatypes from ADA
* Modules from Oberon
* Modula-3
