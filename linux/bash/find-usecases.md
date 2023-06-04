# Find usecases

## Find specific c header files with directories exlcusion:
```
$ find / -not -path "/mnt/c" -name "stdlib.h" 2>/dev/null

/usr/include/bsd/stdlib.h
/usr/include/c++/9/stdlib.h
/usr/include/c++/9/tr1/stdlib.h
/usr/include/stdlib.h
/usr/include/x86_64-linux-gnu/bits/stdlib.h
```
