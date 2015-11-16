create table student (
  sno int auto_increment,
  name varchar(255) not null,
  email varchar(255) not null,
  tel varchar(20) not null,
  cid varchar(20) not null,
  constraint student_pk primary key (sno)
);

insert into student(name,email,tel,cid) values('aaaa','aaa@test.com', '11111','c01');
insert into student(name,email,tel,cid) values('bbbb','bbb@test.com', '22222','c02');
insert into student(name,email,tel,cid) values('cccc','ccc@test.com', '33333','c01');