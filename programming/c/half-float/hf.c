#include <stdio.h>
#include <stdlib.h>

int main() {
  _Float16 *hfs = malloc(20 * sizeof(_Float16))
  free(hfs);
}
