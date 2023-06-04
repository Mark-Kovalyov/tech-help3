# UDF-python SQL functions

* cant be optimized by Catalyst
* serialized to send to executors
* for python - additional interprocess overhead

## Python function
```pyhton
def first_let(email):
  return email[0]

first_let_udf = udf(first_let)

```

use in dataframe

```
from pyspark.sql.functions import col

display(emp.select(first_let_udf(col("email"))))
```

register to use in SQL

```
flu = spark.udf.register("flu", first_let_udf) 

%sql

SELECT flu(email) AS email FROM emp
```

## Another case with Decorator

```python
@udf("string")
def first_letter_udf(emai: str) -> str:
   return email[0]
```
## Pandas/Vectorized UDF

* Utilizes Apache Arrow

```python
@pandas_udf("string")
def vec_udf(email: pd.Series) -> pd.Seris:
  return email.str[0]


```



```