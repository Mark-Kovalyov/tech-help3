# Multithreading in Linux/C

## Mutlithreading quantum time in different platforms and pagesize

|Platform   |Round-Robin Scheduling interval|Page size   |
|-----------|-------------------------------|------------|
|Ubuntu/x64 |0.020 s                        | 4096 bytes
|Windows/x64|?


### Sched RR proof log (Ubuntu/x64)

```
$ uname -a
Linux ryzen-ssd 5.15.0-72-generic #79~20.04.1-Ubuntu SMP Thu Apr 20 22:12:07 UTC 2023 x86_64 x86_64 x86_64 GNU/Linux

$ make
clang demo.c -Wall -fsanitize=memory -o demo
./demo
Current PID: 24597
Sched RR : 0.020000000
```

```
$ getconf PAGE_SIZE
4096
```
