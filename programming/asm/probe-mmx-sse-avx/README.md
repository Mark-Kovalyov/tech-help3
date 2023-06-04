# MMX/SSE/AVX, OpenMP, e.t.c. performance notes

## Detect AVX

See https://habr.com/ru/post/99367/

```
; extern "C" int isAvxSupported()
_isAvxSupported:
    xor eax, eax
    cpuid
    cmp eax, 1 ; ������������ �� CPUID �������� eax = 1?
    jb not_supported
    mov eax, 1
    cpuid
    and ecx, 018000000h ; ���������, ��� ����������� ���� 27 (�� ���������� XSAVE/XRSTOR)
    cmp ecx, 018000000h ; � 28 (��������� AVX �����������)
    jne not_supported
    xor ecx, ecx ; ����� �������� XFEATURE_ENABLED_MASK/XCR0 ���� 0
    xgetbv ; ������� XFEATURE_ENABLED_MASK ������ � edx:eax
    and eax, 110b
    cmp eax, 110b ; ����������, ��� �� ��������� AVX �������� ��� ������������ ���������
    jne not_supported
    mov eax, 1
    ret
not_supported:
    xor eax, eax
    ret
```

## Detect MMX

## Detect SSE

See https://stackoverflow.com/questions/4203235/how-to-test-if-your-linux-support-sse2

```
enter code here
static
bool HaveSSE2()
{
    return false;
    __asm mov EAX,1              ;
    __asm cpuid                  ;
    __asm test EDX, 4000000h     ;test whether bit 26 is set
    __asm jnz yes                ;yes
    return false;
yes:
    return true;
}
```

## Pagesize

```
int getpagesize(void);
```

## OpenMP

```
#include <omp.h>
#include <stdio.h>
int main(int argc, char *argv[]){
   /* sequential code */
   #pragma omp parallel{
      printf("I am a parallel region.");
   }
   /* sequential code */
   return 0;
}
```

```
int64_t diamond(const int *matrix, const size_t dim)
{
  int64_t sum = 0;

  const size_t m = dim >> 1;
  auto const middl_row = matrix + dim * m;

#pragma omp parallel reduction(+: sum)
  {
  #pragma omp for
    for (size_t row_idx = 0; row_idx < m; row_idx++)
    {
      register size_t tmp = row_idx << 1;

      const size_t
          cnt_upper = tmp + 1,
          cnt_lower = dim - tmp;

      tmp = dim * row_idx;

      auto
          *p_upper = matrix + tmp + m - row_idx,
          *p_lower = middl_row + tmp + row_idx;

    #pragma omp parallel reduction (+: sum)
      {
      #pragma omp for
        for (auto *p = p_upper; p < p_upper + cnt_upper; p++)
          sum += *p;

      #pragma omp for
        for (auto *p = p_lower; p < p_lower + cnt_lower; p++)
          sum += *p;
      } // #pragma omp parallel reduction(+: sum)
    }
  } // #pragma omp parallel reduction(+: sum)
  sum += *(matrix + dim * (dim - 1) + m);
  return sum;
}
```
