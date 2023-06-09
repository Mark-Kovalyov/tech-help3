# LLVM

## LLVM-as

```
OVERVIEW: llvm .ll -> .bc assembler

USAGE: llvm-as [options] <input .llvm file>

OPTIONS:

Generic Options:

  --help                        - Display available options (--help-hidden for more)
  --help-list                   - Display list of available options (--help-list-hidden for more)
  --version                     - Display the version of this program

llvm-as Options:

  --data-layout=<layout-string> - data layout string to use
  --disable-output              - Disable output
  -f                            - Enable binary output on terminals
  --module-hash                 - Emit module hash
  -o=<filename>                 - Override output filename

```

## LLVM-dis

```
OVERVIEW: llvm .bc -> .ll disassembler

USAGE: llvm-dis [options] <input bitcode>

OPTIONS:

Color Options:

  --color                                             - Use colors in output (default=autodetect)

General options:

  --aarch64-neon-syntax=<value>                       - Choose style of NEON code to emit from AArch64 backend:
    =generic                                          -   Emit generic NEON assembly
    =apple                                            -   Emit Apple-style NEON assembly
  --amdgpu-disable-loop-alignment                     - Do not align and prefetch loops
  --amdgpu-disable-power-sched                        - Disable scheduling to minimize mAI power bursts
  --amdgpu-dpp-combine                                - Enable DPP combiner
  --amdgpu-dump-hsa-metadata                          - Dump AMDGPU HSA Metadata
  --amdgpu-enable-global-sgpr-addr                    - Enable use of SGPR regs for GLOBAL LOAD/STORE instructions
  --amdgpu-enable-merge-m0                            - Merge and hoist M0 initializations
  --amdgpu-sdwa-peephole                              - Enable SDWA peepholer
  --amdgpu-verify-hsa-metadata                        - Verify AMDGPU HSA Metadata
  --amdgpu-vgpr-index-mode                            - Use GPR indexing mode instead of movrel for vector indexing
  --arm-add-build-attributes                          -
  --arm-implicit-it=<value>                           - Allow conditional instructions outdside of an IT block
    =always                                           -   Accept in both ISAs, emit implicit ITs in Thumb
    =never                                            -   Warn in ARM, reject in Thumb
    =arm                                              -   Accept in ARM, reject in Thumb
    =thumb                                            -   Warn in ARM, emit implicit ITs in Thumb
  --atomic-counter-update-promoted                    - Do counter update using atomic fetch add  for promoted counters only
  --bounds-checking-single-trap                       - Use one trap block per function
  --cost-kind=<value>                                 - Target cost kind
    =throughput                                       -   Reciprocal throughput
    =latency                                          -   Instruction latency
    =code-size                                        -   Code size
  --cvp-dont-add-nowrap-flags                         -
  --debugify-quiet                                    - Suppress verbose debugify output
  --disable-promote-alloca-to-lds                     - Disable promote alloca to LDS
  --disable-promote-alloca-to-vector                  - Disable promote alloca to vector
  --do-counter-promotion                              - Do counter register promotion
  --emscripten-cxx-exceptions-whitelist=<string>      - The list of function names in which Emscripten-style exception handling is enabled (see emscripten EMSCRIPTEN_CATCHING_WHITELIST options)
  --enable-cse-in-irtranslator                        - Should enable CSE in irtranslator
  --enable-cse-in-legalizer                           - Should enable CSE in Legalizer
  --enable-emscripten-cxx-exceptions                  - WebAssembly Emscripten-style exception handling
  --enable-emscripten-sjlj                            - WebAssembly Emscripten-style setjmp/longjmp handling
  --enable-gvn-memdep                                 -
  --enable-load-pre                                   -
  --enable-loop-simplifycfg-term-folding              -
  --enable-name-compression                           - Enable name string compression
  --expensive-combines                                - Enable expensive instruction combines
  -f                                                  - Enable binary output on terminals
  --gpsize=<uint>                                     - Global Pointer Addressing Size.  The default size is 8.
  --hash-based-counter-split                          - Rename counter variable of a comdat function based on cfg hash
  --import-all-index                                  - Import all external functions in index.
  --instcombine-code-sinking                          - Enable code sinking
  --instcombine-guard-widening-window=<uint>          - How wide an instruction window to bypass looking for another guard
  --instcombine-max-iterations=<uint>                 - Limit the maximum number of instruction combining iterations
  --instcombine-max-num-phis=<uint>                   - Maximum number phis to handle in intptr/ptrint folding
  --instcombine-maxarray-size=<uint>                  - Maximum array size considered when doing a combine
  --instrprof-atomic-counter-update-all               - Make all profile counter updates atomic (for testing only)
  --internalize-public-api-file=<filename>            - A file containing list of symbol names to preserve
  --internalize-public-api-list=<list>                - A list of symbol names to preserve
  --iterative-counter-promotion                       - Allow counter promotion across the whole loop nest.
  --lto-embed-bitcode                                 - Embed LLVM bitcode in object files produced by LTO
  --lto-pass-remarks-filter=<regex>                   - Only record optimization remarks from passes whose names match the given regular expression
  --lto-pass-remarks-format=<format>                  - The format used for serializing remarks (default: YAML)
  --lto-pass-remarks-output=<filename>                - Output filename for pass remarks
  --materialize-metadata                              - Load module without materializing metadata, then materialize only the metadata
  --matrix-propagate-shape                            -
  --max-counter-promotions=<int>                      - Max number of allowed counter promotions
  --max-counter-promotions-per-loop=<uint>            - Max number counter promotions per loop to avoid increasing register pressure too much
  --memop-size-large=<uint>                           - Set large value thresthold in memory intrinsic size profiling. Value of 0 disables the large value profiling.
  --memop-size-range=<string>                         - Set the range of size in memory intrinsic calls to be profiled precisely, in a format of <start_val>:<end_val>
  --merror-missing-parenthesis                        - Error for missing parenthesis around predicate registers
  --merror-noncontigious-register                     - Error for register names that aren't contigious
  --mhvx                                              - Enable Hexagon Vector eXtensions
  --mhvx=<value>                                      - Enable Hexagon Vector eXtensions
    =v60                                              -   Build for HVX v60
    =v62                                              -   Build for HVX v62
    =v65                                              -   Build for HVX v65
    =v66                                              -   Build for HVX v66
  --mips-compact-branches=<value>                     - MIPS Specific: Compact branch policy.
    =never                                            -   Do not use compact branches if possible.
    =optimal                                          -   Use compact branches where appropiate (default).
    =always                                           -   Always use compact branches if possible.
  --mips16-constant-islands                           - Enable mips16 constant islands.
  --mips16-hard-float                                 - Enable mips16 hard float.
  --mno-compound                                      - Disable looking for compound instructions for Hexagon
  --mno-fixup                                         - Disable fixing up resolved relocations for Hexagon
  --mno-ldc1-sdc1                                     - Expand double precision loads and stores to their single precision counterparts
  --mno-pairing                                       - Disable looking for duplex instructions for Hexagon
  --mwarn-missing-parenthesis                         - Warn for missing parenthesis around predicate registers
  --mwarn-noncontigious-register                      - Warn for register names that arent contigious
  --mwarn-sign-mismatch                               - Warn for mismatching a signed and unsigned value
  --no-discriminators                                 - Disable generation of discriminator information.
  --nvptx-sched4reg                                   - NVPTX Specific: schedule for register pressue
  -o=<filename>                                       - Override output filename
  --poison-checking-function-local                    - Check that returns are non-poison (for testing)
  --r600-ir-structurize                               - Use StructurizeCFG IR pass
  --rdf-dump                                          -
  --rdf-limit=<uint>                                  -
  --safepoint-ir-verifier-print-only                  -
  --sample-profile-check-record-coverage=<N>          - Emit a warning if less than N% of records in the input profile are matched to the IR.
  --sample-profile-check-sample-coverage=<N>          - Emit a warning if less than N% of samples in the input profile are matched to the IR.
  --sample-profile-max-propagate-iterations=<uint>    - Maximum number of iterations to go through when propagating sample block/edge weights through the CFG.
  --show-annotations                                  - Add informational comments to the .ll file
  --speculative-counter-promotion-max-exiting=<uint>  - The max number of exiting blocks of a loop to allow  speculative counter promotion
  --speculative-counter-promotion-to-loop             - When the option is false, if the target block is in a loop, the promotion will be disallowed unless the promoted counter  update can be further/iteratively promoted into an acyclic  region.
  --summary-file=<string>                             - The summary file to use for function importing.
  --threads=<int>                                     -
  --verify-region-info                                - Verify region info (time consuming)
  --vp-counters-per-site=<number>                     - The average number of profile counters allocated per value profiling site.
  --vp-static-alloc                                   - Do static counter allocation for value profiler
  --x86-align-branch=<(plus separated list of types)> - Specify types of branches to align. The branches's types are combination of jcc, fused, jmp, call, ret, indirect. jcc indicates conditional jumps, fused indicates fused conditional jumps, jmp indicates unconditional jumps, call indicates direct and indirect calls, ret indicates rets, indirect indicates indirect jumps.
  --x86-align-branch-boundary=<uint>                  - Control how the assembler should align branches with NOP. If the boundary's size is not 0, it should be a power of 2 and no less than 32. Branches will be aligned to prevent from being across or against the boundary of specified size. The default value 0 does not align branches.
  --x86-branches-within-32B-boundaries                - Align selected instructions to mitigate negative performance impact of Intel's micro code update for errata skx102.  May break assumptions about labels corresponding to particular instructions, and should be used with caution.

Generic Options:

  --help                                              - Display available options (--help-hidden for more)
  --help-list                                         - Display list of available options (--help-list-hidden for more)
  --version                                           - Display the version of this program
```
