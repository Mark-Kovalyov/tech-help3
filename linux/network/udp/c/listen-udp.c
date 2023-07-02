#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <time.h>
#include <signal.h>
#include <sys/time.h>

#include "listen-udp.h"

#define MAX_UDP_PACKET_SIZE 65507
#define LINEBUF 65536
#define FLUSH_EVERY 16

int sockfd = 0;

int is_stopped = 0;

void intHandler(int dummy) {
    fflush(stdout);
    fprintf(stderr ,"Interrupt handler!");
    close(sockfd);
    signal(SIGINT, SIG_DFL);
}

void get_current_time_ms(struct current_time_rec *ctr) {
  struct timeval currentTime;
  gettimeofday(&currentTime, NULL);
  long seconds      = currentTime.tv_sec;
  long milliseconds = currentTime.tv_usec / 1000;
  struct tm* timeInfo = localtime(&seconds);
  ctr->year     = timeInfo->tm_year + 1900;
  ctr->month    = timeInfo->tm_mon;
  ctr->day      = timeInfo->tm_mday;
  ctr->hours    = timeInfo->tm_hour;
  ctr->minutes  = timeInfo->tm_min;
  ctr->seconds  = timeInfo->tm_sec;
  ctr->mseconds = milliseconds;
}

int main(int argc, char **argv) {
    if (argc == 1) {
      fprintf(stderr ,"Usage :\n    listen-udp [udp-port]");
      return 1;
    }
    signal(SIGINT, intHandler);
    pid_t pid = getpid();
    fprintf(stderr ,"PID=%d\n", pid);

    struct sockaddr_in server_addr;

    sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd < 0) {
        perror("Error creating socket");
        exit(1);
    }

    int reuse = 1;

    if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &reuse, sizeof(reuse)) < 0) {
        perror("Error setting socket option");
        exit(1);
    }

    server_addr.sin_family      = AF_INET;
    server_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    server_addr.sin_port        = htons(atoi(argv[1]));

    if (bind(sockfd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0) {
        perror("Error binding socket");
        exit(1);
    }

    char udp_buffer[1024];
    struct sockaddr_in client_addr;
    struct sockaddr sock_addr;
    socklen_t client_len;
    char fname[512];

    int cnt = 0;
    while (1) {
        cnt++;

        ssize_t recv_len = recvfrom(sockfd,
                                    udp_buffer,
                                    sizeof(udp_buffer),
                                    0,
                                    &sock_addr,
                                    &client_len);

        if (recv_len < 0) {
            continue;
        }

        time_t rawtime;
        struct tm * timeinfo;
        struct current_time_rec ctr;
        get_current_time_ms(&ctr);

        struct sockaddr_in *p_sockaddr_in = &sock_addr;

        char *ip = inet_ntoa(p_sockaddr_in -> sin_addr);

        printf("%04d-%02d-%02d %02d:%02d:%02d.%03d;%s;%d\n",
          ctr.year,
          ctr.month,
          ctr.day,
          ctr.hours,
          ctr.minutes,
          ctr.seconds,
          ctr.mseconds,
          ip,
          p_sockaddr_in -> sin_port);

        fflush(stdout);
    }

}
