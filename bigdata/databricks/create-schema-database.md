# Create new schema/database

```

display(dbutils.fs.mounts())


DESC SCHEMA analytics;



CREATE SCHEMA IF NOT EXISTS demo 
COMMENT 'Demo schema' 
LOCATION 'dbfs:/mnt/host/warehouse/demo.db';


  


```




## Simple case
```
CREATE SCHEMA IF NOT EXISTS demo COMMENT 'Demo';
```


## Alter schema
```
ALTER SCHEMA employees SET DBPROPERTIES ('Create-by' = 'Scott', 'Create-date' = '09/01/2019');
```

## Decs schema
```
{ DESC | DESCRIBE } SCHEMA [ EXTENDED ] schema_name
```
```
Location : dbfs:/user/hive/warehouse/demo.db
Owner : root
```

## Drop schema
```
DROP SCHEMA demo
```