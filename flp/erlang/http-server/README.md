# Erlang - Http server

## Static content
```
{ok, Pid} = inets:start(httpd,
     [{port, 0},
      {server_name,"mtn-server"},
      {server_root,"/www"},
      {document_root,"/www/htdocs"},
      {bind_address, "localhost"}]).
```      
reload config
```
httpd:reload_config(....).
```
stop
```
inets:stop().
inets:stop(Service, Reference).
```

## CGI
