create table member (
  email varchar(255) not null,
  pwd varchar(255) not null,
  name varchar(255) not null,
  tel varchar(20) not null,
  photo varchar(255),
  constraint student_pk primary key (email)
);

create table article (
  ano int auto_increment,
  content text,
  cr_dt datetime not null,
  name varchar(50),
  photo varchar(255),
  constraint board_pk primary key (ano)
);

alter table member add column joindate datetime not null;
alter table article add column mphoto varchar(255);