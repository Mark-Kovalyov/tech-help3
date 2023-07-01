#include <quadmath.h>
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char **argv) {

  // Double:
  double x = 2.0;
  double y = 3.0;
  double z = x / y;


  printf("======= Floating point density =======\n");

  printf("sizeof(z) = %lu bytes\n", sizeof(z));
  printf("z = %.20f\n", z);

  // Float : 3.4 * 10^38 ..
  float xx = 2.0;
  float yy = 3.0;
  float zz = xx / yy;

  printf("sizeof(zz) = %lu bytes\n", sizeof(zz));
  printf("zz = %.20f\n", zz);

  __float128 xxx = 2.0;
  __float128 yyy = 3.0;
  __float128 zzz = xxx / yyy;

  char zzz_buf[64];
  printf("sizeof(zzz) = %lu bytes\n", sizeof(zzz));
  quadmath_snprintf(zzz_buf, sizeof(zzz_buf), "%.34Qf", zzz);
  printf("zzz = %s\n", zzz_buf);


  // Light speed   : 299 792 458 m/sec
  // Universe size : 93e12 light years
  // Seconds in year : 365 * 24 * 60 * 60 = 31 536 000  = 31536e3
  // Plank size    : 1.616225e-35 m.

}
