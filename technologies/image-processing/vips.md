# VIPS

* libvips - fast image processing library with low memory needs.
* https://www.libvips.org/API/current/

## Rotate
```
$ vips rot k2.jpg x.jpg d90
```
## Gamma
```
$ vips gamma k2.jpg x.jpg --exponent 0.42
```


```
Usage:
  vips [OPTION…] [ACTION] [OPTIONS] [PARAMETERS] - VIPS driver program

Help Options:
  -h, --help                    Show help options

Application Options:
  -l, --list=BASE-NAME          list objects
  -p, --plugin=PLUGIN           load PLUGIN
  -v, --version                 print version
  --vips-concurrency=N          evaluate with N concurrent threads
  --vips-progress               show progress feedback
  --vips-leak                   leak-check on exit
  --vips-profile                profile and dump timing on exit
  --vips-disc-threshold=N       images larger than N are decompressed to disc
  --vips-novector               disable vectorised versions of operations
  --vips-cache-max=N            cache at most N operations
  --vips-cache-max-memory=N     cache at most N bytes in memory
  --vips-cache-max-files=N      allow at most N open files
  --vips-cache-trace            trace operation cache
  --vips-cache-dump             dump operation cache on exit
  --vips-version                print libvips version
```
