#include <stdio.h>
#include <math.h>
#include <stdlib.h>


int main(int argc, char **argv) {
  double a = atof(argv[1]);
  double b = atof(argv[2]);
  double c = atof(argv[3]);
  double d = b * b - 4 * a * c;
  if (d >= 0.0) {
    double dd = sqrt(d);
    double x1 = (-b - dd) / (2.0 * a);
    double x2 = (-b + dd) / (2.0 * a);
    printf("x1 = %f\n", x1);
    printf("x2 = %f\n", x2);
  } else {
    printf("Complex roots!\n");
  }
}
