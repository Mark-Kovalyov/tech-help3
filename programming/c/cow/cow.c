#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>


int main(int argc, char **argv,char *env) {
  printf("Begin\n");
  int res = openat(AT_FDCWD, "/bigdata/video/Hellsing The Dawn/The Dawn I.mkv", O_RDONLY);
  printf("openat res = %d\n", res);
  if (res != 3) {
    fprintf(stderr, "Someghing going wrong during openstat. retcode = %d . Aborted!\n", res);
    return 1;
  }
  struct stat stat1;// = malloc(sizeof(stat));
  stat1.st_mode = S_IFREG|0664;
  stat1.st_size=760;
  //fstat(3, {st_mode=S_IFREG|0664, st_size=760, ...}) = 0
  res = fstat(3, &stat1);
  printf("fstat res = %d\n", res);
  if (res != 0) {
    fprintf(stderr, "Someghing going wrong during fstat. retcode = %d . Aborted!\n", res);
  }
  //openat(AT_FDCWD, "notes.txt.backup", O_WRONLY|O_TRUNC) = 4
  //fstat(4, {st_mode=S_IFREG|0664, st_size=0, ...}) = 0
  //ioctl(4, BTRFS_IOC_CLONE or FICLONE, 3) = 0
  printf("End\n");
  //free(stat1);
  return 0;
}
