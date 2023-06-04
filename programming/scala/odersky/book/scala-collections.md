# Scala collections and Complexity

## Immutable Lists

|Collection | Head | Tail | Apply | Update| Prepend | Append | Insert |
|-----------|------|------|-------|-------|---------|--------|--------|
|List       |C|C|L|L|C|L|-
|LazyList   |C|C|L|L|C|L|-
|ArraySeq   |C|L|C|L|L|L|-
|Vector     |eC|eC|eC|eC|eC|eC|-
|Queue      |aC|aC|L|L|L|C|-
|Range      |C|C|C|-|-|-|-
|String     |C|L|C|L|L|L|-  

* C - constant
* eC - effectively constant
* aC - amortized constant
* L - linear
* Log - logarithm

### Effectively constant

???

### amortized constant

???



## Mutable List

|Collection   | Head | Tail | Apply | Update| Prepend | Append | Insert |
|-------------|------|------|-------|-------|---------|--------|--------|
|ArrayBuffer  |C|L|C|C|L|aC|L
|StringBuilder|C|L|C|C|L|aC|L
|ListBuffer   |C|L|L|L|C|C|L
|Queue        |C|L|L|L|C|C|L
|ArraySeq     |C|L|C|C|-|-|-
|Stack        |C|L|L|L|C|L|L
|Array        |C|L|C|C|-|-|-
|ArrayDeque   |C|L|C|C|aC|aC|L

## Immutable Maps/Sets

|Collection     |Lookup|Add|Remove|Min|
|---------------|------|---|------|---|
|HashSet/HashMap|eC    |eC |eC    |L
|TreeSet/TreeMap|Log   |Log|Log   |Log
|BitSet         |C     |L  |L     |eC
|VectorMap      |eC    |eC |aC    |L
|ListMap        |L     |L  |L     |L


## Mutable Maps/Sets

|Collection     |Lookup|Add|Remove|Min|
|---------------|------|---|------|---|
|HashSet/HashMap|eC    |eC |eC    |L
|TreeSet/TreeMap|eC    |eC |eC    |L
|BitSet         |C     |aC |C     |eC
