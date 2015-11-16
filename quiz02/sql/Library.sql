create table book (
  bno int primary key auto_increment,
  title varchar(255) not null,
  authors varchar(50) not null,
  press varchar(50) not null,
  tag varchar(255) not null
);

insert into book(title,authors,press,tag) 
values('databases','db','dbms','db,dbms,databases');
insert into book(title,authors,press,tag) 
values('Java Programming','Mr.Java','Hello world','java,Java Programming');
insert into book(title,authors,press,tag) 
values('title','authors','press','tag');
insert into book(title,authors,press,tag) 
values('aaa','aaa,bbb','aaa','aaa');
insert into book(title,authors,press,tag) 
values('bbb','bbb,bbb','bbb','bbb,bbb');
insert into book(title,authors,press,tag) 
values('good','cc,da,gd','hello','world');



