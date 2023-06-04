# Hadoop HDFS

* The Hadoop Distributed File System (HDFS) is a distributed file system designed to run on commodity hardware.
* It has many similarities with existing distributed file systems. However, the differences from other distributed file systems are significant.
* HDFS is highly fault-tolerant and is designed to be deployed on low-cost hardware.
* HDFS provides high throughput access to application data and is suitable for applications that have large data sets.
* HDFS relaxes a few POSIX requirements to enable streaming access to file system data.
* HDFS was originally built as infrastructure for the Apache Nutch web search engine project.
* HDFS is now an Apache Hadoop subproject.

## Environment
```
HADOOP_HOME=/hadoop/3.3.5
```

## Ports
|Service|Port|
|-------|----|
|

## Configure destination folder
```
dfs.datanode.data.dir (Deprecated : dfs.data.dir) =
```

## Start HDFS server (TODO)
```
$HADOOP_HOME/....
```

## Check for TCP port is opened (TODO)
```
$ nc -zv localhost ....
```

## Just copy some testfile to HDFS filesysystem (TODO)
```
$ hdfs dfs -put /bigdata/db/hadoop/QCLCD201604.zip /weather
```

## General help HDFS
```
$ hdfs
Usage: hdfs [OPTIONS] SUBCOMMAND [SUBCOMMAND OPTIONS]

  OPTIONS is none or any of:

--buildpaths                       attempt to add class files from build tree
--config dir                       Hadoop config directory
--daemon (start|status|stop)       operate on a daemon
--debug                            turn on shell script debug mode
--help                             usage information
--hostnames list[,of,host,names]   hosts to use in worker mode
--hosts filename                   list of hosts to use in worker mode
--loglevel level                   set the log4j level for this command
--workers                          turn on worker mode

  SUBCOMMAND is one of:


    Admin Commands:

cacheadmin           configure the HDFS cache
crypto               configure HDFS encryption zones
debug                run a Debug Admin to execute HDFS debug commands
dfsadmin             run a DFS admin client
dfsrouteradmin       manage Router-based federation
ec                   run a HDFS ErasureCoding CLI
fsck                 run a DFS filesystem checking utility
haadmin              run a DFS HA admin client
jmxget               get JMX exported values from NameNode or DataNode.
oev                  apply the offline edits viewer to an edits file
oiv                  apply the offline fsimage viewer to an fsimage
oiv_legacy           apply the offline fsimage viewer to a legacy fsimage
storagepolicies      list/get/set/satisfyStoragePolicy block storage policies

    Client Commands:

classpath            prints the class path needed to get the hadoop jar and the required libraries
dfs                  run a filesystem command on the file system
envvars              display computed Hadoop environment variables
fetchdt              fetch a delegation token from the NameNode
getconf              get config values from configuration
groups               get the groups which users belong to
lsSnapshottableDir   list all snapshottable dirs owned by the current user
snapshotDiff         diff two snapshots of a directory or diff the current directory contents with a snapshot
version              print the version

    Daemon Commands:

balancer             run a cluster balancing utility
datanode             run a DFS datanode
dfsrouter            run the DFS router
diskbalancer         Distributes data evenly among disks on a given node
httpfs               run HttpFS server, the HDFS HTTP Gateway
journalnode          run the DFS journalnode
mover                run a utility to move block replicas across storage types
namenode             run the DFS namenode
nfs3                 run an NFS version 3 gateway
portmap              run a portmap service
secondarynamenode    run the DFS secondary namenode
sps                  run external storagepolicysatisfier
zkfc                 run the ZK Failover Controller daemon
```
