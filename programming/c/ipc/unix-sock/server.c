#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/un.h>

#define SOCKET_PATH "/tmp/my_socket"

int main() {
    int server_fd, client_fd;
    struct sockaddr_un server_addr, client_addr;
    socklen_t client_addr_len;
    char buffer[1024];

    // Create a Unix domain socket
    server_fd = socket(AF_UNIX, SOCK_STREAM, 0);
    if (server_fd == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Set up the server address
    memset(&server_addr, 0, sizeof(struct sockaddr_un));
    server_addr.sun_family = AF_UNIX;
    strncpy(server_addr.sun_path, SOCKET_PATH, sizeof(server_addr.sun_path) - 1);

    // Bind the socket to the server address
    if (bind(server_fd, (struct sockaddr*)&server_addr, sizeof(struct sockaddr_un)) == -1) {
        perror("bind");
        exit(EXIT_FAILURE);
    }

    // Listen for incoming connections
    if (listen(server_fd, 5) == -1) {
        perror("listen");
        exit(EXIT_FAILURE);
    }

    printf("Server listening on %s\n", SOCKET_PATH);

    while (1) {
        // Accept a client connection
        client_addr_len = sizeof(struct sockaddr_un);
        client_fd = accept(server_fd, (struct sockaddr*)&client_addr, &client_addr_len);
        if (client_fd == -1) {
            perror("accept");
            exit(EXIT_FAILURE);
        }

        // Read data from the client
        ssize_t num_bytes = read(client_fd, buffer, sizeof(buffer));
        if (num_bytes == -1) {
            perror("read");
            exit(EXIT_FAILURE);
        }

        // Process the received data
        printf("Received data from client: %.*s\n", (int)num_bytes, buffer);

        // Send a response back to the client
        const char* response = "Hello from server!";
        write(client_fd, response, strlen(response));

        // Close the client socket
        close(client_fd);
    }

    // Close the server socket
    close(server_fd);

    // Remove the socket file
    unlink(SOCKET_PATH);

    return 0;
}
