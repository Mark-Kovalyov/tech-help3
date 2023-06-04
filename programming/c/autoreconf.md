# Autoreconf

```
Usage: /usr/bin/autoreconf [OPTION]... [DIRECTORY]...

Run `autoconf' (and `autoheader', `aclocal', `automake', `autopoint'
(formerly `gettextize'), and `libtoolize' where appropriate)
repeatedly to remake the GNU Build System files in specified
DIRECTORIES and their subdirectories (defaulting to `.').

By default, it only remakes those files that are older than their
sources.  If you install new versions of the GNU Build System,
you can make `autoreconf' remake all of the files by giving it the
`--force' option.

Operation modes:
  -h, --help               print this help, then exit
  -V, --version            print version number, then exit
  -v, --verbose            verbosely report processing
  -d, --debug              don't remove temporary files
  -f, --force              consider all files obsolete
  -i, --install            copy missing auxiliary files
      --no-recursive       don't rebuild sub-packages
  -s, --symlink            with -i, install symbolic links instead of copies
  -m, --make               when applicable, re-run ./configure && make
  -W, --warnings=CATEGORY  report the warnings falling in CATEGORY [syntax]

Warning categories include:
  `cross'         cross compilation issues
  `gnu'           GNU coding standards (default in gnu and gnits modes)
  `obsolete'      obsolete features or constructions
  `override'      user redefinitions of Automake rules or variables
  `portability'   portability issues (default in gnu and gnits modes)
  `syntax'        dubious syntactic constructs (default)
  `unsupported'   unsupported or incomplete features (default)
  `all'           all the warnings
  `no-CATEGORY'   turn off warnings in CATEGORY
  `none'          turn off all the warnings
  `error'         treat warnings as errors

The environment variable `WARNINGS' is honored.  Some subtools might
support other warning types, using `all' is encouraged.

Library directories:
  -B, --prepend-include=DIR  prepend directory DIR to search path
  -I, --include=DIR          append directory DIR to search path

The environment variables AUTOM4TE, AUTOCONF, AUTOHEADER, AUTOMAKE,
ACLOCAL, AUTOPOINT, LIBTOOLIZE, M4, and MAKE are honored.

Report bugs to <bug-autoconf@gnu.org>.
GNU Autoconf home page: <http://www.gnu.org/software/autoconf/>.
General help using GNU software: <http://www.gnu.org/gethelp/>.
```