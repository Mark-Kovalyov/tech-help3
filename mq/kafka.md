# Apache Kafka

## Network ports
|Service  |port|
|---------|----|
|Zookeeper|2181|
|Kafka listener|9092|
|Spark Web UI|4040|

show listen sockets
```
watch -n 1 "netstat -tnl | grep -E '(2181|9092|4040)'"
```

## Essential config (broker)
```
broker.id=0
log.dirs=/...
zookeeper.connect=localhost:2181
```

## Messaging models

* Publish-subscribe (Kafka)
* Message Queue (other)

## Kafka Consumer Group

* Consumer instances have the same consumer group works like Load Balansing
* Other instances works as broadcast


```
(Consumers in group <= Partitions)
```

* Coordinator - responsible for managing the members of the group as well
g  as their partition assigments


# Start
```
cd $KAFKA_HOME
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

### List topics
```
bin/kafka-topics.sh --bootstrap-server=localhost:9092 --list
```
### Describe topic
```
bin/kafka-topics.sh --bootstrap-server=localhost:9092 --describe --topic GAUSSV10
```
### List consumers by consumer group
```
bin/kafka-consumer-groups.sh --describe --group PRIMES_GROUP --bootstrap-server localhost:9092
```
### Create topic with custom parameters
```
bin/kafka-topics.sh --bootstrap-server=localhost:9092 --create --topic ANTARES --partitions 4
```
autocreation
```
auto.create.topics.enable=true
```

### Dump log
```
bin/kafka-dump-log.sh \
 --files 00000000000000000000.log \
 --key-decoder-class org.apache.kafka.common.serialization.UUIDSerializer \
 --value-decoder-class org.apache.kafka.common.serialization.IntegerSerializer \
 --print-data-log
```

## Partitions

* Each partition has ID
* Replica has same ID

### Leader and Follower

* Leader handler read/write requests
* Follower do not serve Clients. Just stay up to date until leader crashes.

```
replica.lag.max.messages=
replica.lag.time.max.ms=
```

### Out of sync replicas

* Slow replica
* Stuck replica (due to GC)
* bootstrapping replica


* Site https://kafka.apache.org/
* Bugtracker https://issues.apache.org/jira/projects/KAFKA/issues/

## Log Compaction

* When message key is duplicated

```
$ kafka-topics --create --zookeeper localhost:2181 \
  --topic latest-product-price \
  --replication-factor 1 \
  --partitions 1 \
  --config "cleanup.policy=compact" \
  --config "delete.retention.ms=100" \
  --config "segment.ms=100" \
  --config "min.cleanable.dirty.ration=0.01"

```

## Producers

### Message delivery semantics

* At most once
* At least once
* Exactly once

```
request.required.ack=
```

### Idempotent producer



### Key and Partitioner

* If key is not specified - messages are distributed by Round-Robin

### Batching and Compression

|Compression|Desc|
|-|-|
|uncompressed||
|gzip||
|lz4||
|snappy||
|zstd||

```
compression.type=none
```

Batch size
```
batch.size=
linger.ms=
```

### serializers

|Serializer|Desc|
|-|-|
|org.apache.kafka.common.serialization.IntegerSerializer||
|org.apache.kafka.common.serialization.StringSerializer||
|org.apache.kafka.common.serialization.ByteArraySerializer||
|org.apache.kafka.common.serialization.KafkaAvroSerializer||

### Message Durability

```
acks={ 0 | 1 | all }
```

## Message Ordering

Depends on
```
retries=
max.in.flight.requests.per.connection=
delivery.timeout.ms=
```
## Queue limits

* buffer.memory
* max.block.ms
* request.timeout.ms

# Consumer

## Consumer positions control


```
$log.dirs/

