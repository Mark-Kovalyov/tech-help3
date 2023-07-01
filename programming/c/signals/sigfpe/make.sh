#!/bin/bash -v

#gcc gcd.c -o gcd -Wall -Wextra -Woverflow -fsanitize=undefined

#gcc lcm.c -o lcm -Wall -Wextra -Woverflow -fsanitize=undefined

gcc xatol.c -o xatol
gcc gcd.c -o gcd
gcc lcm.c -o lcm

