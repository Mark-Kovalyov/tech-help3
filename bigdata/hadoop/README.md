# Hadoop

## Versions / Java
|Released|Hadoop|JRE|Java Source code|Other features|
|-|-|-|-|-|
|2022 May 17|hadoop-3.3.3|JRE11|JDK-8|Lz4,Snappy,Protobuf-3.7.1,shaded guava

## CLI

```
$ hadoop
Usage: hadoop [OPTIONS] SUBCOMMAND [SUBCOMMAND OPTIONS]
 or    hadoop [OPTIONS] CLASSNAME [CLASSNAME OPTIONS]
  where CLASSNAME is a user-provided Java class

  OPTIONS is none or any of:

buildpaths                       attempt to add class files from build tree
--config dir                     Hadoop config directory
--debug                          turn on shell script debug mode
--help                           usage information
hostnames list[,of,host,names]   hosts to use in slave mode
hosts filename                   list of hosts to use in slave mode
loglevel level                   set the log4j level for this command
workers                          turn on worker mode

  SUBCOMMAND is one of:


    Admin Commands:

daemonlog     get/set the log level for each daemon

    Client Commands:

archive       create a Hadoop archive
checknative   check native Hadoop and compression libraries availability
classpath     prints the class path needed to get the Hadoop jar and the required libraries
conftest      validate configuration XML files
credential    interact with credential providers
distch        distributed metadata changer
distcp        copy file or directories recursively
dtutil        operations related to delegation tokens
envvars       display computed Hadoop environment variables
fs            run a generic filesystem user client
gridmix       submit a mix of synthetic job, modeling a profiled from production load
jar <jar>     run a jar file. NOTE: please use "yarn jar" to launch YARN applications, not this command.
jnipath       prints the java.library.path
kdiag         Diagnose Kerberos Problems
kerbname      show auth_to_local principal conversion
key           manage keys via the KeyProvider
rumenfolder   scale a rumen input trace
rumentrace    convert logs into a rumen trace
s3guard       manage metadata on S3
trace         view and modify Hadoop tracing settings
version       print the version

    Daemon Commands:

kms           run KMS, the Key Management Server
registrydns   run the registry DNS server

SUBCOMMAND may print help when invoked w/o parameters or with -h.

```

```
$ echo $HADOOP_HOME
/hadoop/3.1.2
$ java -version
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment (build 11.0.11+9-Ubuntu-0ubuntu2.20.04)
OpenJDK 64-Bit Server VM (build 11.0.11+9-Ubuntu-0ubuntu2.20.04, mixed mode, sharing)
```

## Getting Started

### Create user hadoop

```
useradd hadoop
passwd hadoop
****
```
Yet another sample:
```
sudo adduser --ingroup hadoop hadoopusr
```

### SSH
```
ssh-keygen -t rsa
```
Add new public key to authorized
```
cat .ssh/id_rsa.pub >> .ssh/authorized_keys
```
### Configure
core-site.xml
```
+
 <property>
  <name>fs.defaultFS</name>
  <value>hdfs://localhost:9000</value>
 </property>
```
hdfs-site.xml
```
+
 <property>
  <name>dfs.replication</name>
  <value>1</value>
 </property>
 <property>
  <name>dfs.namenode.name.dir</name>
  <value>/home/hadoop/hdfs/namenode/</value>
 </property>
 <property>
  <name>dfs.namenode.data.dir</name>
  <value>/home/hadoop/hdfs/datanode/</value>
 </property>
```
hadoop-env.sh
```
+
JAVA_HOME=.....
```

### Start NameNode

```
$ ./hdfs namenode -format
```
### Start DFS
```
./start-dfs.sh
```
Proced to web UI https://localhost:9870

### Stop all Apache Hadoop daemons

```
./stop-all.sh
```

## Links

* https://www.youtube.com/watch?v=EJj_0o-EY50
* https://www.youtube.com/watch?v=ieeCyhQ2PPM

## Errors

```
$ hdfs datanode
2022-01-12 23:44:03,529 ERROR datanode.DataNode: Exception in secureMain
java.io.IOException: No services to connect, missing NameNode address.
	at org.apache.hadoop.hdfs.server.datanode.BlockPoolManager.refreshNamenodes(BlockPoolManager.java:165)
	at org.apache.hadoop.hdfs.server.datanode.DataNode.startDataNode(DataNode.java:1449)
	at org.apache.hadoop.hdfs.server.datanode.DataNode.<init>(DataNode.java:513)
	at org.apache.hadoop.hdfs.server.datanode.DataNode.makeInstance(DataNode.java:2848)
	at org.apache.hadoop.hdfs.server.datanode.DataNode.instantiateDataNode(DataNode.java:2754)
	at org.apache.hadoop.hdfs.server.datanode.DataNode.createDataNode(DataNode.java:2798)
	at org.apache.hadoop.hdfs.server.datanode.DataNode.secureMain(DataNode.java:2942)
	at org.apache.hadoop.hdfs.server.datanode.DataNode.main(DataNode.java:2966)
2022-01-12 23:44:03,530 INFO util.ExitUtil: Exiting with status 1: java.io.IOException: No services to connect, missing NameNode address.
2022-01-12 23:44:03,533 INFO datanode.DataNode: SHUTDOWN_MSG:
/************************************************************
SHUTDOWN_MSG: Shutting down DataNode at hostname/127.0.1.1
************************************************************/
```

