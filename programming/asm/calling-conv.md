# Calling conventions

https://www.youtube.com/watch?v=9lzW0I9_cpY

## __cdecl

* default calling convention for C and C++
* arguments are passed on the stack right to left
* caller is responsible for stack cleanup
* supports vararg

```
int __cdecl main(int argc, const char **argv, const char **envp)

push edi; envp
push esi; argv
push dword prt[eax]; argc
call main
```
