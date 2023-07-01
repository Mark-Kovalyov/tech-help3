# Hibernate WTFs - Alimenkou

* Николай Алименков — Босиком по граблям Hibernate https://www.youtube.com/watch?v=YzOTZTt-PR0

## WTF #1 - Nobody understand how equals and hashcode must looks like

```java
import org.apache.commons.lang3.builder.EqualsBuilder;

@Override
public boolean equals(Object obj) {
  return (this == obj) || (obj instanceof TargetUrl && equalsTo((TargetUrl) obj));
}

private boolean equalsTo(TargetUrl model) {
  EqualsBuilder builder = new EqualsBuilder()
    .append(id, model.id)
    .append(url, model.url)
    .append(type, model.type);
  return builder.isEquals();
}
```

* Comparison context is very important
* Hard to select real "unique business key"
* Performance issues with collections
* Auto-generated fields in Set

## WTF #2 - Mutable objects are evil

* Default constructor must be
* Fields can't be final
* Inconsistent object state is possible
* Reflection

```java
public class LinkedToPageSearchCriteria implements SitePageSearchCriteria {

}
```

## WTF #3 - DTO is evil pattern with Hibernate

* Needs transformers from DTO to Hibernate entities and vice-versa
* Lots of code duplications
* Needs bean-utils, helpers e.t.c.

## WTF #4 - Lazy initialization exception

* Everything is stupidly slow without it
* Nightmare for newcomers
* Almost nobody understand how it works
* Persistent collections are not serializable

## WTF #5 - Criteria API or HQL ?

```java
public SiteProjectStatus getProjectStatus(long projectId) {
  return (SiteProjectStatus) getSession()
          .createCriteria(SiteProject.class)
          .add(Restriction.idEq(projectId))
          .setProjection(Projections.property("status"))
          .uniqueResult();
}

public SiteProjectStatus getProjectStatus(long projectId) {
  return (SiteProjectStatus) getSession()
          .createQuery(
            "select status from SiteProject where id = :projectId")
          .uniqueResult();
}
```

* No need to know SQL? Bullshit!!
* Different features set in HQL and Criteria API
* Hand made query builders in HQL
* No check for NULL in HQL
* Criteria API only for READ

## WTF #6 - To update single field you should read full entity

* Children and large fields are loaded
* Not everybody understand how 'lazy loading' works
* HQL update is not object-oriented
* At least 2 SQL queries for simple update

## WTF #7 - Temporary table usage on update or delete

When entered:
```
delete Human h where h.firstName = 'Steve'
```
Hibernate produces:
```sql
insert into HT HUMAN(ID) select ID human where f_name = 'Steve'
delete human where ID IN (select ID from HT_HUMAN)
```

## WTF #8 - Composite key requres separate class

* Pair, Triple, e.t.c.

## WTF #9 - Entity state can be managed only from one side in parent-child relationship

```xml
<set name="children" inverse="true">
  <key column="parent_id"/>
  <one-to-many class="Child"/>
</set>  
```

```
Parent p = (Parent) session.load(Parent.class, pid);
Child c = new Child();
c.setParent(p);
p.getChildren().add(c);
session.save(c);
session.flush();
```

## WTF #10 - Flush on commit is too unpredictable

* Entity changes are persisted
* Collections operations are 'live'
* Constraints are checked on commit
* No control for SQL queries order

Session flush not embedded in a try{} catch{} block.

Any exception will bypass the do sure of the Hibernate session close and trigger a connection leak.
```java
finally {
  if (session != null) {
    session.flush();
    session.close();
  }
}
```

## WTF #11 - Dirty enter after transaction rollback can't be reused

## WTF #12 - Documentation is simple but primitive

* Only basic samples are covered
* For complex things you need books
* Bug reports are ignored
* Debug hell to understand how things work

## WTF #13 - Hibernate makes developers stupid            
