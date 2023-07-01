# Literate programming

```
gcd.w -> ctangle -> gcd.c -> cc -> gcd (executable)

gcd.w -> cweave -> gcd.tex -> TeX -> gcd.dvi (printable)
```

## Ctagnle/Cwave

```
$ ctangle --help
Usage: ctangle [OPTIONS] WEBFILE[.w] [{CHANGEFILE[.ch]|-} [OUTFILE[.c]]]
  Tangle WEBFILE with CHANGEFILE into a C/C++ program.
  Default CHANGEFILE is /dev/null;
  C output goes to the basename of WEBFILE extended with `.c'
  unless otherwise specified by OUTFILE; in this case, '-' specifies
  a null CHANGEFILE.

+b          print banner line on terminal
+h          print success message on completion
+p          print progress report messages
+/-q        shortcut for '-bhp'; also '--quiet' (default)
+/-v        shortcut for '+bhp'; also '--verbose'
+s          print usage statistics
--help      display this help and exit
--version   output version information and exit
```

```
$ cweave --help
Usage: cweave [OPTIONS] WEBFILE[.w] [{CHANGEFILE[.ch]|-} [OUTFILE[.tex]]]
  Weave WEBFILE with CHANGEFILE into a TeX document.
  Default CHANGEFILE is /dev/null;
  TeX output goes to the basename of WEBFILE extended with `.tex'
  unless otherwise specified by OUTFILE; in this case, '-' specifies
  a null CHANGEFILE.

+b          print banner line on terminal
+h          print success message on completion
+p          print progress report messages
+/-q        shortcut for '-bhp'; also '--quiet' (default)
+/-v        shortcut for '+bhp'; also '--verbose'
-e          do not enclose C material in \PB{...}
-f          do not force a newline after every C statement in output
-i          suppress indentation of parameter declarations
-o          suppress separation of declarations and statements
-x          omit indices, section names, table of contents
+lX         use macros for language X as of Xcwebmac.tex
+s          print usage statistics
--help      display this help and exit
--version   output version information and exit
```