# Databricks & AWS data lake impl:

* S3
* AWS Glue
* Kinesis
* Aurora
* Sage Maker
* Athena
* Redshift
* Quicksight

## Delta Lake

* https://delta.io/

## Flow

* 1) Create cluster
* 2) Check for runtime
  ```python
  printf(f"MLFlow   : {mlflow.__version__}") // 1.24.0
  printf(f"Pyspark  : {pyspark.__version__}") // 3.2.1
  ```

## Koalas

Commonly used by datascientists...

```
import databricks.koalas as ks
kdf = data.to_koalas()
```  
