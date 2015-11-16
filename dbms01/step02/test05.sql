/* 주제: 자동 증가 컬럼 설정
 * => 자동 증가 컬럼 반드시 PK이어야 한다. 일반 컬럼 불가
*/


-- 테이블 정의1
-- unique 컬럼은 자동으로 not null이 되지 않는다.
create table test14 (
  no      int primary key auto_increment, 
  email   varchar(100) not null unique,
  name    varchar(20) not null default '홍길동',
  age     int default 20,
  tel     varchar(20) unique
);

-- 데이터 입력
insert into test14(email) values('aaa@test.com');
insert into test14(email) values('bbb@test.com');


-- 테이블 정의2
create table test15 (
  no      int, 
  email   varchar(100) not null,
  name    varchar(20) not null default '홍길동',
  age     int default 20,
  tel     varchar(20)
);

alter table test15
  add constraint tests15_pk primary key(no);
  
alter table test15
  add constraint test15_uq unique(email);
  
alter table test15
  add constraint test15_uq2 unique(tel);
  
alter table test15
  modify column no int auto_increment;















  
  
  
  
  