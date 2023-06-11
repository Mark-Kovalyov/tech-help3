# How to represent binary (raw) data:

## Bit Strings and Binaries

* A bit string is used to store an area of untyped memory.
* Are expressed using the bit syntax
* evently divisible by eight, are called binaries:

```
> <<10,20>>.
<<10,20>>

> <<"ABC">>.
<<"ABC">>

> <<1:1,0:1>>.
<<2:2>>
```

### Binary literals

```
<<1, 0, 1, 1>>  % Represents a binary with four bits: 1011
<<16#FF, 16#00, 16#A2>>  % Represents a binary with three bytes: FF00A2
```

### Binary construction

```
binary:binary([1, 0, 1, 1])  % Constructs a binary with four bits: 1011
binary:binary([X || X <- [16#FF, 16#00, 16#A2], X =< 255])  % Constructs a binary with three bytes: FF00A2
```

### File reading
```
{ok, BinaryData} = file:read_file("data.bin"),
```

### Bit Syntax:

Erlang provides a powerful bit syntax for working with binary data, allowing you to pattern match and manipulate binary values.

```
%% Pattern matching on a binary value
<<First:4, Second:4>> = <<11>>,
%% First will be bound to 1 and Second to 1

%% Extracting parts of a binary using the bit syntax
<<Header:8, Rest/binary>> = BinaryData,
%% Header will contain the first byte, and Rest will contain the remaining binary data
```



# How to Use

-module(helloworld).
-export([start/0]).

start() ->
   io:fwrite("~p~n",[<<5,10,20>>]),
   io:fwrite("~p~n",[<<"hello">>]).


# How to use 'bencode' libs

* Carlos Galdino bencode : https://github.com/carlosgaldino/bencode

```erlang
bencode:encode([1, 2, -30]).
<<"li1ei2ei-30ee">>
```
```
bencode:encode(#{"def" => 3, "xyz" => 2, "abc" => 1}).
<<"d3:abci1e3:defi3e3:xyzi2ee">>
```
```
bencode:decode(<<"li1ei2ei3ee">>).
{ok,[1,2,3]}
```
```
bencode:decode(<<"d7:bencode6:decode10:bittorrenti29ee">>).
{ok,#{<<"bencode">> => <<"decode">>,<<"bittorrent">> => 29}}
```

# How to send message to Kafka/MQ systems
