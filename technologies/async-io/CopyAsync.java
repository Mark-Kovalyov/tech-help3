# Java & Async IO


## Java
```xml
<dependency>
    <groupId>com.github.javasync</groupId>
    <artifactId>RxIo</artifactId>
    <version>1.2.5</version>
</dependency>
```

```java
Path in = Paths.get("input.txt");
Path out = Paths.get("output.txt");
AsyncFiles
      .readAllBytes(in)
      .thenCompose(bytes -> AsyncFiles.writeBytes(out, bytes))
      .thenAccept(index -> /* invoked on completion */)
```
