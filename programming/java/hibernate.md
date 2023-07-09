# Hibernate 6

* Андрей Беляев — Hibernate 6: что нового и почему это важно  
  https://www.youtube.com/watch?v=4mNDeNR3HsU&t=919s

## News

* Moving on jakarta.*
* New mapping
* Changed generation ID

## Jakarta Persistence 3.0

* javax.persistence -> jakarta.persistence
* JDK = 17
* No so interesting without Spring

## @JdbcTypeCode annotation

```java
class Recipe {
  private String diag;
  private String recommendations;
}
```

```java
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
  @Column(name = "recipe")
  @JdbcTypeCode(SqlTypes.JSON)
  private Recipe recipe;
}
```

## Custom basic types
```java
public class PhoneNum {
  private String countryCode;
  private String number;
}
```
PhoneNumJavaType
* wrap()
* unwrap()

@JavaType

```java
@Entity
@Table(name = "owner")
public class Owner {
  ....
  @JavaType(PhoneNumJavaType.class)
  private PhoneNume phoneNum;
}
```

## Date Mapping

```java
@Entity
@Table(name = "pen")
public class Pet {
  @Column(name = "name")
  private String name;

  @TimeZoneStorage(TimeZoneStorageType.COLUMN)
  @Column(name = "birth.date")
  private ZonedDateTime birthDate;
}
```

* @TimeZoneStorage
  * NATIVE
  * NORMALIZE
  * NORMALIZE_UTC
  * COLUMN

## New ID gen

* StandardNamingStrategy (>=6.0)
  * visits_seq
  * hibernate_sequences

```java
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
  @Id
  @GenerateValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Id
  @GenerateValue(strategy =

}
```

## @UuidGenerator

new
```java
@Id
@UuidGenerator           ?(style = UuidGenerator.Style.TIME)
@GeneratedValue
private UUID id;
```

## LOB mapping

* @JdbcTypeCode
  * LONGVARCHAR
  * LONG32VARCHAR

```java
@JdbcTypeCode(SqlTypes.LONGVARCHAR)
@Column(name = "description")
private String desc;
```

## Non-mandatory Serializable interface

```java
@Embeddable CollarId { // implements Serializable?

}
```

## Multi-Tenancy

* Works for
  * JPQL
  * Criteria
  * Spring Data
* Doesnt Works
  * SQL
  * @OneToMany

```java

@Tenant

```
