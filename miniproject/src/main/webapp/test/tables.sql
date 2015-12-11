create table users (
  email varchar(255) not null,
  pwd varchar(255) not null,
  name varchar(255) not null,
  addr varchar(255) not null,
  tel varchar(20) not null,
  point int,
  constraint users_pk primary key (email)
);

create table cart (
  cno int auto_increment,
  cpname varchar(255) not null,
  cpcost int,
  cemail varchar(255),
  cstock int default 1,
  constraint cart_pk primary key (cno)
);

create table product (
  pno int auto_increment,
  pname varchar(255),
  pstock int default 0,
  pcost int not null,
  pcate varchar(255),
  constraint cart_pk primary key (pno)
);


alter table member add column joindate datetime not null;
alter table article add column mphoto varchar(255);

alter table product add column pname varchar(255) not null;
alter table cart add column cpname varchar(255) not null;
alter table cart add column cpcost int;

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


select pno,pcost,pname from product where pno=(select cpno from cart where cemail='sing@sing.sing');

select * from product where pno=#{no}

select * from product where pno=#{no};
select * from cart where email=#{email};