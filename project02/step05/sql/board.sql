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