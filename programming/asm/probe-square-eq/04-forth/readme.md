# Square root on Forth


gforth 

```
gforth --help
Usage: gforth [engine options] ['--'] [image arguments]
Engine Options:
  --appl-image FILE                 Equivalent to '--image-file=FILE --'
  --clear-dictionary                Initialize the dictionary with 0 bytes
  -d SIZE, --data-stack-size=SIZE   Specify data stack size
  --debug                           Print debugging information during startup
  --diag                            Print diagnostic information during startup
  --die-on-signal                   Exit instead of THROWing some signals
  --dynamic                         Use dynamic native code
  -f SIZE, --fp-stack-size=SIZE     Specify floating point stack size
  -h, --help                        Print this message and exit
  --ignore-async-signals            Ignore instead of THROWing async. signals
  -i FILE, --image-file=FILE        Use image FILE instead of `gforth.fi'
  -l SIZE, --locals-stack-size=SIZE Specify locals stack size
  -m SIZE, --dictionary-size=SIZE   Specify Forth dictionary size
  --no-dynamic                      Use only statically compiled primitives
  --no-offset-im                    Load image at normal position
  --no-super                        No dynamically formed superinstructions
  --offset-image                    Load image at a different position
  -p PATH, --path=PATH              Search path for finding image and sources
  --print-metrics                   Print some code generation metrics on exit
  --print-sequences                 Print primitive sequences for optimization
  -r SIZE, --return-stack-size=SIZE Specify return stack size
  --ss-greedy                       Greedy, not optimal superinst selection
  --ss-min-codesize                 Select superinsts for smallest native code
  --ss-min-ls                       Minimize loads and stores
  --ss-min-lsu                      Minimize loads, stores, and pointer updates
  --ss-min-nexts                    Minimize the number of static superinsts
  --ss-number=N                     Use N static superinsts (default max)
  --ss-states=N                     N states for stack caching (default max)
  --tpa-noequiv                     Automaton without state equivalence
  --tpa-noautomaton                 Dynamic programming only
  --tpa-trace                       Report new states etc.
  -v, --version                     Print engine version and exit
  --vm-commit                       Use OS default for memory overcommit
SIZE arguments consist of an integer followed by a unit. The unit can be
  `b' (byte), `e' (element; default), `k' (KB), `M' (MB), `G' (GB) or `T' (TB).
Image Options:
  FILE                              load FILE (with `require')
  -e STRING, --evaluate STRING      interpret STRING (with `EVALUATE')
Report bugs on <https://savannah.gnu.org/bugs/?func=addbug&group=gforth>
```