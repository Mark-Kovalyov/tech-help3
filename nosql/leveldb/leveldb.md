# LevelDb

LevelDB is a fast key-value storage library written 
at Google that provides an ordered mapping from string keys to string values. 

* https://github.com/google/leveldb


## Typical LevelDb file structure:

```
000009.log
000010.ldb
CURRENT
LOCK
MANIFEST-000007
```

## Typical Python use-case:
```python

```

## C-Lang use-case:
```c
#include <leveldb/c.h>
#include <stdio.h>

int main() {
    leveldb_t *db;
    leveldb_options_t *options;
    leveldb_readoptions_t *roptions;
    leveldb_writeoptions_t *woptions;
    char *err = NULL;
    char *read;
    size_t read_len;

    options = leveldb_options_create();
    leveldb_options_set_create_if_missing(options, 1);
    db = leveldb_open(options, "testdb", &err);

    if (err != NULL) {
      fprintf(stderr, "Open fail.\n");
      return(1);
    }

    leveldb_free(err); err = NULL;

    woptions = leveldb_writeoptions_create();
    leveldb_put(db, woptions, "key", 3, "value", 5, &err);

    if (err != NULL) {
      fprintf(stderr, "Write fail.\n");
      return(1);
    }

    leveldb_free(err); err = NULL;

    roptions = leveldb_readoptions_create();
    read = leveldb_get(db, roptions, "key", 3, &read_len, &err);

    if (err != NULL) {
      fprintf(stderr, "Read fail.\n");
      return(1);
    }

    printf("key: %s\n", read);

    leveldb_free(err); err = NULL;

    leveldb_close(db);
```
```bash
gcc -Wall leveldb_example.c -lleveldb
```

## Settings (as of Java-client)

|Name|Default value / enum|Desc|
|-|-|-|
|writeBufferSize|4 << 20|
|blockSize | 4 * 1024|
|blockRestartInterval|16|
|CompressionType| {NONE | SNAPPY}|
|verifyChecksums|true|
|paranoidChecks|?|
|DBComparator|?|
|cacheSize|?|
    
    
