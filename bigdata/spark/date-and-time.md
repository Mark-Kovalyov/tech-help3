# Date and time in Spark

* DateType: Represents values comprising values of fields year, month and day, without a time-zone.
* TimestampType: Timestamp with local time zone(TIMESTAMP_LTZ). It represents values comprising values of fields year, month, day, hour, minute, and second, with the session local time-zone. The timestamp value represents an absolute point in time.
* TimestampNTZType: Timestamp without time zone(TIMESTAMP_NTZ). It represents values comprising values of fields year, month, day, hour, minute, and second. All operations are performed without taking any time zone into account.


## Popular time zones (Java API)

|Time Zone  |Value|
|-----------|-----
|London     |
|Moscow     |MSK (Moscow Standard Time)
|Kiev       |
|Los-Angelos|PDT (Pacific Day Time)
|Hamburg    |CEST (Central European Summer Time)

## Types
```
import org.apache.spark.sql.types._
```

|Spark type      |Scala type                             | API to access  | Example                    |
|----------------|---------------------------------------|----------------|----------------------------|
|DateType        |java.time.LocalDate or java.sql.Date   |DateType        |                            |
|TimestampType	 |java.time.Instant or java.sql.Timestamp|TimestampType   |2023-05-16T13:19:39.320+0000|
|TimestampNTZType|java.time.LocalDateTime                |TimestampNTZType|                            |


## Work with Unixtime

```scala
import java.time.{Instant, LocalDateTime, ZoneId, ZoneOffset}

def fromUnixTime(u : Int) = {
  LocalDateTime.ofInstant(Instant.ofEpochSecond(u), ZoneOffset.UTC)
}

def fromUnixTimeMs(u: Long) = {
  LocalDateTime.ofInstant(Instant.ofEpochMilli(u), ZoneOffset.UTC)
}
```

### Seconds

|Date               |Int            |
|-------------------|---------------|
|1970-01-01         |0              |
|2023-05-11 02:13:29|1_683_771_209  |
|2038-01-19 03:14:07|Integer.MAX_VAL|


### Milliseconds

|Date                         |Long         |
|-----------------------------|-------------|
|1970-01-01                   |0            |
|+292278994-08-17 07:12:55.807|Long.MAX_VAL |
