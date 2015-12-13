create table users (
  email varchar(255) not null,
  pwd varchar(255) not null,
  name varchar(255) not null,
  addr varchar(255) not null,
  tel varchar(20) not null,
  point int default 0,
  pphoto varchar(255) not null,
  constraint users_pk primary key (email)
);

create table cart (
  cno int auto_increment,
  cpname varchar(255) not null,
  cpcost int,
  cemail varchar(255),
  cstock int default 1,
  cpphoto varchar(255),
  constraint cart_pk primary key (cno)
);

create table product (
  pno int auto_increment,
  pname varchar(255),
  pstock int default 0,
  pcost int not null,
  pcate varchar(255),
  pphoto varchar(255) not null,
  pcontent text,
  pviews int default 0,
  constraint cart_pk primary key (pno)
);

create table purchase (
  bno int auto_increment,
  bDate DATETIME,
  bpname varchar(255),
  bpsum int,
  buname varchar(255),
  buemail varchar(255),
  constraint purchase_pk primary key (bno)
);

select date_format(bDate,'%Y-%m')m,count(*) as s from purchase group by m;

select date_format(bDate, '%Y-%m')m, sum(bpsum) as s from purchase group by m;



<![CDATA[
    select date_format(bDate, '%Y')m, sum(bpsum) as s 
    from purchase 
  where bDate >= '0000-01' and bDate < '2500-12'
  group by m
    ]]>




select date_format(bDate, '%Y')m, sum(bpsum) as s from purchase 
group by m;



insert into purchase(bDate,bpname,bpsum,buname,buemail)
values('2014-5-6','바지2',1000300,'aaa','a@a.aaa');


alter table purchase drop bpcost;


alter table users drop point;

alter table users drop fimage;
alter table users drop simage;

alter table users add column point int default 0;

alter table product add column fimage varchar(255);
alter table product add column simage varchar(255);

insert into users(email,pwd,name,addr,tel) 
values('admin@admin.admin','1111','admin','admin-address','000-0000-0000');
insert into users(email,pwd,name,addr,tel) 
values('sing@sing.sing','1111','sing','sing-address','000-0000-0000');

insert into product(pname,pcost,pcate)
values('스키니레깅스',20000,'outer');
insert into product(pname,pcost,pcate)
values('오리파카',30000,'outer');
insert into product(pname,pcost,pcate)
values('청바지',30000,'outer');
insert into product(pname,pcost,pcate)
values('체크무늬셔츠',30000,'outer');
insert into product(pname,pcost,pcate)
values('가죽재킷',30000,'outer');

insert into cart(cpname,cpcost,cemail)
values(스키니레깅스,'sing@sing.sing');
insert into cart(cpno,cemail)
values(2,'sing@sing.sing');
insert into cart(cpno,cemail)
values(3,'sing@sing.sing');
insert into cart(cpno,cemail)
values(4,'sing@sing.sing');
insert into cart(cpno,cemail)
values(5,'sing@sing.sing');
insert into cart(cpno,cemail)
values(6,'sing@sing.sing');
insert into cart(cpno,cemail)
values(7,'sing@sing.sing');




SELECT NVL(bDate, '전체')m
     , NVL(SUM(bpsum), 0)s
  FROM (SELECT TO_CHAR(TO_DATE('20120620', 'yyyymmdd') + LEVEL - 1, 'yyyymmdd') dt
          FROM purchase
          CONNECT BY LEVEL <= TO_DATE('20120701', 'yyyymmdd') - TO_DATE('20120620', 'yyyymmdd') + 1
        )a
     , (SELECT TO_CHAR(dtime, 'yyyymmdd') dt, COUNT(*) tot
          FROM purchase
          WHERE bDate >= TO_DATE('20120620', 'yyyymmdd')
          AND bDate <  TO_DATE('20120701', 'yyyymmdd') + 1
          GROUP BY TO_CHAR(bDate, 'yyyymmdd')
        )b
 WHERE a.dt = b.dt(+)
 GROUP BY ROLLUP(a.dt)
;


SELECT ifnull(DATE_FORMAT(bDate, '%Y%m%d'), '전체') dt
     , COUNT(*) tot
  FROM purchase
  WHERE bDate >= DATE_FORMAT('20120620', '%Y%m%d')
   AND bDate <  DATE_FORMAT('20120701', '%Y%m%d') + 1
  GROUP BY DATE_FORMAT(bDate, '%Y%m%d') with rollup
;



우리 모두 패피가 되는 그순간까지 FASHION MAKER가 함께 합니다.




select pno,pcost,pname from product where pno=(select cpno from cart where cemail='sing@sing.sing');

select * from product where pno=#{no}

select * from product where pno=#{no};
select * from cart where email=#{email};
