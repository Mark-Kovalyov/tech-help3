# Property based testing

```xml
<dependency>
  <groupId>net.jqwik</groupId>
  <artifactId>jqwik</artifactId>
  <version>1.3.6</version>
  <scope>test</scope>
</dependency>

<plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <compilerArgs>
            <arg>-parameters</arg>
        </compilerArgs>
    </configuration>
</plugin>
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.2</version>
    <configuration>
        <includes>
            <include>**/*Properties.java</include>
        </includes>
    </configuration>
</plugin>
```

```java
@PropertyDefaults(tries = 300, afterFailure = AfterFailureMode.PREVIOUS_SEED)
public class NetworkUtilsProperties {

    static Random random = new Random();

    @Property
    @Report(Reporting.GENERATED)
    boolean graphFormulaIsCorrect(@ForAll("RandomIps") String ip) {
        return ip.equals(NetworkUtils.formatIpV4(NetworkUtils.parseIpV4(ip)));
    }

    @Provide("RandomIps")
    Arbitrary<String> randomGraph() {
        return Arbitraries.create(() -> {
            int c1 = random.nextInt(256);
            int c2 = random.nextInt(256);
            int c3 = random.nextInt(256);
            int c4 = random.nextInt(256);
            return String.format("%d.%d.%d.%d", c1,c2,c3,c4);
        });
    }
}
```
