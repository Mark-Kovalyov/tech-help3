# Bloom filters

```

```sql
create or replace table emp_bloom(
  empid BIGINT NOT NULL
  ....
)
```

## Create index before adding data
```sql
create bloomfilter index on table emp_bloom
for columns(empid OPTIONS (fpp=0.1, numItems = 2000000))
```
