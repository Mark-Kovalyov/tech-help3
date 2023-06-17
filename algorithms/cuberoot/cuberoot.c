#include <stdio.h>
#include <math.h>
#include <stdint.h>


//
// (∛x)' = 1 / 3√x

uint64_t cube_root(uint64_t x) {
  uint64_t xx = x / 3;
  while(1) {
    uint64_t tx = xx * xx * xx;
    if (x > tx) {
      xx--;
    } else {
      xx++;
    }
  }
  return xx;
}

int main() {
    double num = 6.0;
    double cubeRoot = 0.0;
    cubeRoot =  cbrt(num);
    printf("Cube root of %lf =  %lf", num, cubeRoot);

    return 0;
}
