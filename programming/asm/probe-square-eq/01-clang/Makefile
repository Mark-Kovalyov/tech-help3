compile: clean
	gcc -g 01-square-eq.c -o 01-square-eq -lm

clean:
	rm -f *.exe *.dump

compile_debug:
	gcc -c 01-square-eq.c -g

go: compile
	./01-square-eq 4.0 5.0 -6.0

dump-asm:
	gcc -g -S 01-square-eq.c

dump: clean compile_debug
	objdump -S -l 01-square-eq.o > 01-square-eq.dump
