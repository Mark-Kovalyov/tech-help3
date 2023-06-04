# Quine + Quine-McCluskey

## СДНФ (PDNF - perfect disjunctive normal form)

```
F(a,b,c) = !abc + a!b!c + ab!c
```

## СКНФ (PCNF - perfect conjunctive normal form)

```
F(a,b,c) = (a + !b + !c) * (!a + !b + !c)
```

## Absorption ?

```
x AND (x OR y) = x
x OR (x AND y) = x
```

## Material conditional (implication)
|x|y|x->y|
|-|-|----|
|0|0|1
|0|1|0
|1|0|1
|1|1|1

## Annihilator

```
x OR 1 = 1
```

## Склеивание

## Поглощение

## Импликанты

## Quine method

## Quine-McCluskey

### 1. Find main implicants

### 2. Generate trivial implicants table
