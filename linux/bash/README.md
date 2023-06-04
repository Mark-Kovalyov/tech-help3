# Bash

## Bzip2 all csv files in current folder:

```
for f in *.csv; do bzip2 $f; done
```

## Execute CLI for each file

case1
```
find . -name '*.txt' -exec process {} \;
```



## Loop for list of Numbers (from 7 to 21)

```
for i in `seq 7 21`
do
  echo "--------------- $i ---------------------"
done
```

## The same loop with zero-padding
```
for i in $(seq -f "%03g" 98 103)
do
  echo "--------------- $i ---------------------"
done
--------------- 098 ---------------------
--------------- 099 ---------------------
--------------- 100 ---------------------
--------------- 101 ---------------------
--------------- 102 ---------------------
--------------- 103 ---------------------
```

## Loop for list of words
```

```

## Read STDIN from string

Case-1
```
cat <<< "This is coming from the stdin"
```
Case-2
```
cat <<EOF
This is coming from the stdin
EOF
```

## Iterate over STDIN lines
```
#!/bin/bash

while read line; do
    # do something with $line
    echo "$line"
done

```
```
while read -r line; do
  echo "$line"
  echo "What do you think?"
  read -r answer < /dev/tty
done
```

## Hashmaps

```
#!/bin/bash -v

animals=( ["moo"]="cow" ["woof"]="dog")

echo "Who says moo  = ${animals['moo']}"
echo "Who says woof = ${animals['woof']}"
```

## Find files withoud hidden folders belongs
```
find . -not -path '*/.*' -type f
```

## Transcode all Windows text files into Linux
```
find . -not -path '*/.*' -type f -exec win2lin {} \;
```
## Remove all binary files from git repo
```
find . -not -path '*/.*' -type f -name '*.o' -exec git rm -f {} \;
```

## Preview non-text files to before git commit

```
git status |   grep -v -F "deleted:"  |   grep -v -E "(Makefile|Dockerfile)" |   grep -v -E '.(md|hs|go|java|scala|py|h|nim|xml|json|proto|properties|txt|c|cpp|f|scm|thrift|sbt|sh|puml|asm|erl|zig|yaml|yml|gradle|bat|rs|cfg|graphml|dot|scheme|lisp|svg|rb|xhtml)$'
```
