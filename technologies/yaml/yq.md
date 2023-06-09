# YAML

## YQ
```
$ yq
Usage:
  yq [flags]
  yq [command]

Examples:

# yq defaults to 'eval' command if no command is specified. See "yq eval --help" for more examples.

# read the "stuff" node from "myfile.yml"
yq '.stuff' < myfile.yml

# update myfile.yml in place
yq -i '.stuff = "foo"' myfile.yml

# print contents of sample.json as idiomatic YAML
yq -P sample.json


Available Commands:
  completion       Generate the autocompletion script for the specified shell
  eval             (default) Apply the expression to each document in each yaml file in sequence
  eval-all         Loads _all_ yaml documents of _all_ yaml files and runs expression once
  help             Help about any command
  shell-completion Generate completion script

Flags:
  -C, --colors                        force print with colors
  -e, --exit-status                   set exit status if there are no matches or null or false is returned
      --expression string             forcibly set the expression argument. Useful when yq argument detection thinks your expression is a file.
      --from-file string              Load expression from specified file.
  -f, --front-matter string           (extract|process) first input as yaml front-matter. Extract will pull out the yaml content, process will run the expression against the yaml content, leaving the remaining data intact
      --header-preprocess             Slurp any header comments and separators before processing expression. (default true)
  -h, --help                          help for yq
  -I, --indent int                    sets indent level for output (default 2)
  -i, --inplace                       update the file inplace of first file given.
  -p, --input-format string           [yaml|y|props|p|xml|x] parse format for input. Note that json is a subset of yaml. (default "yaml")
  -M, --no-colors                     force print with no colors
  -N, --no-doc                        Don't print document separators (---)
  -n, --null-input                    Don't read input, simply evaluate the expression given. Useful for creating docs from scratch.
  -o, --output-format string          [yaml|y|json|j|props|p|xml|x] output format type. (default "yaml")
  -P, --prettyPrint                   pretty print, shorthand for '... style = ""'
  -s, --split-exp string              print each result (or doc) into a file named (exp). [exp] argument must return a string. You can use $index in the expression as the result counter.
      --split-exp-file string         Use a file to specify the split-exp expression.
  -r, --unwrapScalar                  unwrap scalar, print the value with no quotes, colors or comments. Defaults to true for yaml (default true)
  -v, --verbose                       verbose mode
  -V, --version                       Print version information and quit
      --xml-attribute-prefix string   prefix for xml attributes (default "+@")
      --xml-content-name string       name for xml content (if no attribute name is present). (default "+content")
      --xml-directive-name string     name for xml directives (e.g. <!DOCTYPE thing cat>) (default "+directive")
      --xml-keep-namespace            enables keeping namespace after parsing attributes (default true)
      --xml-proc-inst-prefix string   prefix for xml processing instructions (e.g. <?xml version="1"?>) (default "+p_")
      --xml-raw-token                 enables using RawToken method instead Token. Commonly disables namespace translations. See https://pkg.go.dev/encoding/xml#Decoder.RawToken for details. (default true)
      --xml-skip-directives           skip over directives (e.g. <!DOCTYPE thing cat>)
      --xml-skip-proc-inst            skip over process instructions (e.g. <?xml version="1"?>)
      --xml-strict-mode               enables strict parsing of XML. See https://pkg.go.dev/encoding/xml for more details.

Use "yq [command] --help" for more information about a command.
```
