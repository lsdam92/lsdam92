----------������ ���Ǿ� DDL Data Definition Language

--char  / varchar �����Ͱ� �ڱ� �����ɰ��� char�� ���� ��

--char      ���� max 2000byte ex) �ּ��� 
--varchar  ���� max 4000byte ex)�˻��� ���� column , ��й�ȣ

--�ѱ�  �ϼ����ѱ�/ �������ѱ�
--ex) ksc5600 == euc-kr �ѱ۸����� �ѱ�2byte 
--ex) �ѱ۷� �ۼ��� char 1000�� varchar 2000��
--utf-8=�����ڵ� ������ó������ �ѱ�3byte
--date ��¥
--long : 2GB�� �������� ���ڵ���������
--lob  : 4GB ����������  blob �����������尡�� , clob ���ڿ� �߿� ū������  

--ȸ�� (�ʼ�)      member         
-- �̸�             name                  varchar2(30)
-- ���̵�           id                      varchar2(16)
-- ��й�ȣ        pass                   varchar2(16)
-- ����              age                   number(3)
-- �̸��Ͼ��̵�    emailid              varchar2(30)
-- �̸��ϵ�����    emaildomain       varchar2(30)
-- ������             joindate            date

--ȸ�� ������
-- ���̵�           id                      varchar2(30)
-- �����ȣ        zipcode               varchar2(5)       number�� �ҽ� �Ǿ� 0�� ǥ�� x
-- �Ϲ��ּ�        address               varchar2(100)
-- ���ּ�        address_detail       varchar2(100)  
-- ��ȭ��ȣ1       tel1                   varchar2(3)
-- ��ȭ��ȣ2       tel2                   varchar2(4)
-- ��ȭ��ȣ3       tel3                   varchar2(4)

--not null
--unique key �ߺ��� x null���
--primary key not null + unique 
--default �⺻��
   --column �� �ٷεڿ� ���������� �ɼ��ִ�
     --member_id�� ��Ī�� pk�� primary key�� (id)�� �ش�     
     
--�ڽ�(����)���� ���� �� �θ����    
drop table member;
--constraint [cascade]; �������� 
drop table member_detail;

create table member
(
    name varchar2(30) not null,                                      
    id varchar2(16),
    pass varchar2(16) not null,
    age number(3) check(age < 150),
    emailid varchar2(30),
    emaildomain varchar2(30),
    joindate date default sysdate ,                                             
    constraint member_id_pk primary key (id)                                                                    
);

  --member_detail_id�� ��Ī fk ��foreign key�� (id)�� �ְ� member (id)�� ����
create table member_detail
(
    id varchar2(30),
    zipcode varchar2(5),
    address varchar2(100),
    address_detail varchar2(100),
    tel1 varchar2(3),
    tel2 varchar2(4),
    tel3 varchar2(4),
    constraint member_detail_id_fk foreign key(id) references member (id) 
);
--Sub Query �� �̿��Ͽ� ���̺� ���������
create table emp_all
as
select *from employees;

create table emp_50
as
select employee_id eid, first_name name, salary sal, department_name dname
from employees e , departments d
where e.department_id = d.department_id and e.department_id =50;

select *
from emp_blank;

--------------DML
--insert
insert into member
values ('�̼Ҵ� ','lsdam92', '454555',28,'sod415 ','naver.com ', sysdate);

insert into member
values ('lsdam ','�̼Ҵ�', '28',454,'naver.com','sod415', sysdate);

insert into member (id, name, age, pass , emailid, emaildomain, joindate)
values ('lsdam ','�̼Ҵ�', '28',454,'sod415','naver.com', sysdate);

insert into member (id,name,pass,joindate)
values ('�̼Ҵ� ','lsdam92', '454555',28,'sod415 ','naver.com ', sysdate);

insert into member_detail
values ('lsdam92', '01324', 'gwacheun', '98', '010', '5027', '8380');

insert into member_detail (id, tel1, tel2, address, tel3, address_detail, zipcode)
values ('lsdam92', '010', '5027', 'gwacheun', '8380', '98', '01324');

select *
from member , member_detail;

insert into member (id, name, age, pass , emailid, emaildomain, joindate)
values ('oracle ','����Ŭ', 24,'4545','oracle','oracle.com', sysdate);
insert into member_detail (id, tel1, tel2, address, tel3, address_detail, zipcode)
values ('oracle','010', '5027', '��⵵��õ��', '8380', '98-2', '01234');

insert all
    into member (id, name, age, pass , emailid, emaildomain, joindate)
    values ('oracle','����Ŭ', 24,'4545','oracle','oracle.com', sysdate)
    into member_detail (id, tel1, tel2, address, tel3, address_detail, zipcode)
    values ('oracle','010', '5027', '��⵵��õ��', '8380', '98-2', '01234')
select * from dual;

select *
from member m , member_detail d
where m.id = d.id;
--update

--delete

--merge
commit;