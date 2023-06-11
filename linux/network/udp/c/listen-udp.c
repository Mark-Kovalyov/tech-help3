#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

#define TRANSMISSION_PORT   51413
#define MAX_UDP_PACKET_SIZE 65507

int main() {
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

    while (true) {
        ssize_t recv_len = recvfrom(sockfd, buffer, sizeof(buffer), 0,
                                   (struct sockaddr*)&client_addr, &client_len);
        if (recv_len < 0) {
            perror("Error receiving data");
            exit(1);
        }
        printf("Received: % bytes from UDPi\n", (int)recv_len);
    }

    close(sockfd);

    return 0;
}