__consumer_offsets-0
__consumer_offsets-1
__consumer_offsets-10
__consumer_offsets-11
__consumer_offsets-12
__consumer_offsets-13
...
```

### 1) Automatic offset commiting

```
properties.put("enable.auto.commit", "true");
properties.put("auto.commit.interval.ms", "1000");   
properties.put("group.id", "gr001");
```

### 2) Manual offset control

```
properties.put("enable.auto.commit", "false");
properties.put("group.id", "gr001");
....
consumer.commitSync();
```

## Offset  management

|             |At most once(максимум 1 раз)|At least once(хотя-бы 1 раз)|Exactly once                                |
|-------------|----------------------------|----------------------------|--------------------------------------------|
|Offset commit|When msg received           |When msg processed          |Transactional consumer + idenpotent producer|
|Speed|High|Moderate|Lowest|
|Delivery guarantee|Data loss possible|No loss, can receive message multiple times|Message Delivered only 1 time|
|Use case|Log agregation, metric collection|ATM transactions|Financial transactions|

## Sync and Async commit

```
consumer.commitSync();
```

## Rebalance Configuration

```
enable.auto.commit=
auto.offset.reset=
```
## Group config

```
group.id=
session.timeout.ms=
```

## Subscribe to specific partition

```
String topic = "TRANS";
TopicPartition p0 = new TopicPartition(topic, 0);
TopicPartition p1 = new TopicPartition(topic, 1);
consumer.assign(Arrays.asList(p0,p1));
```



## Videos

* https://www.youtube.com/watch?v=A_yUaPARv8U

## Terminology

* Topic
  * contains Partitions
  * Partitions contains segments
  * last (active) segment - ready to receive data  
* Producer
* Consumer
* Broker

### Topic

```
segment = (base_offset, data, index, timeindex)

000001234.log
000001234.index
000001234.timeindex
```

## Configuration

## Zookeeper

```
tickTime=2000
dataDir=/bigdata/zookeeper
clientPort=2181
```
Replicated zookeeper
```
initLimit=5
syncLimit=2
server.1=zoo1:2888:3888
server.2=zoo2:2888:3888
server.3=zoo3:2888:3888
```
start
```
???
```
## Kafka

```
broker.id=0
listeners=PLAINTEXT://:9092
num.network.threads=3
num.io.threads=8

socket.send.buffer.bytes=102400
socket.receive.buffer.bytes=102400
socket.request.max.bytes=104857600

log.dirs=/bigdata/kafka/kafka-logs
num.partitions=1
num.recovery.threads.per.data.dir=1
offsets.topic.replication.factor=1
transaction.state.log.replication.factor=1
transaction.state.log.min.isr=1

#log.retention.hours=168
log.retention.minutes=10
log.segment.bytes=1073741824
log.retention.check.interval.ms=300000

zookeeper.connect=localhost:2181
zookeeper.connection.timeout.ms=18000

group.initial.rebalance.delay.ms=0

```
start
```
bin/kafka-server-start.sh config/server.properties
```

## Producer

```
client.id = "Java11.Kafka.application"
acks = { 0 | 1 | all }
batch.size = 128K ?
linger.ms = ?
retries = ?
compression.type = { snappy | gzip | lz4 }
max.block.ms = ?
max.request.size
receive.buffer.bytes = ?
send.buffer.bytes = ?
```

## Configure retention for server
```
log.retention.minutes=10
```

## Consumer

## Performance tunning

### G1GC

```
-server
-XX:UseG1GC
-XX:MaxGCPauseMillis=200
-XX:InitiatingHeapOccupancyPercent=45
-XX:DisableExplicitGC
-Djava.aws.headless=true

```

### Linux-kernel parameters

```
vm.swappiness = 1
vm.dirty_background_ratio = 5
vm.dirty_ratio = 80
```

### Disk

* EXT4
* XFS
* Disable "atime" update

### Network

```
net.core.wmem_default = 2Mb
net.core.rmem_default = 2Mb
net.ipv4.tcp_wmem = 4096 65536 2048000
net.ipv4.tcp_rmem = 4096 65536 2048000
```

### FAQ

Q: How to limit wait time when broker is down?

```
Q: Kafka is down during start with message like InconsistentClusterIdException ...

A: remove file ${kafka.log.dir}/metadata.properties
```
