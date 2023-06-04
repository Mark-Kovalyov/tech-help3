# PySpark


## Dataframe with custom values
```
dept = [("Finance",  10), 
        ("Marketing",20), 
        ("Sales",    30), 
        ("IT",       40) 
      ]

deptColumns = ["dept_name","dept_id"]
deptDF = spark.createDataFrame(data=dept, schema = deptColumns)
deptDF.printSchema()
deptDF.show(truncate=False)
```

## With schema types

```
import pyspark
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType,StructField, StringType, IntegerType, LongType, DoubleType


schema = StructType([
  StructField("empno",      LongType()),
  StructField("ename",      StringType()),
  StructField("job",        StringType()),
  StructField("mgr",        LongType()),
  StructField("hiredate",   StringType()),
  StructField("sal",        DoubleType()),
  StructField("comm",       DoubleType()),
  StructField("deptno",     LongType())
])

val data = Seq(
  Row(7369,"SMITH","CLERK", 7902, "1980-12-17", 800.0, null, 20),
  Row(7499,"ALLEN","SALESMAN", 7698, "1981-02-20", 1600.0, 300.0, 30),
  Row(7521,"WARD","SALESMAN", 7698, "1981-02-22", 1250.0, 500.0, 30),
  Row(7566,"JONES","MANAGER", 7839, "1981-04-02", 2975.0, null, 20),
  Row(7654,"MARTIN","SALESMAN", 7698, "1981-09-28", 1250.0, 1400.0, 30),
  Row(7698,"BLAKE","MANAGER", 7839, "1981-05-01", 2850.0, null, 30),
  Row(7782,"CLARK","MANAGER", 7839, "1981-06-09", 2450.0, null, 10),
  Row(7788,"SCOTT","ANALYST", 7566, "1987-04-19", 3000.0, null, 20),
  Row(7839,"KING","PRESIDENT", null, "1981-11-17", 5000.0, null, 10),
  Row(7844,"TURNER","SALESMAN", 7698, "1981-09-08", 1500.0, 0.0, 30),
  Row(7876,"ADAMS","CLERK", 7788, "1987-05-23", 1100.0, null, 20),
  Row(7900,"JAMES","CLERK", 7698, "1981-12-03", 950.0, null, 30),
  Row(7902,"FORD","ANALYST", 7566, "1981-12-03", 3000.0, null, 20),
  Row(7934,"MILLER","CLERK", 7782, "1982-01-23", 1300.0, null, 10))

val rdd = spark.sparkContext.parallelize(data)

val df = spark.createDataFrame(rdd, schema)

df.show()

```

## Inner join

```
# importing module
import pyspark
  
from pyspark.sql import SparkSession
spark = SparkSession.builder.appName('sparkdf').getOrCreate()
  
data = [["1", "Tom",    "Oracle"], 
        ["2", "Larry",  "Oracle"],
        ["3", "Ravi",   "Sun"],
        ["4", "Kumar",  "Farmak"], 
        ["5", "Jenna",  "Sun"]]
  
columns = ['ID', 'NAME', 'Company']
  
dataframe = spark.createDataFrame(data, columns)
  
data1 = [["1", "45000",  "IT", 
         ["2", "145000", "Manager"], 
         ["6", "45000",  "HR"],
         ["5", "34000",  "Sales"]]
  
columns = ['ID', 'salary', 'department']
  
dataframe1 = spark.createDataFrame(data1, columns)

dataframe.join(dataframe1, dataframe.ID == dataframe1.ID, "inner").show()
```

## EmptyDataframe with schema

```python
from pyspark.sql import SparkSession
from pyspark.sql.types import *

rdd = spark.sparkContext.emptyRDD()

schema = StructType([
  StructField("name", StringType(), True),
  StructField("sal",  DecimalType(), True)
])
 
emptydata = spark.createDataFrame(rdd, schema)
 
emptydata.show()
 
emptydata.printSchema()

```

The same
```
data = spark.createDataFrame(
  spark.sparkContext.emptyRDD(), 
  StructType([
    StructField("name", StringType(), True),
    StructField("sal",  DecimalType(), True)
  ])
)
```

## Collect with Python / with Spark (POC)

```python
from functools import reduce
from pyspark.sql import DataFrame

dfs : list = []
for i in range(1, N):
  path = 'dbfs:/...../table-%s'%(i)
  temp_res = spark.read.parquet(path)  
  dfs.append(temp_res)

temp : DataFrame = reduce(DataFrame.unionAll, dfs)
```

```
dfs : list = spark.createDataFrame(rdd, schema)
for i in range(1, N):
  path = 'dbfs:/...../table-%s'%(i)
  temp_df = spark.read.parquet(path)  
  dfs = dfs.union(temp_df)

```


## Some ML packages
```
pyarrow.parquet
sklearn.metrics 
 - classification_report, 
 - accuracy_score, 
 - precision_score, 
 - roc_curve, 
 - auc,
 - confusion_matrix, 
 - mean_absolute_error, 
 - mean_squared_error, 
 - r2_score, median_absolute_error

pyspark.sql 
pyspark.sql.functions import round
pyspark.sql import types as T

pyspark.ml.feature import 
 - VectorAssembler, 
 - StandardScaler, 
 - PCA

pyspark.ml import 
 - Pipeline
pyspark.ml.classification 
 - RandomForestClassifier
pyspark.ml.classification 
 - LogisticRegression
pyspark.ml.evaluation 
 - BinaryClassificationEvaluator
pyspark.ml.regression 
 - RandomForestRegressor, 
 - LinearRegression


pyspark.sql.functions
 - udf
pyspark.sql.types
 - FloatType


pyspark.sql import Window

```
