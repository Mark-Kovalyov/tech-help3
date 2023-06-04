#include <stdio.h>
#include <math.h>
#include <stdlib.h>

typedef fp1 float;
typedef fp2 double;
typedef fp3 __float80;

int main(int argc, char **argv) {
  double a = atof(argv[1]);
  double b = atof(argv[2]);
  double c = atof(argv[3]);
  double d = b * b - 4 * a * c;
  if (d >= 0.0) {
    double dd = sqrt(d);
    //printf("dd = %f\n", dd);
    double x1 = (-b - dd) / (2.0 * a);
    double x2 = (-b + dd) / (2.0 * a);
    printf("x1 = %f\n", x1);
    printf("x2 = %f\n", x2);
    long double ld1 = 1.0/3.0;
    double d1 = 1.0/3.0;
    float f1 = 1.0/3.0;
    __float80 f80 = 1.0;
    printf("sizeof(long double) = %li, sizeif(double) = %li, sizeof(float) = %li\n", 
	sizeof(ld1), sizeof(d1), sizeof(f1)); 
  } else {
    printf("Complex roots!\n");
  }
}