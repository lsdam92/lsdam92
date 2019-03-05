----------데이터 정의어 DDL Data Definition Language

--char  / varchar 데이터가 자구 업뎃될경우는 char를 많이 씀

--char      고정 max 2000byte ex) 주소지 
--varchar  가변 max 4000byte ex)검색을 위함 column , 비밀번호

--한글  완성형한글/ 조합형한글
--ex) ksc5600 == euc-kr 한글만가능 한글2byte 
--ex) 한글로 작성시 char 1000자 varchar 2000자
--utf-8=유니코드 모든글자처리가능 한글3byte
--date 날짜
--long : 2GB의 가변길이 문자데이터저장
--lob  : 4GB 데이터저장  blob 실행파일저장가능 , clob 문자열 중에 큰것저장  

--회원 (필수)      member         
-- 이름             name                  varchar2(30)
-- 아이디           id                      varchar2(16)
-- 비밀번호        pass                   varchar2(16)
-- 나이              age                   number(3)
-- 이메일아이디    emailid              varchar2(30)
-- 이메일도메인    emaildomain       varchar2(30)
-- 가입일             joindate            date

--회원 상세정보
-- 아이디           id                      varchar2(30)
-- 우편번호        zipcode               varchar2(5)       number로 할시 맨앞 0이 표시 x
-- 일반주소        address               varchar2(100)
-- 상세주소        address_detail       varchar2(100)  
-- 전화번호1       tel1                   varchar2(3)
-- 전화번호2       tel2                   varchar2(4)
-- 전화번호3       tel3                   varchar2(4)

--not null
--unique key 중복값 x null허용
--primary key not null + unique 
--default 기본값
   --column 의 바로뒤에 제약조건을 걸수있다
     --member_id에 별칭을 pk로 primary key를 (id)에 준다     
     
--자식(참조)부터 삭제 후 부모삭제    
drop table member;
--constraint [cascade]; 강제삭제 
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

  --member_detail_id에 별칭 fk 로foreign key를 (id)에 주고 member (id)를 참조
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
--Sub Query 를 이용하여 테이블 만들수있음
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
values ('이소담 ','lsdam92', '454555',28,'sod415 ','naver.com ', sysdate);

insert into member
values ('lsdam ','이소담', '28',454,'naver.com','sod415', sysdate);

insert into member (id, name, age, pass , emailid, emaildomain, joindate)
values ('lsdam ','이소담', '28',454,'sod415','naver.com', sysdate);

insert into member (id,name,pass,joindate)
values ('이소담 ','lsdam92', '454555',28,'sod415 ','naver.com ', sysdate);

insert into member_detail
values ('lsdam92', '01324', 'gwacheun', '98', '010', '5027', '8380');

insert into member_detail (id, tel1, tel2, address, tel3, address_detail, zipcode)
values ('lsdam92', '010', '5027', 'gwacheun', '8380', '98', '01324');

select *
from member , member_detail;

insert into member (id, name, age, pass , emailid, emaildomain, joindate)
values ('oracle ','오라클', 24,'4545','oracle','oracle.com', sysdate);
insert into member_detail (id, tel1, tel2, address, tel3, address_detail, zipcode)
values ('oracle','010', '5027', '경기도과천시', '8380', '98-2', '01234');

insert all
    into member (id, name, age, pass , emailid, emaildomain, joindate)
    values ('oracle','오라클', 24,'4545','oracle','oracle.com', sysdate)
    into member_detail (id, tel1, tel2, address, tel3, address_detail, zipcode)
    values ('oracle','010', '5027', '경기도과천시', '8380', '98-2', '01234')
select * from dual;

select *
from member m , member_detail d
where m.id = d.id;
--update

--delete

--merge
commit;