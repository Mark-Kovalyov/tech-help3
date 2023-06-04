# Dbase + FoxPro + e.t.c


```
$ dbfcreate
dbfcreate xbase_file [[-s field_name width],[-n field_name width decimals]]...
```

```
dbfcreate scott.dbf -n id 10 0 -s name 30
```

```
NAME
       dbfinfo - Displays basic information for a given xBase file

SYNOPSIS
       dbfinfo xbase_file

DESCRIPTION
       Displays basic information for a given xBase file, like number of columns, number of records and type of each column.

OPTIONS
       xbase_file
              The name of an existing xBase file.

EXAMPLE
       dbfinfo testbase

           Info for testbase.dbf
           3 Columns,  1 Records in file
                      NAME          string  (20,0)
                      AREA           float  (9,3)
                     VALUE           float  (9,2)
```

```
$ dbfcat --help
dbfcat [-v] [-f] from_DBFfile to_DBFfile
```

```
$ dbfdump
dbfdump [-h] [-r] [-m] xbase_file
        -h: Write header info (field descriptions)
        -r: Write raw field info, numeric values not reformatted
        -m: Multiline, one line per field.
```
