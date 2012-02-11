select * from gamedata_passing;

delete from gamedata_passing;

insert into gamedata_passing values (0,47,1,15,10,1,55,90,10,2,3,200);
insert into gamedata_passing values (0,47,2,15,10,1,55,90,10,2,3,200);

update gamedata_passing set comp = 7 where weeknum = 2;

select * from gamedata_defense;
insert into gamedata_defense values (0,78,2,5,2,1,0,0,0,2,7,0,0)
insert into gamedata_defense values (0,73,2,3,0,0,2,60,0,2,5,1,99)

update gamedata_defense set ints = 1, yds = 2, longest = 2 where playerid = 73 and weeknum = 1;

select * from gamedata_receiving;
insert into gamedata_receiving values (0,56,1,62,5,1,150);

select * from gamedata_rushing;
insert into gamedata_rushing values (0,50,1,15,54,2,86)

select * from player; 
47,73,78,56,50


select round(cast(yds as decimal)/cast(att as decimal), 1) as ydsPerAtt from gamedata_passing;
select round(yds/att, 1) as ydsPerAtt from gamedata_passing;