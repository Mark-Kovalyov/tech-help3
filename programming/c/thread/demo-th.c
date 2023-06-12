#include <pthread.h>
#include <stdatomic.h>

#define IS_STOPPED  0
#define IS_RUNNED   1

struct RunParam {
   char *arg;
};

atomic_int pool_state;

void intHandler(int dummy) {
    atomic_store(&pool_state, IS_STOPPED);
}

void *thread_function(void *arg) {
    RunParam *rp = (RunParam*)arg;
    while(1) {
      int local_pool_state = atomic_load(&pool_state);
      if (local_pool_state == IS_STOPPED) break;

    }
    pthread_exit(NULL); // Terminate the thread when done
}

int main(int argc, char **argv) {
    signal(SIGINT, intHandler);
    atomic_init(&pool_state, IS_RUNNED);

    pthread_t thread_id;
    int result = pthread_create(&thread_id, NULL, thread_function, arg);
    if (result != 0) {
       // Thread creation failed
       // Handle the error
    }

    int result = pthread_join(thread_id, NULL);
    if (result != 0) {
       // Error occurred while waiting for the thread to finish
       // Handle the error
    }
}
