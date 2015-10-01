create table user (
       id integer primary key autoincrement,       
       name varchar(50) unique default '',       
       password varchar(32),       
       hint varchar(100)       
);
select * from user;
delete from user;
select * from sqlite_master;
alter table user set autoincrement = 1;
select * from sqlite_sequence;
update sqlite_sequence set seq=1 where name = 'user';







