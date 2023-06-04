# Compillators

## Этапы

* Source code
* Fromntend
  * Processing + AST gen
* Optimization
* Backend
  * Machine code generation
* Code

## Clang

Clang is a frontend for LLVM

## frontend

### Лексический анализ

```
Lexer:
>> (3 + 4.1) * a
["(", "3", "+", "4.1", ")" , "*", "a"]
```
(Lex, Flex, JLex)


### Синтаксический

Yacc, Bison, JavaCC

### LLVM

Low Level Virtual Machine - compiler infrastructure

* Набор модулей и инструментов для разработки компилляторов
* В основе - промежуточное представление IR кода - типизированній трехадресный код в SSA - форме
* Реализует VM с RISC-подобными инструкциями и бесконечным количеством регистров
* Есть API для frontend на С++/OCaml


