# How to create own man

Create a file for your man page. The file should have the extension ".1" 
and be named after the command or topic you are documenting. For example, 
if you are creating a man page for a command called "mycommand", name the file "mycommand.1".

Open the file in a text editor and format the contents according to the man 
page standard. This includes defining the NAME, SYNOPSIS, DESCRIPTION, OPTIONS, 
EXAMPLES, SEE ALSO, and AUTHOR sections.

Once you have written the contents of the man page, save the file.

Next, you need to generate the man page from the file you just created. You can do this using the "ronn" command. Run the following command:

```bash
ronn mycommand.1
```

This will generate a formatted man page file named "mycommand.1.html".

Finally, you need to install the man page. To do this, copy the generated 
man page file to the appropriate directory in your system. The standard 
location for system-wide man pages is "/usr/share/man/man1/". Use the 
following command to copy the file to that directory:

```
sudo cp mycommand.1.html /usr/share/man/man1/mycommand.1
```

You may need to run 
```
sudo mandb 
```
to update the man page 
database before your new man page will be visible.


## Ronn

```
$ ronn
Usage: ronn <options> <file>...
       ronn -m|--man <file>
       ronn -S|--server <file> ...
       ronn --pipe [<file>...]
Convert ronn source <file>s to roff or HTML manpage. In the first synopsis form,
build HTML and roff output files based on the input file names.

Mode options alter the default behavior of generating files:
      --pipe                write to standard output instead of generating files
  -m, --man                 show manual like with man(1)
  -S, --server              serve <file>s at http://localhost:1207/
      --port <port>         run server at specified port instead of 1207
  -o, --output-dir <dir>    write generated files to specified directory

Format options control which files / formats are generated:
  -r, --roff                generate roff output
  -5, --html                generate entire HTML page with layout
  -f, --fragment            generate HTML fragment
      --markdown            generate post-processed markdown output

Document attributes:
      --date=<date>          published date in YYYY-MM-DD format (bottom-center)
      --manual=<name>        name of the manual (top-center)
      --organization=<name>  publishing group or individual (bottom-left)

Misc options:
  -w, --warnings            show troff warnings on stderr
  -W                        disable previously enabled troff warnings
      --version             show ronn version and exit
      --help                show this help message
```


# Man

```
\input textinfo
@settitle Awesome Manual 1.0



@copying ....
@end copying

@titlepage
@title Createst manual
@vskip 0pt plus
@insertcopying
@end titlepage

@bye
```


```
makeinfo kop.texi
info ./kop.info
```

