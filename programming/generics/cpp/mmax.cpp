#include <iostream>
#include <stdio.h>

using namespace std;

template<typename T> T mmax(T x, T y) {
  return x > y ? x : y;
}


int main(int argc, char **argv) {

  printf("max(%d,%d) = %d\n", 2, 3, mmax(2,3));

  printf("max(%f,%f) = %f\n", 3.0, 4.0, mmax(3.0,4.0));
}
