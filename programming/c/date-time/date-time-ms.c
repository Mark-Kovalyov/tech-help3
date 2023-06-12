#include <stdio.h>
#include <sys/time.h>

int main() {
    struct timeval currentTime;
    gettimeofday(&currentTime, NULL);

    // Extract seconds and milliseconds
    long seconds      = currentTime.tv_sec;
    long milliseconds = currentTime.tv_usec / 1000;

    // Convert seconds to a readable format
    struct tm* timeInfo = localtime(&seconds);

    // Print the current time with milliseconds
    printf("%02d:%02d:%02d.%03ld\n",
           timeInfo->tm_hour,
           timeInfo->tm_min,
           timeInfo->tm_sec,
           milliseconds);

    return 0;
}
