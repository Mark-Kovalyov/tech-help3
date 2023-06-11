-module(udp_server).
-export([start/1]).
-import(bencode([encode/1,decode/1])).

-include("amqp_client.hrl").

sendmessage(msg) -> 
    io:format("...").

start(Port) ->

    {ok, Socket}     = gen_udp:open(Port, [binary, {active, true}]),

    application:ensure_started(amqp_client),
    {ok, Connection} = amqp_connection:start(#amqp_params_network{}),
    loop(Socket).

loop(Socket) ->
    receive
        {udp, Socket, IP, InPort, Packet} ->
            % Process the received UDP packet
            % io:format("Received packet from ~p:~p~n", [IP, InPort]),
            % io:format("Packet: ~p~n", [Packet]),
            {Status, Payload} = bencode:decode(Packet).
            Result = case {Status, Payload} of
              Pattern1 [when Guard1] -> sendmessage;
            end.
            loop(Socket);
        {udp_closed, Socket} ->
            % Handle socket closure
            io:format("Socket closed.~n");
        Other ->
            io:format("Unknown message: ~p~n", [Other]),
            loop(Socket)
    end.
