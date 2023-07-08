# Vacuum and Optimize


## Vacuum
```
VACUUM table_name [RETAIN num HOURS] [DRY RUN]
```

## Optimize
```
OPTIMIZE table_name [WHERE predicate]  [ZORDER BY (col_name1 [, ...] ) ]
```

### Dataskipping

* DATASKIPPING INDEX was removed in Databricks Runtime
  7.0. We recommend that you use Delta tables instead,
  which offer improved data skipping capabilities.
