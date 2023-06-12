HOME=~

test:
	gcc -I/($HOME)/include -L/($HOME)/lib -g test-mq.c -o test-mq


test2:
	gcc -g test-mq.c -o test-mq

go: test
	gcc -g listen-udp.c -o listen-udp

prepare:
	apt-get install libcriterion-dev
