# Connect Databricks notebook to CosmosDb

## API

See https://docs.microsoft.com/en-us/azure/cosmos-db/

|API|Mvn|
|-|-|
|SQL/Core API|
|Cassandra API
|MongoDb API
|Table API|
|Gremlin API|

## See:

* Quickstart : https://docs.microsoft.com/en-us/azure/cosmos-db/sql/create-sql-api-spark
* Config Ref : https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/cosmos/azure-cosmos-spark_3_2-12/docs/configuration-reference.md

## Install driver

Clister -> Libraries -> Install

|Spark|Driver|
|-|-|
|Spark 3.2+|com.azure.cosmos.spark:azure-cosmos-spark_3-2_2-12:4.10.0|

## Get access

```scala
display(
  spark.read
    .format("cosmos.oltp")
    .option("spark.cosmos.accountEndpoint", "https://.....azure.com:443")
    .option("spark.cosmos.accountKey","......")
    .option("spark.cosmos.database",".....")
    .option("spark.cosmos.container",".....")
    .option("spark.cosmos.read.inferSchema.includeTimestamp","true")
    .load()
    .limit(1)
)
```

## With Java-client

* com.azure:azure-cosmos:4.31.0

```
val clientBuilder : CosmosClientBuilder = new CosmosClientBuilder()
clientBuilder.endpoint("https://......azure.com:443")
clientBuilder.key("0384756938475690873845698347589")
val client : CosmosClient = clientBuilder.buildClient()
val db : CosmosDatabase = client.getDatabase("scott")
db.createContainer("emp","/emp_id")
client.close()
```
