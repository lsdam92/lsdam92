select 1234, 5438, round(1234.5438), round(1234.5438, 0),  --�ش� �ڸ������� �ݿø�ǥ��
round(1234.5438, 1), round(1234.5438,-1),
round(1234.5438, 3), round(1234.5438, -3)
from dual;

select 1234, 5438, trunc(1234.5438), trunc(1234.5438, 0),  --�ش� �ڸ����������� ����ǥ��
trunc(1234.5438, 1), trunc(1234.5438,-1),
trunc(1234.5438, 3), trunc(1234.5438, -3)
from dual;

select 1234.5438, floor(1234.5438)    --�Ҽ�������
from dual;

select 5+3, 5-3, 5/3, mod(5, 3)                --mod �� ������
from dual;

select abs(5), abs(-5)  -- abs ���밪
from dual;

select trunc(789.4561, 3)
from dual;

--����� ���, �̸�, �޿�, Ŀ�̼����Ա޿�
--Ŀ�̼� ���� �޿��� 100�� �ڸ����� ǥ��

select employee_id, first_name, salary,salary+salary*nvl(commission_pct, 0),
round(salary+salary*nvl(commission_pct, 0), -2)
from employees;

--*����� 100~199���� ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿� ( 100�ڸ���ǥ��)
---�����Լ�

select employee_id, first_name, salary, round(salary+salary*nvl(commission_pct, 0), -2)
from employees
where employee_id between 100 and 199;

select 'kiTrI', lower('kiTrI'), upper('kiTrI'), initcap('kiTrI'), length('kiTrI')
from dual;
--full name  --Ÿ���̳� ���� ���������Ͽ� ���� �Լ� �ӿ� �Լ�  -concat(  xx ,xx  ) ��2����
select employee_id, first_name, last_name,
         first_name||' '|| last_name,
         concat(first_name, concat(' ', last_name))   
from employees;

--substr �������ڿ� db��  ���ڰ� ������ 1 ///  substr( xx1 , x2 , x3)    --x2= �ش��ڸ������� ������ x3=x1�� ���ڿ� ����
--instr(x1 , x2, x3 ) x2= x1������ ù��° ������ġ x3��
select 'hello oracel !!!', substr('hello oracle!!!', 2, 6), substr('hello oracle!!!', 2)
          ,instr('hello oacle !!!', 'o'),instr('hello oracle!!!', 'o', 6)                                                                                
from dual;

--'123-456  zipcode, 123 zip2, 456 zip2                substr ('x', x ) / ( 'x' , x , x )substr('xx', 1 , instar('xx','-')-1 or +1),   instr('x', 'x')  /  ('x', 'x' x)
select '123-456' zipcode, substr('123-456',1 ,instr('123-456', '-')-1)"zip1",substr('123-456', instr('123-456', '-')+1)"zip2"
from dual;

select '1234-56' zipcode ,substr('1234-56', 1, instr('1234-56','-')-1), substr('1234-56', instr('1234-56','-')+1)
from dual;

--010-4182-0926
select '1010-14182-0926' simpson, substr('1010-14182-0926', 1 , instr('1010-14182-0926','-')-1) first,
            substr('1010-4182-0926',instr('1010-4182-0926','-')+1, instr('1010-4182-0926', '-')-1)middle,
            substr('1010-4182-0926', instr('1010-4182-0926','-',1,2)+1)last
from dual;

--010-5027-8380
select '010-5027-8380', substr('010-5027-8380',1 ,instr('010-5027-8380','-')-1),
       substr('010-5027-8380', instr('010-5027-8380','-')+1, instr('010-5027-8380','-',2)),
       substr('010-5027-8380', instr('010-5027-8380','-',1,2)+1)
from dual;



--010-27357-9897
select '010-27357-9897' lug , substr('010-27357-9897', 1, instr('010-27357-9897','-')-1)first,
        substr('010-27357-9897', instr('010-27357-9897','-')+1, 5)middle,
        substr('010-27357-9897', instr('010-27357-9897','-',1,2)+1,4)last
from dual;

select '010-4182-0926-02', substr('010-4182-0926-02', instr('010-4182-0926-02','-',1,2)+1, instr('010-4182-0926-02','-'))
          ,substr('010-4182-0926-02', instr('010-4182-0926-02','-',1,3)+1)
