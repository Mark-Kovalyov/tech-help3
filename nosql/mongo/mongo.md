# Mongo

## Ports
|Port|Desc|
|-|-|
|27017|Listener|

## Driver
```
org.mongodb:mongo-java-driver:3.12.11
```

## Create database

## Create collection

## Query

Mongo shell
```
db.inventory.find({})
db.inventory.find({ $or : [ {status : "A"}, {qty: {$lt: 30}} ])  
```
Java
```java
FindIterable<Document> findIterable = collection.find(new Document())

findIterable = collection.find(or(eq("status","A"),lt("qty",30))
```

## Run with Docker

```
docker run --name some-mongo -d mongo
```
