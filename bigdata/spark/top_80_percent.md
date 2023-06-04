# Top 80% consumers of something (Paretto) and other window function use-cases

```
+-----+------+---------+----+----------+------+------+-----+
|empno| ename|      job| mgr|  hiredate|   sal|  comm|depno|
+-----+------+---------+----+----------+------+------+-----+
| 7369| SMITH|    CLERK|7902|1980-12-17| 800.0|  null|   20|
| 7499| ALLEN| SALESMAN|7698|1981-02-20|1600.0| 300.0|   30|
| 7521|  WARD| SALESMAN|7698|1981-02-22|1250.0| 500.0|   30|
| 7566| JONES|  MANAGER|7839|1981-04-02|2975.0|  null|   20|
| 7654|MARTIN| SALESMAN|7698|1981-09-28|1250.0|1400.0|   30|
| 7698| BLAKE|  MANAGER|7839|1981-05-01|2850.0|  null|   30|
| 7782| CLARK|  MANAGER|7839|1981-06-09|2450.0|  null|   10|
| 7788| SCOTT|  ANALYST|7566|1987-04-19|3000.0|  null|   20|
| 7839|  KING|PRESIDENT|null|1981-11-17|5000.0|  null|   10|
| 7844|TURNER| SALESMAN|7698|1981-09-08|1500.0|   0.0|   30|
| 7876| ADAMS|    CLERK|7788|1987-05-23|1100.0|  null|   20|
| 7900| JAMES|    CLERK|7698|1981-12-03| 950.0|  null|   30|
| 7902|  FORD|  ANALYST|7566|1981-12-03|3000.0|  null|   20|
| 7934|MILLER|    CLERK|7782|1982-01-23|1300.0|  null|   10|
+-----+------+---------+----+----------+------+------+-----+
```

## Sum sal
```
select sum(sal) from emp;
sum(sal)
29025
```

## Salary + enames ordered by sal
```
select ename, sal from emp order by sal desc, ename;
ename   sal
KING    5000
FORD    3000
SCOTT   3000
JONES   2975
BLAKE   2850
CLARK   2450
ALLEN   1600
TURNER  1500
MILLER  1300
MARTIN  1250
WARD    1250
ADAMS   1100
JAMES   950
SMITH   800
```

## Salary rank by dept

```sql
SELECT
  ename,
  depno,
  sal,
  RANK() OVER (PARTITION BY depno ORDER BY depno, sal DESC) AS rank
FROM emp
```
```
+------+-----+------+----+
| ename|depno|   sal|rank|
+------+-----+------+----+
|  KING|   10|5000.0|   1|
| CLARK|   10|2450.0|   2|
|MILLER|   10|1300.0|   3|
| SCOTT|   20|3000.0|   1|
|  FORD|   20|3000.0|   1|
| JONES|   20|2975.0|   3|
| ADAMS|   20|1100.0|   4|
| SMITH|   20| 800.0|   5|
| BLAKE|   30|2850.0|   1|
| ALLEN|   30|1600.0|   2|
|TURNER|   30|1500.0|   3|
|  WARD|   30|1250.0|   4|
|MARTIN|   30|1250.0|   4|
| JAMES|   30| 950.0|   6|
+------+-----+------+----+
```
The same with DENSE_RANK
```sql
+------+-----+------+----+
| ename|depno|   sal|rank|
+------+-----+------+----+
|  KING|   10|5000.0|   1|
| CLARK|   10|2450.0|   2|
|MILLER|   10|1300.0|   3|
| SCOTT|   20|3000.0|   1|
|  FORD|   20|3000.0|   1|
| JONES|   20|2975.0|   2|
| ADAMS|   20|1100.0|   3|
| SMITH|   20| 800.0|   4|
| BLAKE|   30|2850.0|   1|
| ALLEN|   30|1600.0|   2|
|TURNER|   30|1500.0|   3|
|  WARD|   30|1250.0|   4|
|MARTIN|   30|1250.0|   4|
| JAMES|   30| 950.0|   5|
+------+-----+------+----+
```


## Top
```
select
  ename,
  sal,
  sum(sal) OVER (ORDER BY sal DESC) AS cum_sal
from emp
```
```
+------+------+-------+
| ename|   sal|cum_sal|
+------+------+-------+
|  KING|5000.0| 5000.0|
| SCOTT|3000.0|11000.0|
|  FORD|3000.0|11000.0|
| JONES|2975.0|13975.0|
| BLAKE|2850.0|16825.0|
| CLARK|2450.0|19275.0|
| ALLEN|1600.0|20875.0|
|TURNER|1500.0|22375.0|
|MILLER|1300.0|23675.0|
|  WARD|1250.0|26175.0|
|MARTIN|1250.0|26175.0|
| ADAMS|1100.0|27275.0|
| JAMES| 950.0|28225.0|
| SMITH| 800.0|29025.0|
+------+------+-------+
```

## Top 80 from Chat-GPT

```
WITH ranked_consumers AS (
  SELECT
    consumer_id,
    field_value,
    PERCENT_RANK() OVER (ORDER BY field_value DESC) AS percentile_rank
  FROM
    consumers
)
SELECT
  consumer_id,
  field_value
FROM
  ranked_consumers
WHERE
  percentile_rank <= 0.8
ORDER BY
  field_value DESC;
```

```
WITH ranked_emps AS (
  SELECT
    ename,
    sal,
    PERCENT_RANK() OVER (ORDER BY sal DESC) AS percentile_rank
  FROM
    emp
)
SELECT
  ename,
  sal,
  percentile_rank
FROM
  ranked_emps
WHERE
  percentile_rank <= 0.8
ORDER BY
  sal DESC;
```
