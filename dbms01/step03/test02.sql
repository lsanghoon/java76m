-- 데이터 입력

-- 1) 모든 컬럼 값 입력
-- 데이터 입력할 컬럼을 지정하지 않으면 테이블 정의할 때 선언된 순서대로 값을 설정한다.
insert into board values(0, 'aaaa', '1255555', 0, now(), null);
insert into board values(null,'bbbb', 'xxxxxxx', 0, now(), null);

-- 무조건 모든 항목의 값을 지정해야 한다. 다음과 같이 한 항목의 값을 빼면 오류 발생
insert into board values('bbbb', 'xxxxxxx', 0, now(), null);

-- 2) 특정 컬럼의 값 입력
insert into board(title,context,cre_dt) values('cccc', 'xxxxxxx', now());

-- 3) ek른 테이블의 조회 결과를 입력할 수 있다.
insert into board(title,context,cre_dt)
select email, name, now() from test15;
















