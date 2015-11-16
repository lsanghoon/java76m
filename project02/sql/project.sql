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