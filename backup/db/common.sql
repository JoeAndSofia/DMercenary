create table user(id integer primary key autoincrement,name varchar(50) unique default '',password varchar(32),hint varchar(100));
select * from user;
delete from user;
select * from sqlite_master;
alter table user set autoincrement = 1;
select * from sqlite_sequence;
update sqlite_sequence set seq=1 where name = 'user';

create database joe;

alter table user add column play_duration integer default 0;

-- 删除字段
begin transaction;
create temporary table user_backup(id,name,password,hint);
insert into user_backup select id,name,password,hint from user;
drop table user;
create table user(id integer primary key autoincrement,name varchar(50) unique default '',password varchar(32),hint varchar(100));
insert into user select id,name,password,hint from user_backup;
drop table user_backup;
commit;
vacuum;

-- 创建exception log 表
create table log(id integer primary key, time integer, in_class varchar(200), message text);
select * from log;

-- 插入数据
insert into user (name, password, hint, play_duration) values('joe','password','justit',0);
insert into user (name, password, hint, play_duration) values('joe1','password','justit',0);
insert into user (name, password, hint, play_duration) values('joe2','password','justit',0);
insert into user (name, password, hint, play_duration) values('joe3','password','justit',0);
insert into user (name, password, hint, play_duration) values('joe4','password','justit',0);
insert into user (name, password, hint, play_duration) values('joe5','password','justit',0);
insert into user (name, password, hint, play_duration) values('joe6','password','justit',0);
update user set name = 'joe1', password = 'password1', hint = '' where id=1;
update user set name='joe', password='password', hint='justit' where id=1;


