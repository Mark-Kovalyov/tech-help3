#include <assert.h>
#include <pthread.h>
#include <stdlib.h>

// gcc -std=c99 -Wall -Wextra -pedantic -o main.out ./main.c -pthread ./main.out

enum CONSTANTS {
    NUM_THREADS = 1000,
    NUM_ITERS = 1000
};

int global = 0;

void* main_thread(void *arg) {
    int i;
    for (i = 0; i < NUM_ITERS; ++i) {
        __atomic_fetch_add(&global, 1, __ATOMIC_SEQ_CST);
        /* This fails consistently. */
        /*global++*/;
    }
    return NULL;
}

int main(void) {
    int i;
    pthread_t threads[NUM_THREADS];

    for (i = 0; i < NUM_THREADS; ++i)
        pthread_create(&threads[i], NULL, main_thread, NULL);

    for (i = 0; i < NUM_THREADS; ++i)
        pthread_join(threads[i], NULL);

    assert(global == NUM_THREADS * NUM_ITERS);
    return EXIT_SUCCESS;
}
