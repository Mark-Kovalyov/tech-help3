# Erlang

* OTP - Framework (Open Telecom Platform)
* Elixir - Erlang based language

## Rebar-3

Rebar3 is an Erlang tool that makes it easy to create, develop,
and release Erlang libraries, applications, and systems in a
repeatable manner.

### install

```
$ wget https://s3.amazonaws.com/rebar3/rebar3 && chmod +x rebar3
```

### New app
```
$ rebar3 new app demo-http
===> The 'name' variable is often associated with Erlang module names and/or file names. The value submitted (demo-http) isn't an unquoted Erlang atom. Templates generated may contain errors.
===> Writing demo-http/src/demo-http_app.erl
....

$ tree
.
├── LICENSE
├── README.md
├── rebar.config
└── src
    ├── demo-http_app.erl
    ├── demo-http.app.src
    └── demo-http_sup.erl

1 directory, 6 files

```
### Shell, Compie, Packages

```
$ rebar3 shell
$ rebar3 compile
$ rebar3 update
$ rebar3 clean
$ rebar3 docs
```

### Unit testing and coverae reps.
```
$ rebar ct
$ rebar enutil
$ rebar cover
```


## Erlang Modules

* io
* gen_udp
* gen_tcp
*

## REPL

```
erl
Erlang/OTP 22 [erts-10.6.4] [source] [64-bit] [smp:12:12] [ds:12:12:10] [async-threads:1]

Eshell V10.6.4  (abort with ^G)
```

## Exit
```

```

## Compile .beam

```
c(Mod).
```

## UDP client-server

Host1
```
Erlang/OTP 22 [erts-10.6.4] [source] [64-bit] [smp:12:12] [ds:12:12:10] [async-threads:1]
Eshell V10.6.4  (abort with ^G)
2> {ok, Socket2} = gen_udp:open(65000,[binary, {active,false}]).
{ok,#Port<0.7>}
3> gen_udp:send(Socket2,{192,168,1,130},65000,"Hello world").
```
Host2
```
2> {ok, Socket2} = gen_udp:open(65000,[binary, {active,false}]).
{ok,#Port<0.7>}
3> gen_udp:recv(Socket2,0).
{ok,{{192,168,1,200},65000,<<"Hello world">>}}
```

## Modules

```
-module(gcdlcm).
-export([gcd/2,lcm/2]).

mod(X,Y) when X > 0 -> X rem Y;
mod(X,Y) when X < 0 -> Y + X rem Y;
mod(0,_) -> 0.

gcd(A,B) when B =/= 0 -> gcd(B,mod(A,B));
gcd(A,_) -> A.

lcm(A,B) -> (A * B) div (gcd(A,B)).
```

## Printing

```
io:fwrite("Hello world!~n", []).


```

## Logging

## Define records

```
-record(vector, {x :: double,
                 y :: double,
                 z :: double}).
```

## Make release


Create a release configuration file, typically named sys.config, which defines the system configuration parameters for your application.
```
rebar3 release
```

## Add dependencies

Add uef:2.6.0

rebar.config
```
{deps, [
    {uef, "2.6.0"}
]
}.

```

## Package manager

https://hex.pm/
