docker run -it ^
 --rm ^
 --net pg-net ^
  postgres psql -h <IP> -d dht -U scott
