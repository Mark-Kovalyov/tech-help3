# Byacc

```
Usage: byacc [options] filename

Options:
  -b file_prefix        set filename prefix (default "y.")
  -B                    create a backtracking parser
  -d                    write definitions (.tab.h)
  -i                    write interface (y.tab.i)
  -g                    write a graphical description
  -l                    suppress #line directives
  -L                    enable position processing, e.g., "%locations"
  -o output_file        (default ".tab.c")
  -p symbol_prefix      set symbol prefix (default "yy")
  -P                    create a reentrant parser, e.g., "%pure-parser"
  -r                    produce separate code and table files (y.code.c)
  -s                    suppress #define's for quoted names in %token lines
  -t                    add debugging support
  -v                    write description (y.output)
  -V                    show version information and exit
```