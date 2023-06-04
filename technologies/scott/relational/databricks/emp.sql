drop table if exists emp;

create table if not exists emp(
  empno integer,
  ename string,
  job string,
  mgr integer,
  hiredate date,
  sal decimal,
  comm decimal,
  depno integer) using parquet
  partitioned by(depno);
  
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7369,'SMITH','CLERK', 7902, TIMESTAMP '1980-12-17', 800, null, 20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7499,'ALLEN','SALESMAN', 7698, TIMESTAMP '1981-02-20', 1600, 300, 30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7521,'WARD','SALESMAN', 7698, TIMESTAMP '1981-02-22', 1250, 500, 30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7566,'JONES','MANAGER', 7839, TIMESTAMP '1981-04-02', 2975, null, 20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7654,'MARTIN','SALESMAN', 7698, TIMESTAMP '1981-09-28', 1250, 1400, 30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7698,'BLAKE','MANAGER', 7839, TIMESTAMP '1981-05-01', 2850, null, 30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7782,'CLARK','MANAGER', 7839, TIMESTAMP '1981-06-09', 2450, null, 10);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7788,'SCOTT','ANALYST', 7566, TIMESTAMP '1987-04-19', 3000, null, 20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7839,'KING','PRESIDENT', null, TIMESTAMP '1981-11-17', 5000, null, 10);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7844,'TURNER','SALESMAN', 7698, TIMESTAMP '1981-09-08', 1500, 0, 30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7876,'ADAMS','CLERK', 7788, TIMESTAMP '1987-05-23', 1100, null, 20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7900,'JAMES','CLERK', 7698, TIMESTAMP '1981-12-03', 950, null, 30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7902,'FORD','ANALYST', 7566, TIMESTAMP '1981-12-03', 3000, null, 20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,depno) values(7934,'MILLER','CLERK', 7782, TIMESTAMP '1982-01-23', 1300, null, 10);
