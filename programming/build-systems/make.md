# Make

* Build system

## Some example


```
CC=gcc
INCDIRS=-I
OPT=-O0
FLAGS=-Wall -Wextra -g $(INCDIRS) $(OPT)

FILES=x.c y.c
OBJECTS=x.o y.o

BINARY=bin

all: $(BINARY)

$(BINARY): $(OBJECTS)
    $(CC) $(CFLAGS) -c -o $@ $^

go: %.c
    $(CC) -c -o $@ $^


clean:
    rm -fr $(BINARY) $(OBJECTS)
```

## Advanced example

For-style iteration (foreach) and regular expression completetions (wildcard)
```
FLAGS=-Wall -Wextra -g $(foreach D,$(INCDIRS),-I$(D)) $(OPT) $(DEPFLAGS)
```
With regular expressions
```
FILES=$(foreach D,$(CODEDIRS),$(wildcard $(D)/*.c))
```
With rexexp substitution
```
FILES=$(pathsubst %.c,%.h,$(CFILES))
```
