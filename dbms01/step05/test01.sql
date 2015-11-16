-- 정렬하기
-- 1) Ascendent 정렬(오름차순 정렬 1 -> 높은수)
select bno,title 
from board
order by bno;

-- 오름차순 정렬 방식을 지정할 수 있다.
select bno,title 
from board
order by bno asc;

-- 2) Descendent (내림차순 정렬 높은수 -> 1)
select bno,title 
from board
order by bno desc;

-- 3) 

























