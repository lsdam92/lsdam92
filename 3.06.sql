--update
--update member

select *
from member;

commit;

rollback;

update member
set pass =9676
where id = 'java';

--java의 비번을 1234 , 나이 25변경

update member
set pass = '1234' , age = 25
where id = 'java';

--java의 비번을 5678으로 나이는 아이디가 oracle인 사람과같게 변경/

select age
from member
where id = 'oracle';

update member
set pass = '5678' , age = (select age
from member
where id = 'oracle')
where id = 'java';

update member
set pass = 87654321
where id in (select id from member_detail where address like '%과천%');

commit;
--delete   insert all 같은것이 존재x
rollback;

delete member_detail
where id = 'java';

delete member
where id = 'java';

select *
from member;

--merge
drop table product;
create table product
(
  pid number,
  pname varchar2(10),
  cnt number,
  price number,
  constraint product_pid_pk primary key (pid)
);

insert into product (pid, pname, cnt, price)
values (100, '새우깡', 100, 1500);

insert into product (pid, pname, cnt, price)
values (200, '꼬북칩', 80, 2700);

insert into product (pid, pname, cnt, price)
values (300, '빼빼로', 120, 1000);

select *
from product;
-----포스기 / 바코드 / 주문
--상품코드가 400인 자갈치(1200) 150개 입고
merge into product
using dual
on (pid = 400)
when matched then
update set cnt = cnt+150
when not matched then 
insert (pid , pname, cnt, price)
values (400, '자갈치',150, 1200);
--상품코드가 100인 새우깡(1500) 50개 입고
merge into product
using dual
on (pid = 100)
when matched then
update set cnt = cnt+50
when not matched then 
insert (pid , pname, cnt, price)
values (100, '새우깡',50, 1500);

commit;

--------------연습
select *
from product;

update product
set cnt = 800
where pid = 100;
commit;
rollback;

insert into product
values(101, '호킹', 350, 5300);

insert into product
values(102, '쿠킹', 250, 1800);

insert into product
values(103, '리치킹', 150, 2500);

savepoint a;

insert into product
values(104, '깡', 55, 1700);

insert into product
values(105, '꽁', 30, 500);

savepoint b;

insert into product
values(106, '꾹', 25, 3500);

insert into product
values(107, '꿍', 20, 5000);

select*
from product;

rollback to b;
---------------------------
--sequence
create sequence product_pid_seq
start with 1 INCREMENT by 1;                     --1부터 시작해서 1씩 증가

delete product;

commit;

insert into product (pid, pname, cnt, price)
values (product_pid_seq. nextval, '이름', 10, 1000);

select *
from product;

select product_pid_seq. nextval
from dual;

select product_pid_seq. currval
from dual;

select max(pid)+1 from product;

rollback;   -- insert update delete 만 롤백  /  create sequence drop 은 롤백 x  like 자동커밋?

