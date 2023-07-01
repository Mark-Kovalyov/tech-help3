create table employee(
 id          integer generated always as identity,
 first_name  text,
 last_name   text,
 salary      integer,
 address     text
);