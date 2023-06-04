#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

#define BUFS 4096
#define MAX_PATH 65535

int main(int args, char **argv) {
  if (args <= 1) {
    fprintf(stderr, "Peek input file name as 1st arg!\n");
    return 1;
  }
  char *src_name = argv[1];
  uint8_t *buf = (uint8_t*)malloc(BUFS);
  char *tpath = (char*)malloc(MAX_PATH);
  strcpy(tpath,src_name);
  FILE *dest = fopen(strcat(tpath, ".tmp"), "wb");
  FILE *src  = fopen(src_name, "rb");
  if (src == NULL) {
    fprintf(stderr, "Unable to open %s!\n", src_name);
    return 1;
  }
  int size = 0;
  while((size = fread(buf, 1, BUFS, src)) > 0) {    
    for(int i = 0; i < size ; i++) {
      int c = buf[i];
      if (c != 0x0D) fputc(c, dest);
    }
  }
  fclose(dest);
  fclose(src);

  remove(src_name);

  int status = rename(tpath, src_name);
  if (status != 0) {
    printf("Unable to renam from %s to %s!\n", tpath, src_name);
    return 1;
  }

  free(buf);
  free(tpath);
  return 0;
}
