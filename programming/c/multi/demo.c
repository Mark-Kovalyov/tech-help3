#include <errno.h>
#include <sched.h>
#include <stdio.h>
#include <unistd.h>


// Under Ideone returns:
//  Current PID: 4506
//  Sched RR : 0.020000000

int main(int argc, char **argv) {
    pid_t pid = getpid();
    printf("Current PID: %d\n", pid);
    struct timespec ts;

    int res = sched_rr_get_interval(pid, &ts);

    if (res == 0) {
      printf("Sched RR : %lld.%.9ld", (long long) ts.tv_sec, ts.tv_nsec);
    } else {
      printf("Error during sched_rr_get_interval!\n");
      printf("Error code: %d\n", errno);
    }

    return 0;
}
