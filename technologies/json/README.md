# JQ

https://stedolan.github.io/jq/manual/

## Examples:

### Parse AWS responce with JQ and regexp expressions

```bash
$ aws cloudformation list-stacks --output json | \
     jq '.StackSummaries[] | select(.StackName|test("acc-lambda-v01"))'
```

## Find CSV files in subfolders with size filtering and sorting

1) Find
```
find . -name *csv -printf "{ size : %s, \"path\" : \"%p\" }\n"
```

2) Do jq
```
| jq ....
```

## The same without JQ

```
find . -type f -printf "%s %p\n" | sort -n
```
