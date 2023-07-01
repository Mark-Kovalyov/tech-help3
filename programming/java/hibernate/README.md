# Hibernate

## Links

* Hibernate 5.6 ORM - https://hibernate.org/orm/documentation/5.6/

## Dependencies

```
implementation 'org.hibernate:hibernate-core:5.6.3.Final'
testImplementation group: 'com.h2database', name: 'h2', version: '2.0.202'
```

example for h2 configuration
```
<property name="connection.driver_class">org.h2.Driver</property>
<property name="connection.url">jdbc:h2:mem:test</property>
<property name="connection.username">sa</property>
<property name="connection.password"></property>
```
example for PostgresQL configuration
```
```

## Typical logging configuration

```
```

## Activate hibernate statistics

https://thorben-janssen.com/how-to-activate-hibernate-statistics-to-analyze-performance-issues/

## Flow

1. Open session
2. Open transaction
