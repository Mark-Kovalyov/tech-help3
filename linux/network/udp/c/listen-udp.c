#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <time.h>

#define TRANSMISSION_PORT   51413
#define MAX_UDP_PACKET_SIZE 65507

FILE *file = NULL;

struct CurrentTimeRec {
   int hours;
   int minutes;
   int seconds;
   int mseconds;
};

void get_current_time_ms(CurrentTimeRec *currentTimeRec) {
  struct timeval currentTime;
  gettimeofday(&currentTime, NULL);
  long seconds      = currentTime.tv_sec;
  long milliseconds = currentTime.tv_usec / 1000;
  struct tm* timeInfo = localtime(&seconds);
  currentTimeRec->hours    = timeInfo->tm_hour;
  currentTimeRec->minutes  = timeInfo->tm_min;
  currentTimeRec->seconds  = timeInfo->tm_src;
  currentTimeRec->mseconds = milliseconds;
}

void intHandler(int dummy) {
    fclose(file);
}

int main() {
    signal(SIGINT, intHandler);
    int sockfd;
    struct sockaddr_in server_addr;


    sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd < 0) {
        perror("Error creating socket");
        exit(1);
    }

    int reuse = 1;
    if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEPORT, &reuse, sizeof(reuse)) < 0) {
        perror("Error setting socket option");
        exit(1);
    }

    server_addr.sin_family      = AF_INET;
    server_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    server_addr.sin_port        = htons(TRANSMISSION_PORT);

    if (bind(sockfd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0) {
        perror("Error binding socket");
        exit(1);
    }

    char buffer[1024];
    struct sockaddr_in client_addr;
    socklen_t client_len;
    char fname[512];
    /////////////////////////////
    time_t rawtime;
    struct tm * timeinfo;

    struct CurrentTimeRec ctr;
    get_current_time_ms(&ctr);

    sprintf(fname, "/bigdata/udp/%d/%d/%d/%d-%d-%d.%d.dat",
      0,
      0,
      0,
      ctr->hours,
      ctr->minutes,
      ctr->seconds,
      ctr->mseconds
    );

    file = fopen(fname, "wb");

    while (1) {
        ssize_t recv_len = recvfrom(sockfd, buffer, sizeof(buffer), 0,
                                   (struct sockaddr*)&client_addr, &client_len);
        time(&rawtime);
        timeinfo = localtime ( &rawtime );
        if (recv_len < 0) {
            perror("Error receiving data");
            exit(1);
        }
        printf("Received: %i bytes from UDP\n", (int)recv_len);
        fwrite(buffer, 1, recv_len, file);
    }

    close(sockfd);

    return 0;
}
