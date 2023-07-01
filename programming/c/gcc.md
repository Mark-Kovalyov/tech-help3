# GCC

## External macros
```
#!/bin/bash

cdate=$(date +"%Y-%m-%d")
gcc jagged.c -o jagged -DRUSSIAN_DATE=\"$(cdate)\"
```

```
#include<stdio.h>

int main() {
  printf("%s\n", RUSSIAN_DATE);
  return 0;
}
```