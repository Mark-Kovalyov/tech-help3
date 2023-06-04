# Temp files on Linux system

# CLI
```
NAME
       tempfile - create a temporary file in a safe manner

SYNOPSIS
       tempfile [-d DIR] [-p STRING] [-s STRING] [-m MODE] [-n FILE] 
                [--directory=DIR] [--prefix=STRING] [--suffix=STRING] 
                [--mode=MODE] [--name=FILE] [--help] [--version]
```

## Kernel API
```
NAME
       tmpfile - create a temporary file

SYNOPSIS
       #include <stdio.h>

       FILE *tmpfile(void);

DESCRIPTION
       The tmpfile() function opens a unique temporary file in binary 
       read/write (w+b) mode.  The file will be automatically deleted when it is closed or the program terminates.

RETURN VALUE
       The  tmpfile()  function returns a stream descriptor, or NULL if a unique filename cannot be generated or the unique file cannot be opened.  In the latter case, errno is set to
       indicate the error.
```

### example
```c
#include <stdio.h>

int main() {
    FILE *fp;
    fp = tmpfile();
    if (fp == NULL) {
        printf("Failed to create temporary file.\n");
        return 1;
    }
    // write some data to the temporary file
    fputs("This is a temporary file.", fp);
    // read the data from the temporary file
    rewind(fp);
    char buffer[100];
    fgets(buffer, sizeof(buffer), fp);
    printf("Temporary file contains: %s\n", buffer);
    // close and delete the temporary file
    fclose(fp);
    return 0;
}

```