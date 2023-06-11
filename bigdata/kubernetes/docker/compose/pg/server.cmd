docker run ^
   -detach ^
   -p 5432:5432 ^
   -e POSTGRES_PASSWORD=tiger ^
   -v /pg/pgdata:/var/lib/postgresql/data ^
   --net pg-net ^
   postgres:latest
