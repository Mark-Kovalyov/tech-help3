# OpenMP

## Links

* https://www.youtube.com/watch?v=pWa7PVxFH8A
* Лекция 9. OpenMP и Intel TBB https://www.youtube.com/watch?v=_MKbLk6K_Tk&t=777s
* Лекция 11. OpenMP, сравнение GPU с CPU (Вычисления на видеокартах) https://www.youtube.com/watch?v=bbaPOhrd4LE


## Install
```bash
apt-get install libomp-dev
```
## Compile
```
g++ -o demo-omp -fopenmp demo-omp.cpp
```

## How Many Threads?
* Use environment variable
  - setenv OMP_NUM_THREADS 8  (Unix machines)
* Use omp_set_num_threads() function
