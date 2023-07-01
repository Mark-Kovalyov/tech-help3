# Hibernate Performance

* JPoint : Make Hibernate faster - https://www.youtube.com/watch?v=b52Qz6qlic0&t=3100s

## How to measure

Statistics:
```xml
<property name="hibernate.generate_statistics" value="true"/>
<logger name="org.hibernate.stat">
  <level value="DEBUG"/>
</logger>  
```
## Add trace abilities

hibernate.cfg.xml
```xml
<property name="show_sql">true</property>
<property name="format_sql">true</property>
<property name="use_sql_comments">true</property>
```

log4j.props
```
log4j.logger.org.hibernate=INFO, hb
log4j.logger.org.hibernate.SQL=DEBUG
log4j.logger.org.hibernate......

log4j.appender.hb=org.apache.log4j.ConsoleAppender
....
log4j.appender.hb.Threshold=TRACE

```

## Model

```
class Client{
  @Id
  @GeneratedValue(strategy = SEQUENCE)
  @Column("id_client")
  private Integer id;
  private String name
  private int age;
  @OneToMany(mappedBy = "client")  
  private List<Account> accounts = new ArrayList();
}
```

## JDBC tuning

* Use good implementation of connected pool
* Batching, fetching
```xml
<property name="hibernate.jdbc.batch_size">50</property>
<property name="hibernate.jdbc.fetch_size">50</property>
```
* Switch to native queries where Performance is critical
* Do direct JDBC stuff with Session doWork

## N+1, lazy loading issues

* Eager
* Entity graphs
* Fetch modes
* Fetch profiles
* Query batching

### Eager load (antipattern)

Fix(1): inner join between 2 tables:
```
join fetch c.accounts
```
Fix(2): modify entity with SUBSELECT
```
@OneToMany(mappedBy = "client")
@Fetch(FetchMode.SUBSELECT)
private List<Account> accounts = new ArrayList();
```
Fix(3): batching
```
@OneToMany(mappedBy = "client")
@Batching(size = 5)
private List<Account> accounts = new ArrayList();
```

Fix(4): named entity graphs (Not Hibernate but JPA-feature!)
```java
@NamedEntityGraphs(
    @NamedEntityGraph(name = "Client[accounts]", attributeNodes = @NamedAttributeNode("accounts")
)
class Client {
  ....
}  

/////////////////////////////

List<Client> clients = findAdultClientsQuery()
  .setHint(QueryHints.FETCHGRAPH, em.getEntityGraph("Client[accounts]"))
  .getResultList();

```

### Operations batching

* Flush session state to avoid memory issues
* Use JDBC batching options
```
hibernate.order_inserts=true
hibernate.order_updates=true
hibernate.jdbc.batch_versioned_data=true
```
* Deletes are batched only for the same table

## Caching (Second level cache)

```java
@Cachable
@Cache(region = "refCache", usage = CacheConcurrencyStrategy.READ_ONLY)
@Immutable
class City {
  .....
}

///////

session.createQuery(query)
  .setCacheble(true)
  .list()

```

Statistics will be smth like:
```
.... nanoseconds spent performing 2 L2C puts
..... nanoseconds spent performing 2 L2C hits
... nanoseconds spent performing 2 L2C misses
```

Be carefull with second level cache! You can receive 3 queries instead
of one in some scenarios!

Where:
* FileSystem
* Memory

Providers:
* EhCache
* JBoss Cache
* Hazelcast
* GridGain

## Mark lightweight requests

* R/O flag for transactions
* Choose appropriate transaction isolation level
* Annotate entity as Immutable if its not updated anywhere
* Use StatelessSession for some Operations

## Dont use entities everywhere

* ResultTransformers and Transformers (Deprecated in 4,5?)
* Fields map instead of object
* @SqlResultSetMapping
* Direct mapping on DTO

## Dont update all columns

* Dynamic insert,update

```java
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
class Entity {

}
```

## Slow ID generation

* Dont use Generation.AUTO, use SEQUENCE
* Try to generate ID/PK in the code, do not delegate to Hibernate

## Other advices

* Use native queries
* Dont use lists, arrays and ordering in Hibernate

## Start thinking in CQRS way
