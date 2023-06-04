#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/un.h>

#define SOCKET_PATH "/tmp/my_socket"

int main() {
    int client_fd;
    struct sockaddr_un server_addr;
    char buffer[1024];

    // Create a Unix domain socket
    client_fd = socket(AF_UNIX, SOCK_STREAM, 0);
    if (client_fd == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Set up the server address
    memset(&server_addr, 0, sizeof(struct sockaddr_un));
    server_addr.sun_family = AF_UNIX;
    strncpy(server_addr.sun_path, SOCKET_PATH, sizeof(server_addr.sun_path) - 1);

    // Connect to the server
    if (connect(client_fd, (struct sockaddr*)&server_addr, sizeof(struct sockaddr_un)) == -1) {
        perror("connect");
        exit(EXIT_FAILURE);
    }

    // Send data to the server
    const char* message = "Hello from client!";
    write(client_fd, message, strlen(message));

    // Receive response from the server
    ssize_t num_bytes = read(client_fd, buffer, sizeof(buffer));
    if (num_bytes == -1) {
        perror("read");
        exit(EXIT_FAILURE);
    }

    // Process the received data
    printf("Received response from server: %.*s\n", (int)num_bytes, buffer);

    // Close the client socket
    close(client_fd);

    return 0;
}
