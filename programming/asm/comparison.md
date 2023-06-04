# NASM/FASM/MASM/GAS(as)(Gnu-Assembler)

| Feature    | FASM | NASM | MASM |  GAS(as) |
|------------|------|------|------|----------|
|Intel-style |   +  |   +  |   +  |  AT&T    |
|


## Intel/AT&T

Intel:
```asm
mov eax, 5
mov eax, [ebx + ecx*4 + offset]
```

AT&T
```asm
movl $5, %eax
addl $4, %esp  ; mnemonix suffexes q - for qword, l - for long, w - for word, b - for byte
movl offset(%ebx,%ecx,4), %eax
```