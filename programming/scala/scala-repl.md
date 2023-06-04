# Scala REPL

## Bash maven helper
```
#!/bin/bash -v

artifact() {
    return "~/.m2/repository/$1/$2/$3.jar"
}

echo $(artifact "org.apache.commons" "commons-text" "1.10.0")
```

## Scala repl open jar
```
scala -cp ~/.m2/repository/org/apache/commons/commons-text/1.10.0/commons-text-1.10.0.jar
```

```scala
import org.apache.commons.text.similarity._

val s1 = "the quick brown fox jump over the lazy "
val s2 = "The quick brown fox jumps over lazy Dog"

val ldd = new LevenshteinDetailedDistance()
val res : LevenshteinResults = ldd.apply(s1, s2)
println(res)
```


## Scala help
```
$ scala --help
Usage: scala <options> <source files>
where possible standard options include:
     -Dproperty=value  Pass -Dproperty=value directly to the runtime system.
             -J<flag>  Pass <flag> directly to the runtime system.
                   -P  Pass an option to a plugin, e.g. -P:<plugin>:<opt>
                   -V  Print a synopsis of verbose options.
                   -W  Print a synopsis of warning options.
               -Wconf  Configure compiler warnings.
              -Werror  Fail the compilation if there are any warnings.
                   -X  Print a synopsis of advanced options.
                   -Y  Print a synopsis of private options.
       -bootclasspath  Override location of bootstrap class files.
           -classpath  Specify where to find user class files.
                       Default /usr/lib/jvm/java-11-openjdk-amd64/lib
               -color  Colored output
                       Default always
                       Choices always, never
        -coverage-out  Destination for coverage classfiles and instrumentation data.
                   -d  Destination for generated classfiles.
         -deprecation  Emit warning and location for usages of deprecated APIs.
            -encoding  Specify character encoding used by source files.
                       Default UTF-8
             -explain  Explain errors in more detail.
       -explain-types  Explain type errors in more detail (deprecated, use -explain instead).
             -extdirs  Override location of installed extensions.
             -feature  Emit warning and location for usages of features that should be imported explicitly.
          -from-tasty  Compile classes from tasty files. The arguments are .tasty or .jar files.
                -help  Print a synopsis of standard options.
              -indent  Together with -rewrite, remove {...} syntax when possible due to significant indentation.
 -java-output-version  Compile code with classes specific to the given version of the Java platform available on the classpath and emit bytecode for this version. Corresponds to -release
                       flag in javac.
                       Choices 8, 9, 10, 11
   -javabootclasspath  Override java boot classpath.
         -javaextdirs  Override java extdirs classpath.
            -language  Enable one or more language features.
          -new-syntax  Require `then` and `do` in control expressions.
           -no-indent  Require classical {...} syntax, indentation is not significant.
              -nowarn  Silence all warnings.
          -old-syntax  Require `(...)` around conditions.
           -pagewidth  Set page width
                       Default 188
         -print-lines  Show source code line numbers.
         -print-tasty  Prints the raw tasty.
         -project-url  The source repository of your project.
             -rewrite  When used in conjunction with a `...-migration` source version, rewrites sources to migrate to new version.
             -scalajs  Compile in Scala.js mode (requires scalajs-library.jar on the classpath).
-scalajs-genStaticForwardersForNonTopLevelObjects
                       Generate static forwarders even for non-top-level objects (Scala.js only)
-scalajs-mapSourceURI  rebases source URIs from uri1 to uri2 (or to a relative URI) for source maps (Scala.js only)
   -semanticdb-target  Specify an alternative output directory for SemanticDB files.
              -source  source version
                       Default 3.2
                       Choices 3.0-migration, 3.0, 3.1, 3.2-migration, 3.2, future-migration, future
          -sourcepath  Specify location(s) of source files.
          -sourceroot  Specify workspace root directory.
                       Default .
           -unchecked  Enable additional warnings where generated code depends on assumptions.
              -uniqid  Uniquely tag all identifiers in debugging output.
           -usejavacp  Utilize the java.class.path in classpath resolution.
             -verbose  Output messages about what the compiler is doing.
             -version  Print product version and exit.
              @<file>  A text file containing compiler arguments (options and source files).
```