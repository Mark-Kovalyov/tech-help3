dic = {'Jun':'Июнь', 'Jul':'Июль'}

def replace_all(text, dic):
    for key in dic:
        text = text.replace(key, dic[key])
    return text

replace_all("Release planned on 23-Jun-2023", dic)    






# C reverse enginering toolset (Linux)

## Size

```
$ gcc -g0 jagged.c jagged
$
$ 16752 Feb  3 20:10 jagged*
$   223 Jan 26 23:32 jagged.c
$
$ size jagged
   text	   data	    bss	    dec	    hex	filename
   1901	    608	      8	   2517	    9d5	jagged

```

## file
```
$ file jagged
jagged: ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=5f3759f03eb32713f9fbed03f537a8ee46e261ec, for GNU/Linux 3.2.0, not stripped
```

## ldd

Print shared object dependencies
```
$ ldd jagged
	linux-vdso.so.1 (0x00007ffcde380000)
	libc.so.6 => /lib/x86_64-linux-gnu/libc.so.6 (0x00007ff072ebb000)
	/lib64/ld-linux-x86-64.so.2 (0x00007ff0730d1000)
```

## ltrace

A library call tracer.

## Hexdump
```
$ hexdump -C jagged | head
00000000  7f 45 4c 46 02 01 01 00  00 00 00 00 00 00 00 00  |.ELF............|
00000010  03 00 3e 00 01 00 00 00  80 10 00 00 00 00 00 00  |..>.............|
```

## strings

Print the strings of printable characters in files.
```
$ strings jagged
/lib64/ld-linux-x86-64.so.2
libc.so.6
puts
__stack_chk_fail
__cxa_finalize
__libc_start_main
GLIBC_2.4
GLIBC_2.2.5
....
```
## ReadElf
Display information about ELF files.
```
$ readelf -h jagged
ELF Header:
  Magic:   7f 45 4c 46 02 01 01 00 00 00 00 00 00 00 00 00
  Class:                             ELF64
  Data:                              2's complement, little endian
  Version:                           1 (current)
  OS/ABI:                            UNIX - System V
  ABI Version:                       0
  Type:                              DYN (Shared object file)
  Machine:                           Advanced Micro Devices X86-64
  Version:                           0x1
  Entry point address:               0x1080
  Start of program headers:          64 (bytes into file)
  Start of section headers:          14768 (bytes into file)
  Flags:                             0x0
  Size of this header:               64 (bytes)
  Size of program headers:           56 (bytes)
  Number of program headers:         13
  Size of section headers:           64 (bytes)
  Number of section headers:         31
  Section header string table index: 30
```

## ObjDump

Display information from an object file.
```
$ objdump -d jagged | head

jagged:     file format elf64-x86-64


Disassembly of section .init:

0000000000001000 <_init>:
    1000:	f3 0f 1e fa          	endbr64
    1004:	48 83 ec 08          	sub    $0x8,%rsp
    1008:	48 8b 05 d9 2f 00 00 	mov    0x2fd9(%rip),%rax        # 3fe8 <__gmon_start__>
```

# Windows toolset

## wrestool
```
```
