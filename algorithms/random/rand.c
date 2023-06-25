


int rand(int state) {
  return ((state * 1103515245 + 12345) & 0x7FFFFFFF);
} 