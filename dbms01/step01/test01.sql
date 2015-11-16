-- mysql 클라이언트 프로그램 실행
명령창> mysql -u 사용자 -p
암호: 1111

-- 사용할 DB선택
mysql> use 스키마명;
또는
mysql> connect 스키마명;
-- 예)
mysql> use java76db;
mysql> connect java76db;

-- 사용자가 사용할 수 있는 스키마 목록
mysql> show databases;

-- 현재 스키마의 테이블 목록
mysql> show tables;

-- 테이블 생성
/*create table 테이블명 (
  컬럼명 타입 옵션,
  컬럼명 타입 옵션,
  ...
);*/

--예1) 테이블 생성

CREATE TABLE test01 (
  name VARCHAR(10),
  age INT
);

/* 테이블 내용 출력
 * mysql> desc[ribe] 테이블명;
 */
-- 예)
mysql> desc test01;

/* 테이블 삭제 - 물론, 테이블에 들어있는 모든 데이터 삭제된다.
 * drop table 테이블명;
 */
-- 예)
drop table test01;

/* 테이블에 데이터 입력
insert into 테이블명(컬럼명, 컬럼명, ...) value('값', 값, ....);
*/
-- 예) 모든 컬럼 값 입력
-- 문자열: 따옴표(' ') 로 표현한다. 쌍따옴표(" ")는 사용하지 않는다.
-- 숫자: 따옴표 없이 적는다.
insert into test01(name, age) value ('홍길동', 20);
insert into test01(name, age) value ('임꺽정', 30);
insert into test01(name, age) value ('유관순', 17);

-- 예) 일부 컬럼 값 입력
insert into test01(name, age) value ('사용자1', null);
insert into test01(name, age) value (null, 50);
insert into test01(name) value ('사용자2');
insert into test01(age) value (30);

/* 데이터 조회
 * select * from 테이블명;
 */
-- 예) 모든컬럼 출력하기
select * from test01;

-- 예) 출력할 항목을 선택한다.
select name from test01;
select age from test01;

/* 용어정리
 * 데이터
 * 홍길동 10   <-- row(행), record(레코드)
 * 임꺽정 20
 * 유관순 30
 *  ^
 * 컬럼(column), attribute
 */

/* SQL 데이터 타입
 * => DBMS 전용 데이터 타입이 있다.
 * => SQL은 표준이지만, 각 DBMS마다 자신만의 고유 문법을 추가적으로 제공하고 있다.
 * [숫자]
 * tinyint(1), bool, boolean (1byte)
 * smallint(2)
 * mediumint(3)
 * int,integer(4)
 * bigint(8)
 * float(4)
 * double, real(8)
 * decimal(M,D), numeric(M,D)
 * 
 * [날짜 및 시간]
 * year(1)
 * date(3) - mysql에서는 날짜만
 * time(3) - 시간
 * daytime(8) - 날짜와 시간
 * timestamp(4)
 * 
 * [문자열]
 * char(M) - 0 <= M <=255   (고정형, 무조건 256자 - 1자를 저장하더라도 256칸을 점유)
 * varchar(M) - 0 ~ 255     (가변형, 최대 256자 - 1자를 저장하면 1칸을 점유)
 * tinyblob, tinytext - 최대 256자 저장  (가변형)
 * blob(binary), text(텍스트) - 사진정보 바이너리, 글 텍스트 최대 2^16 = 65536자  (가변형)
 * mediumblob, mediumtext - 최대 16,777,216 약 1600만자  (가변형)
 * longblob, longtext - 최대 약 42억자 (가변형)
 */

/* 문제:
 * Student와 Project를 저장할 테이블을 정의하시오
 */ 
CREATE TABLE student (
  name VARCHAR(100),
  email VARCHAR(30),
  tel VARCHAR(20),
  cid VARCHAR(50)
);

CREATE TABLE project (
  title VARCHAR(255),
  start_dt DATETIME,
  end_dt DATETIME,
  member VARCHAR(255)
);













