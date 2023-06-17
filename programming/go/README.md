# GO

* https://go.dev/

```
$ sudo apt install golang
$ go version
go version go1.18.1 linux/amd64
```

## Create project
```
$ go mod init example/hello
```

## Download package

```

```

## Async/await

```
static async Task Main(string[] args) {
    Console.WriteLine("Let's start ...");
    var done = DoneAsync();
    Console.WriteLine("Done is running ...");
    Console.WriteLine(await done);
}

static async Task<int> DoneAsync() {
    Console.WriteLine("Warming up ...");
    await Task.Delay(3000);
    Console.WriteLine("Done ...");
    return 1;
}
```

## Goroutines and Channels

* goroutine - type of light-weight process

```

```
