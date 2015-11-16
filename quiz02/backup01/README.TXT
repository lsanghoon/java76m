과제: 도서관 C/S 구현
1. 도서관리(CRUD)
2. 대여기능 

1.1 도서등록 -- ok
>localhost/book/add?title=도서명&authors=저자1,저자2&press=출판사명&tag=검색어1,검색어2
도서정보가 등록되었습니다.

1.2 도서목록 -- ok
>localhost/book/list
제목    저자명(1인)   출판사
aaa    홍길동       비트출판사
bbb    임꺽정       가나출판사


1.3 도서 조회 -- ok
>localhost/book/detail?no=1
제목: aaaa
저자: 홍길동,임꺽정,유관순
출판사: 비트출판사
태그: 자바,프로그래밍,비트


1.4 도서삭제 -- ok
>localhost/book/delete?no=1
도서정보가 삭제되었습니다.


1.5 도서변경 -- ok
>localhost/book/update?no=1&title=도서명&orders=저자1,저자2&press=출판사명&tag=검색어1,검색어2
도서정보가 변경되었습니다.


2.1 대여하기 -- ok
>localhost/book/rent?no=1
대여처리 되었습니다.

>localhost/book/rent?no=1
이미 대여된 도서입니다.


2.2 반납하기 -- ok
>localhost/book/return?no=1
반납처리가 되었습니다.

>localhost/book/return?no=1
이미 반납된 도서입니다.



















3. 