# Update-alternatives

```
$ update-alternatives
update-alternatives: need --display, --query, --list, --get-selections, --config, --set, --set-selections, --install, --remove, --all, --remove-all or --auto

Use 'update-alternatives --help' for program usage information.
```

## Example for GCC

under sudo
```
$ update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-9 90
$ update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-10 10
$ update-alternatives --query gcc

$ update-alternatives --config gcc


Selection Path            Priority Status
--------------------------------------------
* 0       /usr/bin/gcc-9  90       Auto mode
  1       /usr/bin/gcc-10 10       manual mode
  2       /usr/bin/gcc-9  90       manual mode
```


## Detailed help
```
Usage: update-alternatives [<option> ...] <command>

Commands:
  --install <link> <name> <path> <priority>
    [--slave <link> <name> <path>] ...
                           add a group of alternatives to the system.
  --remove <name> <path>   remove <path> from the <name> group alternative.
  --remove-all <name>      remove <name> group from the alternatives system.
  --auto <name>            switch the master link <name> to automatic mode.
  --display <name>         display information about the <name> group.
  --query <name>           machine parseable version of --display <name>.
  --list <name>            display all targets of the <name> group.
  --get-selections         list master alternative names and their status.
  --set-selections         read alternative status from standard input.
  --config <name>          show alternatives for the <name> group and ask the
                           user to select which one to use.
  --set <name> <path>      set <path> as alternative for <name>.
  --all                    call --config on all alternatives.

<link> is the symlink pointing to /etc/alternatives/<name>.
  (e.g. /usr/bin/pager)
<name> is the master name for this link group.
  (e.g. pager)
<path> is the location of one of the alternative target files.
  (e.g. /usr/bin/less)
<priority> is an integer; options with higher numbers have higher priority in
  automatic mode.

Options:
  --altdir <directory>     change the alternatives directory.
  --admindir <directory>   change the administrative directory.
  --log <file>             change the log file.
  --force                  allow replacing files with alternative links.
  --skip-auto              skip prompt for alternatives correctly configured
                           in automatic mode (relevant for --config only)
  --quiet                  quiet operation, minimal output.
  --verbose                verbose operation, more output.
  --debug                  debug output, way more output.
  --help                   show this help message.
  --version                show the version.
```
