# Free and OpenSource MQ-brokers

| Broker                   |JMS spec | STOMP | AMQP | OpenWire | MQTT | HornetQ | Platform/Lang | Project site |
|--------------------------|---------|-------|------|----------|------|---------|---------------|--------------|
| Apache Active MQ         |  1.1    |  yes  | yes  |  yes     | yes  |         | Java
| Apache Active MQ Artemis |  1.1    |  yes  | yes  |  yes     | yes  |  yes    | Java
| Rabbit-MQ                |         |  yes  | yes  |          | yes  |  yes    | Erlang
| HornetQ                  |         |  yes  | 1.0  |          |      |         | Java
| Apache Kafka             |         |       |      |          |      |         | Scala/Java
| Open JMS                 |         |       |      |          |      |         | http://openjms.sourceforge.net/index.html |



## Protocols

* AMQP (Advanced Message Queuing Protocol). Exchange/fanout/direct/topic. Message. Queue.
* MQTT  message queuing telemetry transport
	* Publisher-Subscriber

## Tools

### AMQP tools

* amqp-publish
* amqp-consume
* amqp-get

## MQTT C/Java libraries

* Eclipse Paho (Client)
  * https://github.com/eclipse/paho.mqtt.c/releases
* Mosquitto (broker)
  * https://mosquitto.org/documentation/
* EMQX - is an Open-source MQTT
  (opens new window) broker with a high-performance real-time message processing engine, powering event streaming for IoT devices at massive scale. As the most scalable MQTT broker, EMQX can help you connect any device, at any scale. Move and process your IoT data anywhere.
	* https://www.emqx.io/docs/en/v5.0/

### MQTT Java

```xml
<dependency>
  <groupId>org.eclipse.paho</groupId>
  <artifactId>org.eclipse.paho.client.mqttv3</artifactId>
  <version>1.2.0</version>
</dependency>
```

```java
String publisherId = UUID.randomUUID().toString();
IMqttClient publisher = new MqttClient("tcp://iot.eclipse.org:1883",publisherId);

subscriber.subscribe(EngineTemperatureSensor.TOPIC, (topic, msg) -> {
    byte[] payload = msg.getPayload();
});
```



## Links

Other Open-source Java JMS implementations

https://java-source.net/open-source/jms
