# JSON-schema generator

* Python:

    https://github.com/gonvaled/jskemator (1 input but allows iteration)
    https://github.com/perenecabuto/json_schema_generator (1 input)
    https://github.com/rnd0101/json_schema_inferencer (1 input I think)
    https://pypi.python.org/pypi/genson/ (multiple inputs)
    https://pypi.python.org/pypi/skinfer (multiple inputs)

* NodeJS:

    https://github.com/Nijikokun/generate-schema (multiple inputs (pass object array))
    https://github.com/easy-json-schema/easy-json-schema (1 input)
    https://github.com/aspecto-io/genson-js (multiple inputs)

* Ruby:

    https://github.com/maxlinc/json-schema-generator (1 input)



```bash
$ pip install genson

$ genson --help

usage: genson [-h] [--version] [-d DELIM] [-e ENCODING] [-i SPACES] [-s SCHEMA] [-$ SCHEMA_URI] ...

Generate one, unified JSON Schema from one or more JSON objects and/or JSON Schemas. Compatible with JSON-Schema Draft 4 and above.

positional arguments:
  object                Files containing JSON objects (defaults to stdin if no arguments are passed).

optional arguments:
  -h, --help            Show this help message and exit.
  --version             Show version number and exit.
  -d DELIM, --delimiter DELIM
                        Set a delimiter. Use this option if the input files contain multiple JSON objects/schemas. You can pass any
                        string. A few cases ('newline', 'tab', 'space') will get converted to a whitespace character. If this option is
                        omitted, the parser will try to auto-detect boundaries.
  -e ENCODING, --encoding ENCODING
                        Use ENCODING instead of the default system encoding when reading files. ENCODING must be a valid codec name or
                        alias.
  -i SPACES, --indent SPACES
                        Pretty-print the output, indenting SPACES spaces.
  -s SCHEMA, --schema SCHEMA
                        File containing a JSON Schema (can be specified multiple times to merge schemas).
  -$ SCHEMA_URI, --schema-uri SCHEMA_URI
                        The value of the '$schema' keyword (defaults to 'http://json-schema.org/schema#' or can be specified in a schema
                        with the -s option). If 'NULL' is passed, the "$schema" keyword will not be included in the result.

```