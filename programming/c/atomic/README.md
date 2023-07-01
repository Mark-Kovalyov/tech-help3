# Threads

Creation
```c++
#include <pthread.h>
int pthread_create(
 pthread_t *thread_id,   
 const pthread_attr_t *attribute,  
 void *(*thread_function)(void *),void *arg);
```
Termination
```c++
void pthread_exit(void *status)
```
Joining
```c++
int pthread_join(
 pthread_t thread_id,  
 void **status);
```

## ForkJoin (optionally with divide-and-conquer algorithm)

```c++
void DivideAndConquer(Problem P) {
  if (P_is_base_case()) {
    solve(P);
  } else {
    // divide p into k subproblems
    // fork to conquer each subproblem in parallel
    // join
    // combine results into final solution
  }
}
```
## TBB and Cilk Plus

* use work stealing to automatically balance fork-join work

## OpenMP

```c++
#pragma omp task
B();
C();
#pragma omp taskwait
```

## Spinlock

```
xchg ...
```

## Windows Spinlock

1) Works as spinlock
2) Becomes to be a mutex after some N spins

## Pentium 4 rep nop

```
0xf3 0x90
```

## Some Links

* Intel Cilk http://?
* oneAPI Threading Building Blocks (oneTBB) https://en.wikipedia.org/wiki/Threading_Building_Blocks
* OpenMP
