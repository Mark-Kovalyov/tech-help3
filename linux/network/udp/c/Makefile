HOME=~


# ./listen-udp 54639 | tee -a /bigdata/udp/udp-54639.csv
# ./listen-udp 55527 | tee -a /bigdata/udp/udp-55527.csv
# ./listen-udp  6771 | tee -a /bigdata/udp/udp-6771.csv


run: compile
	./listen-udp 51413 | tee -a /bigdata/udp/udp-51413.csv

compile:
	gcc -Wno-incompatible-pointer-types -g -std=c99 listen-udp.c -o listen-udp

compile-release:
	gcc -Wno-incompatible-pointer-types -std=c99 listen-udp.c -o listen-udp

saferun: compile
	valgrind --leak-check=yes ./listen-udp
