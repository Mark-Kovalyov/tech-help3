# H2

## Install

https://h2database.com/html/main.html

```
wget https://search.maven.org/remotecontent?filepath=com/h2database/h2/2.1.214/h2-2.1.214.jar
```

## Run UI
```
java -cp h2*.jar
```

## Shell
```
java -cp h2*.jar org.h2.tools.Shell -url jdbc:h2:.....
```

## Read from CSV

```
SELECT * FROM CSVREAD('geo-ip-city.csv');
```

## Shell with custom script
```
java -cp h2*.jar org.h2.tools.Shell -url jdbc:h2:..... -sql script.sql
```

## Generate Jar/Zip R/O database

### Shutdown defrag
```
SHUTDOWN DEFRAG
```
### Backup

```
java -cp h2*.jar org.h2.tools.Backup -db ? -file ?
```

```
sql> backup to 'geo-ip-city.zip';
```
