fpu: fpu_build
	ld square-eq-fpu.o -o square-eq-fpu

fpu_build: clean
	nasm -O0 -g -felf64 square-eq-fpu.asm -o square-eq-fpu.o

clean:
	rm -f *.o square-eq-fpu

