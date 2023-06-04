# JLex

```
Usage: JLex.Main <filename>
```

## Man
```
NAME
       jlex - lexical analyser generator for Java(tm)

SYNOPSIS
       jlex specfile

DESCRIPTION
       JLex takes the language specification in specfile and generates Java(tm) source code for a lexical analyser corresponding to the specification.

       The  lexical  analyzer  source code is placed in a file whose name is the name of the JLex specification file, with the string ".java" added to the
       end.  For example, if the JLex specification file is called foo.lex, the lexical analyzer source code  file  that  JLex  produces  will  be  called
       foo.lex.java.)

       The resulting lexical analyzer source code should be compiled with a Java compiler.  This produces a lexical analyzer class file, which can then be
       used in your application.  If the default settings have not been changed, the lexical analyzer class will be called Yylex and the class files  will
       named Yylex.class and Yytoken.class.

       For more information, see the JLex manual in /usr/share/doc/jlex/manual.html.

SEE ALSO
       /usr/share/doc/jlex/manual.html, /usr/share/doc/jlex/bugs.html, /usr/share/doc/jlex/README.

DIAGNOSTICS
       jlex produces diagnostic output to inform you of its progress.

BUGS
       See /usr/share/doc/jlex/bugs.html for information about known bugs in JLex.

       Please  report bugs in the Debian version of JLex to the Debian bug tracking system in the first instance.  Otherwise, please contact A. Appel <ap‐
       pel@princeton.edu>.

AUTHOR
       JLex was written by Elliot Joel Berk at Princeton University.  It is now maintained by C. Scott Ananian.

       This manual page was written by Charles Briscoe-Smith <cpbs@debian.org>, modified by Colin Watson <cjwatson@debian.org>, and is hereby  contributed
       to the Public Domain.

       Please see the file /usr/share/doc/jlex/copyright for more information.
