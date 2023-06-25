# Rust

* https://www.rust-lang.org/
* https://crates.io/

## File extensions

* .rs - Rust source code
* .rlib - Library

## Cargo
|Date|Version|
|-|-|
|2022-06-11|cargo 1.57.0|

## Mozilla C/С++/Rust ratio

```
hg clone https://hg.mozilla.org/mozilla-central/ firefox-source
```

|Date|C files|CPP files|Rust files|Ratio by files|
|-|-|-|-|-|
|2022-06-11|4253|8742|9211|0.19 : 0.39 : 0.41|
|2022-06-13|4254|8742|9221|0.19 : 0.39 : 0.42|
|2022-06-28|4255|8740|9236|0.19 : 0.39 : 0.42|

```
find ./ -type f \( -iname \*.rs \)  | wc -l
find ./ -type f \( -iname \*.c \)  | wc -l
find ./ -type f \( -iname \*.cpp \)  | wc -l

val list = List(4253,8742,9211)
list.map(x => x / list.sum.toDouble).map(x => java.lang.String.format("%.02f", x)).mkString(" : ")
0.19 : 0.39 : 0.41
```

## Linux kernel C/С++/Rust ratio

* https://github.com/torvalds/linux.git

|Date|C files|CPP files|Rust files|Ratio by files|
|-|-|-|-|-|
|2022-06-28|31530|7|-|1.0 : 0.0 : 0.0|


## Project template

(bin or lib)
```
cargo new unification --bin
```

## Error handling

This is from standard libraries
```
enum Result<T,E> {
  Ok(T),
  Err(E)
}
```

```
lef res : Result<File,Error> = File::open("/etc/hosts")
let f = match res {
  Ok(file: File) => file,
  Err(error: Error) => panic!("Unable to open file!")
}
```

## Macros

```
name![type; {el, ..., el}, ... , {el, ... , el}]
```
