# Linux IPC types (witch allows data tranfer)

## Top

* Pipes: Pipes are one of the simplest forms of IPC. They allow unidirectional communication between two related processes, where the output of one process becomes the input of another.

* Named Pipes (FIFOs): Named pipes, also known as FIFOs (First-In, First-Out), are similar to pipes but have a name associated with them. They allow inter-process communication between unrelated processes, both locally and over a network.

* Shared Memory: Shared memory allows multiple processes to access a common memory segment. It provides a fast and efficient way to exchange large amounts of data between processes, as they can read and write to the shared memory directly.

* Sockets: Sockets are a powerful IPC mechanism used for communication between processes, both on the same machine and over a network. They provide a bidirectional, reliable, and full-duplex communication channel. Sockets can be implemented using various protocols such as TCP/IP, UDP, and Unix domain sockets.

  * Unix Sockets
    ```
    #define SOCKET_PATH "/tmp/my_socket"
    ...
    socket(AF_UNIX, SOCK_STREAM, 0)
    ...
    connect(client_fd, (struct sockaddr*)&server_addr, sizeof(struct sockaddr_un))
    ```


## High level stack? Or just for signals and locks?

* Message Queues: Message queues provide a mechanism for processes to exchange structured messages. Messages are stored in queues and can be read by other processes in a specified order. They offer more flexibility than pipes in terms of message size and the ability to access messages asynchronously.

* Semaphores: Semaphores are synchronization primitives used to control access to shared resources. They allow processes to coordinate their actions and prevent race conditions. Semaphores can be used to implement critical sections, mutual exclusion, and inter-process synchronization.

* Signals: Signals are software interrupts used to notify a process about an event. They are primarily used for process management and communication between processes. Common signals include SIGKILL, SIGTERM, and SIGUSR1.

* RPC (Remote Procedure Call): RPC is a higher-level IPC mechanism that allows processes on different machines to call procedures or functions in a manner similar to local function calls. It abstracts the network communication details and provides a transparent way for distributed processes to communicate.
