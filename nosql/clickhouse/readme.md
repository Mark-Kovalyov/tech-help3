# Clickhouse

* Column oriented
* Always sorted per column
* Линейно машстабируется. При репликации данных производительность растет.
* No primary key. Use order key insted.
* No UPDATE, DELETE
* Has CLI, TCP, HTTP, JS/Http


## Sorting

type | style | color |method
-----|-------|-------|-------
1    | 4     |   543 |    32
2    | 6     |   3421|    43295
5    | 10    |   5235|    82341


Storing : 1(1), 2(3), 5(3)
          4(2), 6(3), 10(1)

## SQL

YES

## Same systems

* Vertica
* Paracell
* SybaceIQ
* InfiniDB

## Performance

100 mln records per 1 src

## Sampling
