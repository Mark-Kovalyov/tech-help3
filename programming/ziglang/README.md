# Ziglang

See: https://www.youtube.com/watch?v=J6ZxxnSp_fY

## Install
```
$ snap install zig --classic --beta

$ zig version
0.10.1
```

## Project template
```

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

## Error handling
```

```

## This

```

```
