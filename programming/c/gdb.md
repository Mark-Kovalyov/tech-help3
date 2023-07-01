# GDB

Compile with debug info:
```bash
gcc -g hello.c -o hello -lm
```

## Run 
```
gdb
(gdb) 
(gdb) tui enable
(gdb) layout asm
(gdb) layout reg
(gdb) breakpoint main
(gdb) c ..... // continue
(gdb) ni .... // nexti
```

## Open Dump in GDB

```
gdb -c *.core
```