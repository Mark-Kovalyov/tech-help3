# AWS machine learning

* Evaluating RIsk for Loan Approvals - MLFlow Model Registry and Publishing to SageMaker

## ML flow components

* tracking
* projects
* models
* model registry
* model serving

## Frameworks

### Koalas

```
pip install pandas
```

```
import databricks.koalas as ks

kdf = data.to_koalas()

kdf{{"loan_amount", "loan_st"}}.head(5)

kdf.groupBy({"loan_st"}).agg()
```


Merge schema
```
.option("mergeSchema", true)
```

Grab Models Metrics
```
from pyspark.mllib.

```

Stacked ROC Curves
```
from org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
```

Census income dataset
```
import

schema = StructType({

})
```
