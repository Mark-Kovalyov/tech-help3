# Cassandra 4.0

## Virtual tables
```
cqlsh> select * from system_views.clients;

 address   | port  | connection_stage | driver_name            | driver_version | hostname  | protocol_version | request_count | ssl_cipher_suite | ssl_enabled | ssl_protocol | username
-----------+-------+------------------+------------------------+----------------+-----------+------------------+---------------+------------------+-------------+--------------+-----------
 127.0.0.1 | 44890 |            ready | DataStax Python Driver |         3.25.0 | localhost |                5 |            19 |             null |       False |         null | anonymous
 127.0.0.1 | 44892 |            ready | DataStax Python Driver |         3.25.0 | localhost |                5 |             6 |             null |       False |         null | anonymous

```

## Full Query logging (FQL)

```
```

CREATE KEYSPACE dht WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};
