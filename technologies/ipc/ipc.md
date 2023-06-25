# IPC technologies

* Unix Domain Socket
  * SOCK_STREAM 
  * SOCK_DGRAM
  * SOCK_SEQPACKET

* Network socket
  * Datagram sockets (UDP)
  * Stream sockets (TCP/SCTP)
  * RAW sockets

* PIPELINE
  * anonymous 
    * pipe()
  * named pipes
    * mkfifo()
    * mknod()

## Sample with named pipes

$ mkfifo mypipe
$ cat < mypipe
$ cat > mypipe
$ rm mypipe

```c
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main()
{
    int result = mkfifo("mypipe", 0666);
    if (result == -1) {
        perror("mkfifo");
        exit(EXIT_FAILURE);
    }
    return 0;
}

```


```
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
    int fd = open("mypipe", O_RDONLY);
    if (fd == -1) {
        perror("open");
        exit(EXIT_FAILURE);
    }

    char buffer[1024];
    int nbytes = read(fd, buffer, sizeof(buffer));
    printf("Received: %.*s\n", nbytes, buffer);

    close(fd);
    return 0;
}
```

```
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
    int fd = open("mypipe", O_WRONLY);
    if (fd == -1) {
        perror("open");
        exit(EXIT_FAILURE);
    }

    char* message = "Hello, world!\n";
    int nbytes = write(fd, message, strlen(message));
    printf("Sent %d bytes: %s", nbytes, message);

    close(fd);
    return 0;
}
```

```
$ gcc reader.c -o reader
$ gcc writer.c -o writer
$ ./reader &
$ ./writer
```