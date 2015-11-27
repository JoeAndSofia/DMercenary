select * from sqlite_master where type="table"
CREATE TABLE property_set(id integer primary key,set_name varchar(50),rank integer,STA integer,TAL integer,MEN integer,STR integer,SAV integer,AGI integer,POT integer,LUC integer);
insert into property_set(id,set_name,rank,STA,TAL,MEN,STR,SAV,AGI,POT,LUC) values(1,'villager',0,1,1,1,1,1,1,0,0);
insert into property_set(id,set_name,rank,STA,TAL,MEN,STR,SAV,AGI,POT,LUC) values(2,'militia',1,2,1,1,1,1,1,0,0);
insert into property_set(id,set_name,rank,STA,TAL,MEN,STR,SAV,AGI,POT,LUC) values(3,'witch',1,1,2,1,1,1,1,0,0);
insert into property_set(id,set_name,rank,STA,TAL,MEN,STR,SAV,AGI,POT,LUC) values(4,'warrior',2,2,1,1,2,1,1,1,0);
insert into property_set(id,set_name,rank,STA,TAL,MEN,STR,SAV,AGI,POT,LUC) values(5,'watcher',2,2,1,1,1,1,2,1,0);
insert into property_set(id,set_name,rank,STA,TAL,MEN,STR,SAV,AGI,POT,LUC) values(6,'doctor',2,1,2,2,1,1,1,1,0);
insert into property_set(id,set_name,rank,STA,TAL,MEN,STR,SAV,AGI,POT,LUC) values(7,'wizard',2,1,2,1,1,2,1,1,0);




