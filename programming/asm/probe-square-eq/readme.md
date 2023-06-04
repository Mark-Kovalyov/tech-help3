# Square root

## Syscalls table

https://filippo.io/linux-syscall-table/

## Floating point

https://en.wikibooks.org/wiki/X86_Assembly/Floating_Point

https://www.devdungeon.com/content/hello-world-nasm-assembler

http://www.ccfit.nsu.ru/~kireev/lab2/lab2com.htm


## C-lang

```cpp
  double a = atof(argv[0]);
  double b = atof(argv[1]);
  double c = atof(argv[2]);
  double d = b * b - 4 * a * c;
  if (d >= 0.0) {
    double x1 = (-a - sqrt(d)) / 2.0 * a;
    double x2 = (-a + sqrt(d)) / 2.0 * a;
    printf("x1 = %f\n", x1);
    printf("x2 = %f\n", x2);
  } else {
    printf("No roots\n");
  }

```

## NASM (FPU)

* 8 80bit registers ST(0) - ST(7)
* FLD - load real number
* FST - store
* FCOM        COMpare ST(0) to a floating point value
* FCOMI       COMpare ST(0) to ST(i) and set CPU flags
* FSQRT (Square root of ST(0))
* FADD (Add two floating point values)
* FDIV (Divide two floating point values)
* FMUL (Multiply two floating point values)

Check for FPU
```
; after you have verified
; that the cpuid instruction is indeed available:
mov eax, 1     ; argument request feature report
cpuid
xor rax, rax   ; wipe clean accumulator register
bt edx, rax    ; CF  edx[rax]    retrieve bit 0
setc al        ; al  CF
```

```asm

```

## NASM (SSE)

SSE floating point
```
ADDPS, ADDSS, CMPPS, CMPSS, COMISS, CVTPI2PS, CVTPS2PI, CVTSI2SS, 
CVTSS2SI, CVTTPS2PI, CVTTSS2SI, DIVPS, DIVSS, LDMXCSR, MAXPS, 
MAXSS, MINPS, MINSS, MOVAPS, MOVHLPS, MOVHPS, MOVLHPS, MOVLPS, 
MOVMSKPS, MOVNTPS, MOVSS, MOVUPS, MULPS, MULSS, RCPPS, RCPSS, 
RSQRTPS, RSQRTSS, SHUFPS, SQRTPS, SQRTSS, STMXCSR, SUBPS, 
SUBSS, UCOMISS, UNPCKHPS, UNPCKLPS
```

SSE2 FP
```
ADDPD, ADDSD, ANDNPD, ANDPD, CMPPD, CMPSD*, COMISD, CVTDQ2PD, 
CVTDQ2PS, CVTPD2DQ, CVTPD2PI, CVTPD2PS, CVTPI2PD, CVTPS2DQ, 
CVTPS2PD, CVTSD2SI, CVTSD2SS, CVTSI2SD, CVTSS2SD, CVTTPD2DQ, 
CVTTPD2PI, CVTTPS2DQ, CVTTSD2SI, DIVPD, DIVSD, MAXPD, MAXSD, 
MINPD, MINSD, MOVAPD, MOVHPD, MOVLPD, MOVMSKPD, MOVSD*, MOVUPD, 
MULPD, MULSD, ORPD, SHUFPD, SQRTPD, SQRTSD, SUBPD, 
SUBSD, UCOMISD, UNPCKHPD, UNPCKLPD, XORPD
```

