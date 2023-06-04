# JDBC databricks driver

* Download driver : https://databricks.com/spark/jdbc-drivers-download
* Apache Arrow : https://arrow.apache.org/docs/index.html

## Install
```
mvn install:install-file -Dfile=lib/DatabricksJDBC42.jar -DgroupId=com.databricks -DartifactId=DatabricksJDBC42 -Dversion=2.6.25 -Dpackaging=jar
```

```
jdbc:databricks://<Server Hostname>:443;HttpPath=<Http Path>[;property=value[;property=value]]
```
