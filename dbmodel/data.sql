/* 직급 코드 등록 */
insert into LVL_CODE values('LC001', '사원');
insert into LVL_CODE values('LC002', '주임');
insert into LVL_CODE values('LC003', '대리');
insert into LVL_CODE values('LC004', '과장');
insert into LVL_CODE values('LC005', '차장');
insert into LVL_CODE values('LC006', '부장');

/* 매니저 등록 */
insert into managers (name, phot, email, tel, level)
values ('홍길동', 'temp.png', 'hong@test.com', '111-1111', 'LC001');
insert into managers (name, phot, email, tel, level)
values ('임꺽정', 'temp.png', 'lim@test.com', '111-1111', 'LC001');
insert into managers (name, phot, email, tel, level)
values ('유관순', 'temp.png', 'yoo@test.com', '111-1111', 'LC002');
insert into managers (name, phot, email, tel, level)
values ('안중근', 'temp.png', 'ahn@test.com', '111-1111', 'LC002');

/**/
insert into CAT_CODE values ('CT-JA', 'JAVA');
insert into CAT_CODE values ('CT-C0', 'C');
insert into cat_code values ('CT-CP', 'C++');
insert into cat_code values ('CT-C#', 'C#');
insert into cat_code values ('CT-LI', 'LINUX');
insert into cat_code values ('CT-AN', 'ANDROID');

/* 강의실 등록 */
insert into classes values ('KN301', '강남301호');
insert into classes values ('KN302', '강남302호');
insert into classes values ('KN303', '강남303호');
insert into classes values ('KN401', '강남401호');
insert into classes values ('KN402', '강남402호');
insert into classes values ('KN403', '강남403호');
insert into classes values ('KN501', '강남501호');
insert into classes values ('KN502', '강남502호');
insert into classes values ('KN503', '강남503호');
insert into classes values ('JR701', '종로701호');
insert into classes values ('JR702', '종로702호');
insert into classes values ('JR703', '종로703호');

/**/
insert into photoes (cid, phot) values ('KN301', 'kn301_1.png');
insert into photoes (cid, phot) values ('KN301', 'kn301_2.png');
insert into photoes (cid, phot) values ('KN302', 'kn302_1.png');
insert into photoes (cid, phot) values ('KN303', 'kn303_1.png');
insert into photoes (cid, phot) values ('KN303', 'kn303_2.png');
insert into photoes (cid, phot) values ('KN303', 'kn303_3.png');
insert into photoes (cid, phot) values ('JR701', 'jr701_1.png');
insert into photoes (cid, phot) values ('JR702', 'jr701_1.png');
insert into photoes (cid, phot) values ('JR703', 'jr701_1.png');

/**/
insert into lectures(title,detl,capa,hours,categ)
values ('자바프로그래밍-100기', '정부지원 자바 개발자 양성 과정', 30, 800, 'CT-JA');
insert into lectures(title,detl,capa,hours,categ)
values ('자바프로그래밍-101기', '정부지원 자바 개발자 양성 과정', 30, 800, 'CT-JA');
insert into lectures(title,detl,capa,hours,categ)
values ('윈도우 프로그래밍-80기', '정부지원 윈도우 개발자 양성 과정', 25, 600, 'CT-CP');
insert into lectures(title,detl,capa,hours,categ)
values ('윈도우 프로그래밍-81기', '정부지원 윈도우 개발자 양성 과정', 25, 600, 'CT-CP');
insert into lectures(title,detl,capa,hours,categ)
values ('리눅스 관리', '정부지원 리눅스 관리자 양성 과정', 30, 400, 'CT-LI');

/**/
insert into trainers(name,phot,email,tel)
values ('홍강사', 'hong.png', 'hongt@test.com', '222-1111');
insert into trainers(name,phot,email,tel)
values ('김강사', 'kim.png', 'kimt@test.com', '222-1112');
insert into trainers(name,phot,email,tel)
values ('박강사', 'park.png', 'parkt@test.com', '222-1113');

insert into lec_train (lno,tno) values(1,1);
insert into lec_train (lno,tno) values(1,2);
insert into lec_train (lno,tno) values(2,1);
insert into lec_train (lno,tno) values(2,2);
insert into lec_train (lno,tno) values(3,3);








