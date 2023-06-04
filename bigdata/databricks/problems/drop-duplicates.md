# Databricks and deduplication problem

## Dataframe::distinct

```scala
df.distinct()
```

## Dataframe::dropDuplicates
```
val newdf = df.dropDuplicates(Array("EMPNAME", "MANAGER"))
val newdf2 = newdf.dropDuplicates()

```