from dual;

--��¥�Լ�
select sysdate, sysdate +3, sysdate-3, sysdate+3/24, to_char(sysdate+3/24, 'yyyy-mm-dd hh24:mi:ss')
from dual;
--months_between ( sysdate, sysdate +xx) xx���� ����
--next_day(sysdate, x)  ���� �������� ���� ���� ( 1 : �Ͽ��� 2: ������ ~~)
--add_months(sysdate , x) ���ñ��� x�޵�
select sysdate, months_between(sysdate, sysdate +70)
        ,next_day(sysdate, 1), next_day(sysdate, 3)
        ,add_months(sysdate, 2)
        ,last_day(sysdate)
from dual;
--to_char ��¥ ���ڿ��� ���ڷ�ǥ��  - w  :�̹����� �������  ww : ������ ������  d : ������ ����� dd :  �� ���� �� ddd : ������ ���° �� dy : x���� day : x����
--mi : ��� ss : ����
select sysdate, to_char(sysdate, 'yyyy mm mon month w ww d dd ddd dy day')
        ,to_char(sysdate,  'am hh hh24 mi ss')
from dual;
--round : �ݿø� / trunc : ����
select to_char(sysdate, 'yyyy mm dd hh24 mi ss')"1",
        to_char(round(sysdate), 'yyyy mm dd hh24 mi ss')"2" ,
         to_char(round(sysdate, 'dd'), 'yyyy mm dd hh24 mi ss')"3",
          to_char(round(sysdate, 'mm'), 'yyyy mm dd hh24 mi ss')"4",
           to_char(round(sysdate, 'yy'), 'yyyy mm dd hh24 mi ss')"5",
            to_char(round(sysdate, 'hh'), 'yyyy mm dd hh24 mi ss')"6",
             to_char(round(sysdate, 'mi'), 'yyyy mm dd hh24 mi ss')"7"
from dual
union
select to_char(sysdate, 'yyyy mm dd hh24 mi ss')"1",
        to_char(trunc(sysdate), 'yyyy mm dd hh24 mi ss')"2" ,
         to_char(trunc(sysdate, 'dd'), 'yyyy mm dd hh24 mi ss')"3",
          to_char(trunc(sysdate, 'mm'), 'yyyy mm dd hh24 mi ss')"4",
           to_char(trunc(sysdate, 'yy'), 'yyyy mm dd hh24 mi ss')"5",
            to_char(trunc(sysdate, 'hh'), 'yyyy mm dd hh24 mi ss')"6",
             to_char(trunc(sysdate, 'mi'), 'yyyy mm dd hh24 mi ss')"7"
from dual;

--��ȯ�Լ�   ���� : ���������� ���� : ��������  +�� ���ڿ��꿡�� ��� '  ' �� �ٴ��� �ڵ�����ȯ ex) '3'+5  = 8  -'3'+  +�� �������ν� ������ '3'��  �ڵ����ں�ȯ
select 'a', 3, '3' , 3+5, '3'+5
from dual;

select 1123456.789,
        to_char(1123456.789, '000,000,000.00'),
        to_char(1123456.789, '999,999,999.99'),
        length(to_char(1123456.789, '000,000,000.00')),
        length(to_char(1123456.789, '999,999,999.99'))
from dual;

-- ���� -> ����    --'123,456.98'  ' ' �ȿ� , �� �� �������
select '123,456.98', '123,456.98'+3  
from dual;   -- ����������

select '123,456.98', to_number('123,456.98', '000,000.00')+3
from dual;

select sysdate, to_char(sysdate, 'yy mm dd')
    ,to_char(sysdate, 'am hh mi ss')
    ,to_char(sysdate, 'hh24 mi ss')
from dual;

--20190225142154  > ��¥ >> 3����       ���� - > ���� - > ��¥ -> 3����
select 20190225142154, to_date(to_char(20190225142154, '00000000000000'), 'yyyymmdd hh24 mi ss')                      
from dual;

select to_char(to_date(to_char(20190225142154,'00000000000000'), 'yyyymmdd hh24 mi ss')+3, 'yyyy.mm.dd hh24:mi:ss')
from dual;

--19920415131313 > ���� > 3����

select to_char(to_date(to_char(19920415131313,'00000000000000'), 'yyyy mm dd hh24 mi ss')+3, 'yyyy mm dd hh24:mi:ss')
from dual;




