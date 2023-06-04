# RPM

## QUERYING AND VERIFYING PACKAGES:
```
rpm {-q|--query} [select-options] [query-options]
```


## General Help
```
$ rpm
RPM version 4.14.2.1
Copyright (C) 1998-2002 - Red Hat, Inc.
This program may be freely redistributed under the terms of the GNU GPL

Usage: rpm [-afgpcdLAlsiv?] [-a|--all] [-f|--file] [-g|--group] [-p|--package] [--pkgid] [--hdrid] [--triggeredby]
        [--whatconflicts] [--whatrequires] [--whatobsoletes] [--whatprovides] [--whatrecommends] [--whatsuggests]
        [--whatsupplements] [--whatenhances] [--nomanifest] [-c|--configfiles] [-d|--docfiles] [-L|--licensefiles]
        [-A|--artifactfiles] [--dump] [-l|--list] [--queryformat=QUERYFORMAT] [-s|--state] [--nofiledigest]
        [--nofiles] [--nodeps] [--noscript] [--allfiles] [--allmatches] [--badreloc] [-e|--erase=<package>+]
        [--excludedocs] [--excludepath=<path>] [--force] [--force-debian] [-F|--freshen=<packagefile>+] [-h|--hash]
        [--ignorearch] [--ignoreos] [--ignoresize] [--noverify] [-i|--install] [--justdb] [--nodeps]
        [--nofiledigest] [--nocontexts] [--nocaps] [--noorder] [--noscripts] [--notriggers] [--oldpackage]
        [--percent] [--prefix=<dir>] [--relocate=<old>=<new>] [--replacefiles] [--replacepkgs] [--test]
        [-U|--upgrade=<packagefile>+] [--reinstall=<packagefile>+] [-D|--define='MACRO EXPR'] [--undefine=MACRO]
        [-E|--eval='EXPR'] [--target=CPU-VENDOR-OS] [--macros=<FILE:...>] [--noplugins] [--nodigest] [--nosignature]
        [--rcfile=<FILE:...>] [-r|--root=ROOT] [--dbpath=DIRECTORY] [--querytags] [--showrc] [--quiet] [-v|--verbose]
        [--version] [-?|--help] [--usage] [--scripts] [--setperms] [--setugids] [--setcaps] [--restore]
        [--conflicts] [--obsoletes] [--provides] [--requires] [--recommends] [--suggests] [--supplements]
        [--enhances] [--info] [--changelog] [--changes] [--xml] [--triggers] [--filetriggers] [--last] [--dupes]
        [--filesbypkg] [--fileclass] [--filecolor] [--fileprovide] [--filerequire] [--filecaps]
  ```
