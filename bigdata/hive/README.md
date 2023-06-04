# Hive

## Extensions

|Ext|Desc|
|-|-|
|.hql|Hive query script

## Beeline

Beeline is a Hive client that is included on the head
nodes of your HDInsight cluster.

### Connection

```
beeline -u 'jdbc:hive2://headnodehost:10001/;transportMode=http'
```