--�Ϲ��Լ�   nvl2(commission_pct, 1, 0)          1 : null �ϰ�� 1�κ�ȯ  0 : null �ϰ�� 0���� ��ȯ
select commission_pct, nvl(commission_pct, 0), nvl2(commission_pct, 1, 0)
from employees;
--�������          ���� p65 case  / decode
-- �޿��� 4000�̸��� ����� ������           case���� when then else���ǻ��� ������ end��
--�޿��� 10000�̸���          ��տ���
--�޿��� 10000�̻���           ����
--���,�̸�,�޿�,�������
select employee_id, first_name, salary, 
        case
           when salary<4000
           then '������'
           when salary<10000
           then '��տ���'
           else '����'
           end �������
from employees
order by salary desc;

�����ȣ, �̸�, �޿�, Ŀ�̼����Ա޿�, �޿����-Ŀ�̼����Ա޿� ( ��������)
select employee_id, first_name, salary, salary+salary*nvl(commission_pct, 0 ),
      case
      when salary+salary*nvl(commission_pct, 0 ) <3000
      then 'A'
      when salary+salary*nvl(commission_pct, 0 ) <6000
      then 'B'
      when salary+salary*nvl(commission_pct, 0 )<10000
      then 'C'
      when salary+salary*nvl(commission_pct, 0 ) < 15000
      then 'D'
      when salary+salary*nvl(commission_pct, 0 ) < 25000
      then 'E'
      else 'F'
      end �޿����
      from employees
order by salary+salary*nvl(commission_pct, 0 ) desc;

select *
from jobs;

select employee_id, last_name, job_id, case
     when job_id like 'AD_%'
     then 'Administration'
     when job_id like 'AC_%'
     then 'Accounting'
     when job_id like 'SA_%'
     then 'Sales'
     when job_id like 'IT_%'
     then 'IT'
     when job_id like 'MK_%'
     then 'Marketing'
     else 'Stock'
     end �����
from employees
order by employee_id asc;
select
    employee_id as ���
    , last_name as �̸�
    , job_id as �����ڵ�
    --, substr(lower(job_id),1, instr(job_id, '_' )-1)
    , case
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ad' then
            'Administration'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ac' then
            'Accounting'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'sa' then
            'Sales'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'st' then
            'Stock'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'it' then
            'It'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'mk' then
            'Marketing'
        else
            '����ξ���'
      end as "�����"
from
    employees
order by �����, employee_id;

--1980�⵵ �Ի� �ӿ�
--90�⵵            ����
--2000�⵵        ���Ի��
--���,�̸�,�Ի���, �������

select employee_id, first_name, hire_date,
          case
            when hire_date<to_date(to_char('19900101'),'yyyymmdd')
            then '�ӿ�'
            when hire_date< to_date(to_char('20000101'),'yyyy mm dd')
            then '����'
            else '���Ի��'
            end �������
from employees
order by hire_date asc;

select employee_id, first_name, hire_date,
          case
            when to_number(to_char(hire_date, 'yyyy'), '0000')<1990
            then '�ӿ�'
            when to_number(to_char(hire_date, 'yyyy'), '0000')<2000
            then '����'
            else '���Ի��'
            end �������
from employees
order by hire_date asc;

select job_id
from jobs;

select 
from employees;

select to_char(to_date(to_char(12341230, '00000000'), 'yyyymmdd'), ' yyyy mm dd')
from dual;

select concat(concat(concat(first_name,'�� �ٹ������ '),to_number(to_char(sysdate,'yyyy'),'0000')-to_number(to_char(hire_date,'yyyy'),'0000')),'�� �Դϴ�.')
from employees;

--�Ŵ��� ��ȣ�� 130�̸��� �ʺ�  130�̻� 150���ϴ� �߱� �׿ܴ� ����̴�. ��� �̸� �Ŵ�����ȣ�� ������������ �����϶�.

select employee_id, first_name, manager_id,
         case
         when manager_id <130
         then '�ʺ�'
         when manager_id >=130 and manager_id <= 150
         then '�߱�'
         else '���'
         end as "�Ŵ������"
from employees
order by manager_id desc;

select ascii('0'), ascii('A'), ascii('a')
from dual;