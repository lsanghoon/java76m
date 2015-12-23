-- 프로젝트 테이블 생성
create table board (
  bno int auto_increment,
  title varchar(255) not null,
  content text,
  views int default 0,
  cr_dt datetime not null,
  pw varchar(255) not null,
  constraint board_pk primary key (bno)
);

insert into board(title,content,cr_dt,pw) values('aaaa','ararararar',now(), '1111');
insert into board(title,content,cr_dt,pw) values('bbbb','cdcdcdcdcd',now(), '1111');
insert into board(title,content,cr_dt,pw) values('cccc','sesesesese',now(), '1111');

-- 프로젝트 테이블 생성
create table project (
  pno int auto_increment,
  title varchar(255),
  sdt datetime not null,
  edt datetime not null,
  member varchar(255),
  constraint project_pk primary key (pno)
);

insert into project(title,sdt,edt) values('aaaa','2015-1-1', '2016-1-1');
insert into project(title,sdt,edt) values('bbbb','2015-1-1', '2016-1-1');
insert into project(title,sdt,edt) values('cccc','2015-1-1', '2016-1-1');

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















-- 수강 신청 테이블
drop table cour_enroll;

create table cour_enroll (
  email varchar(100) not null,
  name varchar(20) not null,
  tel varchar(20) not null,
  status int default 0,
  reg_dt DATETIME,
  constraint cour_enroll_pk primary key (email)
);



insert into cour_enroll(email,name,tel,reg_dt)
values ('st001@test.com', 'st001', '111-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st002@test.com', 'st002', '211-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st003@test.com', 'st003', '311-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st004@test.com', 'st004', '411-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st005@test.com', 'st005', '511-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st006@test.com', 'st006', '611-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st007@test.com', 'st007', '711-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st008@test.com', 'st008', '811-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st009@test.com', 'st009', '911-1111', now());
insert into cour_enroll(email,name,tel,reg_dt)
values ('st010@test.com', 'st010', '121-1111', now());
























