# Android binary files

## Reverse

* Extract .apk (with apk-extractor)
* Get
  * Resource files
  * dex-files
  * manifest
* Extracl .class files (with dex2jar)
* Analyze with JD-GUI (JAD?)

## dex2jar

```
$ git clone https://github.com/pxb1988/dex2jar

$ ./d2j-dex2jar.sh
d2j-dex2jar -- convert dex to jar
usage: d2j-dex2jar [options] <file0> [file1 ... fileN]
options:
 --skip-exceptions            skip-exceptions
 -d,--debug-info              translate debug info
 -e,--exception-file <file>   detail exception file, default is $current_dir/[fi
                              le-name]-error.zip
 -f,--force                   force overwrite
 -h,--help                    Print this help message
 -n,--not-handle-exception    not handle any exceptions thrown by dex2jar
 -nc,--no-code
 -o,--output <out-jar-file>   output .jar file, default is $current_dir/[file-na
                              me]-dex2jar.jar
 -os,--optmize-synchronized   optimize-synchronized
 -p,--print-ir                print ir to System.out
 -r,--reuse-reg               reuse register while generate java .class file
 -s                           same with --topological-sort/-ts
 -ts,--topological-sort       sort block by topological, that will generate more
                               readable code, default enabled
version: reader-2.2-SNAPSHOT, translator-2.2-SNAPSHOT, ir-2.2-SNAPSHOT

```

## extract manifest

### axmlprinter

```
$ git clone https://github.com/rednaga/axmlprinter
$ ./gradlew jar
$ java -jar axmlprinter-0.1.7.jar AndroidManifest.xml > AndroidManifest-decoded.xml
```
