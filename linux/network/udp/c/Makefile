install:
	cp -f listen-udp ~/bin/listen-udp

compile:
	gcc -Wno-incompatible-pointer-types -g -std=c99 listen-udp.c -o listen-udp

compile-release:
	gcc -Wno-incompatible-pointer-types -std=c99 listen-udp.c -o listen-udp

saferun: compile
	valgrind --leak-check=yes ./listen-udp
