#include <stdio.h> 
#include <stdlib.h>
#include <signal.h>

void func_handler(int signum) {
    fprintf(stderr, "Ariphmetic exception handled! Aborted!\n");
    exit(1);
}

int main(int argc, char **argv) {
    signal(SIGFPE, func_handler);
    long x = atol(argv[1]);
    long y = x * x;
    printf("sizeof(long) = %li bytes\n", sizeof(long));
    printf("pow(2,31) - 1 =          2147483647\n");
    printf("pow(2,63) - 1 = 9223372036854775807\n");
    printf("%li\n", x);
    return 0;
}
