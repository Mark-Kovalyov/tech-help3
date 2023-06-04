# Assembly for raspberry PI

asmtut.s
```asm
.text

.global _start

_start:
  MOV R0, #65
  MOV R7, #1

WI 0
```

```
as -o asmtut.o asmtut.s
ld -o asmtut asmtut.o
./asmtut
echo $?
```
