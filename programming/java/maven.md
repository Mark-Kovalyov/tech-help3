# Maven

## Evaluate some expressions
```
$ mvn help:evaluate
[INFO] Enter the Maven expression i.e. ${project.groupId} or 0 to exit?:
${project.groupId}
[INFO]
com.oracle.dbms
```

## Run with debugger
```
MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000

mvn compile exec:java -U -Dexec.mainClass=mayton.bigdata.Main -Dproperty1=value1 ...
```

## Show dependency tree
```

```
