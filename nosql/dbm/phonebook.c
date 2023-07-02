#include <stdio.h>
#include <gdbm.h>
#include <stdio.h>
#include <ndbm.h>


int main() {
  DBM* db;
  datum key, value;
  db = dbm_open("database.db", O_CREAT | O_RDWR, 0666);
  if (!db) {
      printf("Failed to open the database.\n");
      return 1;
  }

  key.dptr = "key";
  key.dsize = sizeof("key");
  value.dptr = "value";
  value.dsize = sizeof("value");
  if (dbm_store(db, key, value, DBM_REPLACE) < 0) {
      printf("Failed to store the data in the database.\n");
      return 1;
  }

  key.dptr = "key";
  key.dsize = sizeof("key");
  value = dbm_fetch(db, key);
  if (value.dptr) {
      printf("Retrieved value: %.*s\n", value.dsize, value.dptr);
  } else {
      printf("Key not found in the database.\n");
  }

  dbm_close(db);


  return 0;

}
