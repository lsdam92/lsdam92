--update
--update member

select *
from member;

commit;

rollback;

update member
set pass =9676
where id = 'java';

--java�� ����� 1234 , ���� 25����

update member
set pass = '1234' , age = 25
where id = 'java';

--java�� ����� 5678���� ���̴� ���̵� oracle�� ��������� ����/

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
where id in (select id from member_detail where address like '%��õ%');

commit;
--delete   insert all �������� ����x
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
values (100, '�����', 100, 1500);

insert into product (pid, pname, cnt, price)
values (200, '����Ĩ', 80, 2700);

insert into product (pid, pname, cnt, price)
values (300, '������', 120, 1000);

select *
from product;
-----������ / ���ڵ� / �ֹ�
--��ǰ�ڵ尡 400�� �ڰ�ġ(1200) 150�� �԰�
merge into product
using dual
on (pid = 400)
when matched then
update set cnt = cnt+150
when not matched then 
insert (pid , pname, cnt, price)
values (400, '�ڰ�ġ',150, 1200);
--��ǰ�ڵ尡 100�� �����(1500) 50�� �԰�
merge into product
using dual
on (pid = 100)
when matched then
update set cnt = cnt+50
when not matched then 
insert (pid , pname, cnt, price)
values (100, '�����',50, 1500);

commit;

--------------����
select *
from product;

update product
set cnt = 800
where pid = 100;
commit;
rollback;

insert into product
values(101, 'ȣŷ', 350, 5300);

insert into product
values(102, '��ŷ', 250, 1800);

insert into product
values(103, '��ġŷ', 150, 2500);

savepoint a;

insert into product
values(104, '��', 55, 1700);

insert into product
values(105, '��', 30, 500);

savepoint b;

insert into product
values(106, '��', 25, 3500);

insert into product
values(107, '��', 20, 5000);

select*
from product;

rollback to b;
---------------------------
--sequence
create sequence product_pid_seq
start with 1 INCREMENT by 1;                     --1���� �����ؼ� 1�� ����

delete product;

commit;

insert into product (pid, pname, cnt, price)
values (product_pid_seq. nextval, '�̸�', 10, 1000);

select *
from product;

select product_pid_seq. nextval
from dual;

select product_pid_seq. currval
from dual;

select max(pid)+1 from product;

rollback;   -- insert update delete �� �ѹ�  /  create sequence drop �� �ѹ� x  like �ڵ�Ŀ��?

