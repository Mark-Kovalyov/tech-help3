# JDBC technologies

## Jdbc type 4 automatic driver selection
```
```


## Hikari connection pool usage
```
    static Logger logger = LoggerFactory.getLogger("demo");

    private HikariConfig hikariConfig = new HikariConfig();

    private HikariDataSource ds;

    private String jdbcUrl  = "jdbc:oracle://127.0.0.1:1551/scott";
    private String username = "scott";
    private String password = "tiger";
    private String driverClassName = "";

    public void init() {
        logger.info("init");

        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);

        hikariConfig.addDataSourceProperty("minimumIdle", 5);
        hikariConfig.addDataSourceProperty("maximumPoolSize", 20);
        hikariConfig.addDataSourceProperty("idleTimeout", 30000);
        hikariConfig.addDataSourceProperty("maxLifetime", 2000000);
        hikariConfig.addDataSourceProperty("connectionTimeout", 30000);
        hikariConfig.addDataSourceProperty("cachePrepStmts", true);
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", 4);
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 4);

        ds = new HikariDataSource(hikariConfig);
    }
```