#include <stdio.h> 
#include <stdlib.h>
#include <signal.h>

void func_handler(int signum) {
    fprintf(stderr, "Ariphmetic exception handled! Aborted!\n");
    exit(1);
}
long gcd(long a,long b){
    if (b!=0) return gcd(b, a % b); else return a;
}

long lcm(long a,long b){
    return labs((a * b)) / gcd(a,b);
}

int main(int argc, char **argv) {
    signal(SIGFPE, func_handler);
    if (argc >= 2) {
        printf("%li\n", lcm(atol(argv[1]), atol(argv[2])));
    } else {
        printf("No arguments\n");
    }
    return 0;
}
