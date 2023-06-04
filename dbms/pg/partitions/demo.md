```
postgres=# CREATE TABLE customers (id INTEGER, status TEXT, arr NUMERIC) PARTITION BY LIST(status);
 postgres=# CREATE TABLE cust_active PARTITION OF customers FOR VALUES IN ('ACTIVE','RECURRING','REACTIVATED') PARTITION BY RANGE(arr);
  postgres=# CREATE TABLE cust_arr_small PARTITION OF cust_active FOR VALUES FROM (MINVALUE) TO (101) PARTITION BY HASH(id);
   postgres=# CREATE TABLE cust_part11 PARTITION OF cust_arr_small FOR VALUES WITH (modulus 2, remainder 0);
   postgres=# CREATE TABLE cust_part12 PARTITION OF cust_arr_small FOR VALUES WITH (modulus 2, remainder 1);
 postgres=# CREATE TABLE cust_other PARTITION OF customers DEFAULT PARTITION BY RANGE(arr);
  postgres=# CREATE TABLE cust_arr_large PARTITION OF cust_other FOR VALUES FROM (101) TO (MAXVALUE) PARTITION BY HASH(id);

CREATE TABLE

postgres=# CREATE TABLE cust_part21 PARTITION OF cust_arr_large FOR VALUES WITH (modulus 2, remainder 0);

CREATE TABLE

postgres=# CREATE TABLE cust_part22 PARTITION OF cust_arr_large FOR VALUES WITH (modulus 2, remainder 1);

CREATE TABLE

postgres=#

postgres=# \d+ customers

                           Partitioned table "public.customers"

 Column |  Type   | Collation | Nullable | Default | Storage  | Stats target | Description

--------+---------+-----------+----------+---------+----------+--------------+-------------

 id     | integer |           |          |         | plain    |              |

 status | text    |           |          |         | extended |              |

 arr    | numeric |           |          |         | main     |              |

Partition key: LIST (status)

Partitions: cust_active FOR VALUES IN ('ACTIVE', 'RECURRING', 'REACTIVATED'), PARTITIONED,

            cust_other DEFAULT, PARTITIONED



postgres=# \d+ cust_active

                          Partitioned table "public.cust_active"

 Column |  Type   | Collation | Nullable | Default | Storage  | Stats target | Description

--------+---------+-----------+----------+---------+----------+--------------+-------------

 id     | integer |           |          |         | plain    |              |

 status | text    |           |          |         | extended |              |

 arr    | numeric |           |          |         | main     |              |

Partition of: customers FOR VALUES IN ('ACTIVE', 'RECURRING', 'REACTIVATED')

Partition constraint: ((status IS NOT NULL) AND (status = ANY (ARRAY['ACTIVE'::text, 'RECURRING'::text, 'REACTIVATED'::text])))

Partition key: RANGE (arr)

Partitions: cust_arr_small FOR VALUES FROM (MINVALUE) TO ('101'), PARTITIONED



postgres=# \d+ cust_arr_small

                         Partitioned table "public.cust_arr_small"

 Column |  Type   | Collation | Nullable | Default | Storage  | Stats target | Description

--------+---------+-----------+----------+---------+----------+--------------+-------------

 id     | integer |           |          |         | plain    |              |

 status | text    |           |          |         | extended |              |

 arr    | numeric |           |          |         | main     |              |

Partition of: cust_active FOR VALUES FROM (MINVALUE) TO ('101')

Partition constraint: ((status IS NOT NULL) AND (status = ANY (ARRAY['ACTIVE'::text, 'RECURRING'::text, 'REACTIVATED'::text])) AND (arr IS NOT NULL) AND (arr < '101'::numeric))

Partition key: HASH (id)

Partitions: cust_part11 FOR VALUES WITH (modulus 2, remainder 0),

            cust_part12 FOR VALUES WITH (modulus 2, remainder 1)



postgres=# \d+ cust_part11

                                Table "public.cust_part11"

 Column |  Type   | Collation | Nullable | Default | Storage  | Stats target | Description

--------+---------+-----------+----------+---------+----------+--------------+-------------

 id     | integer |           |          |         | plain    |              |

 status | text    |           |          |         | extended |              |

 arr    | numeric |           |          |         | main     |              |

Partition of: cust_arr_small FOR VALUES WITH (modulus 2, remainder 0)

Partition constraint: ((status IS NOT NULL) AND (status = ANY (ARRAY['ACTIVE'::text, 'RECURRING'::text, 'REACTIVATED'::text])) AND (arr IS NOT NULL) AND (arr < '101'::numeric) AND satisfies_hash_partition('16621'::oid, 2, 0, id))

Access method: heap



postgres=#

postgres=# INSERT INTO customers VALUES (1,'ACTIVE',100), (2,'RECURRING',20), (3,'REACTIVATED',38), (4,'EXPIRED',144);

INSERT 0 4

postgres=# SELECT tableoid::regclass,* FROM customers;

  tableoid   | id |   status    | arr

-------------+----+-------------+-----

 cust_part11 |  1 | ACTIVE      | 100

 cust_part11 |  2 | RECURRING   |  20

 cust_part12 |  3 | REACTIVATED |  38

 cust_part22 |  4 | EXPIRED     | 144
```
