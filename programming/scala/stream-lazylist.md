# Scala :: Stream, List, LazyList, Sequence, operations, Converters

## Collection lineage in Scala

|Scala|Stream|List|LazyList
|-|-|-|-|
|2.12.5|OK|OK|-|
|3.1.2|Deprecated since 2.13.0|OK|OK|


(Since version 2.13.0) Use LazyList (which is fully lazy) instead of Stream (which has a lazy tail only)


## Operations

|Collection|Concatenate|Nil|
|-|:-:|-|
|Stream|?|?|
|List|::|Nil|
|LazyList|::#|LazyList.empty|

## Converters

Replace deprecated
```
import collection.JavaConverters.iterableAsScalaIterableConverter
import scala.collection.JavaConverters._
....
```

With
```
import scala.jdk.CollectionConverters._
import scala.jdk.StreamConverters._
```

### Java Stream => Scala LazyList
```
val ahref : Elements = element.select("a[href]")
val ahrefScalaSeq : Seq[Element] = ahref.stream().toScala(LazyList)
```
