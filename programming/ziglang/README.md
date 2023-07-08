# Ziglang

See: https://www.youtube.com/watch?v=J6ZxxnSp_fY

## Install
```
$ sudo snap install zig --classic --beta

$ zig version
0.10.1
```

## Conditional compillation

```
const builtin = @import("builtin")

pub fn main void {

  if (builtin.os = .windows) {

  } else if (builtin.os = .linux) {

  } else {
    @compileError("Uknown")
  }
}
```

## Writing to a file
```
const std = @import("std");
const os = std.os;

pub fn main() !void {
  const fd = try os.posixOpen("file.txt", os.posix.O_CREAT, 0o666);
  try os.posixWrite(fn, "hi");
  os.close();
}
```
### error unwrapping
```
const fd = try os.posixOpen("file.txt", os.posix.O_CREAT, 0o666) catch unreachable;
os.posixWrite(fn, "hi") catch unreachable;
```

## Errdefer
```
const device = try allocator.create(Device);
errdefer allocator.destroy(device);

```

## Project template

Makefile
```
build:
  zig build-exe hello.zig
```

## Hello world
```
const std = @import("std");

pub fn main() !void {
    const stdout = std.io.getStdOut().writer();
    try stdout.print("Hello, {s}!\n", .{"world"});
}
```


## Conditional compillation

```ziglang
const os = enum {
  Windows,
  Linux
}

const myos = os.Linux;

const string = switch (myos) {
  .Linux = "Linux",
  .Windows = "Win",
}
```

## Optional

```
var optional_val: ?u32 = null;

optional_val = 42;

// returns ?u32
var x = some_func();

if (x) |value| {
  // do smth with value
}
```

# Memory allocators

## Simplest allocation strategy - Leverage the OS
```
const PageAllocator = struct {
  pub fn alloc(self: *@This(), size:u32) []u8 {
    const mem = std.os.mmap(
      alignForward(size,page_size)
    ) catch {
      return error.OutOfMemory;
    }
  }
  pub fn free(self: *@This(), mem: []u8) void {
    return std.os.munmap(mem)
  }
}
```

## Simplest allocation implementation - Bump allocator
```
[8|4|32|.................Free...............]
```

## Cache friendly linear memory - Slab allocator
```

```
