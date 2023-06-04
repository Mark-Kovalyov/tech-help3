# Mustache

pom.xml
```xml
<dependency>
  <groupId>com.github.spullara.mustache.java</groupId>
  <artifactId>compiler</artifactId>
  <version>0.9.10</version>
</dependency>
```

template
```
{
  "key" : "{{value}}"
}
```

```java
public static void main(String[] args) throws IOException {
  HashMap<String, Object> scopes = new HashMap<String, Object>();
  scopes.put("name", "Mustache");

  Writer writer = new OutputStreamWriter(System.out);
  MustacheFactory mf = new DefaultMustacheFactory();
  Mustache mustache = mf.compile(new StringReader("{{name}}, {{feature.description}}!"), "example");
  mustache.execute(writer, scopes);
  writer.flush();
}
```
