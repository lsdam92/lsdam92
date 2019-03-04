select location_id, postal_code
from locations
where city='Seattle';

--�޿��� 5000�̻� 12000�̸��� �޴� ���, �̸�, �޿�, �μ���ȣ
select first_name, salary, department_id
from employees
where salary>=5000 and salary<12000;

--�μ���ȣ�� 50�� ��� �� �޿��� 5000�̻� �޴� ����� ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where department_id = 50 and salary>=5000;
----�޿��� 5000�̻� 12000���ϸ� �޴� ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where salary between 5000 and 12000;

----�޿��� 5000�̻� 12000���ϸ� �޴� ���, �̸�, �޿�, �μ���ȣ
select employee_id, first_name, salary, department_id
from employees
where salary between 5000 and 12000;  -- between �� �̸� �Ұ���.

--Ŀ�̼��� �޴� ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿�
select employee_id, first_name, salary, salary+salary*nvl(commission_pct, 0)
from employees
where salary<salary+salary*commission_pct;

--�ٹ��μ��� 50, 60, 80�� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id
from employees
where department_id = 50 or department_id = 60 or department_id = 80;

select employee_id, first_name, department_id
from employees
where department_id in(50, 60, 80);

--�ٹ��μ��� 50, 60, 80�� �ƴ� ����� ���, �̸�, �μ���ȣ
select employee_id, first_name, department_id
from employees
where department_id !=50 and department_id !=60 and department_id != 80;

select employee_id, first_name, department_id
from employees
where department_id not in(50, 60, 80);

--�޿��� 3000�̻� �̰ų� 8000�̻��̰ų� 5000�̻��� ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary>=3000 or salary>=8000 or salary>=5000;

select employee_id, first_name, salary
from employees
where salary >= any (3000, 8000, 5000);

--�޿��� 3000�̻��̰� 8000�̻��̰� 5000�̻��� ����� ���, �̸�, �޿�
select employee_id, first_name, salary
from employees
where salary >=3000
and salary >=5000
and salary >=8000;

select employee_id, first_name, salary
from employees
where salary >= all (3000, 8000, 5000);    --all �� �����������  any �� �κ�

--����ð�, 3����, 3�ð���             to_char(sysdate �ý��۳�¥, '��.��.��.��.��.��')
select sysdate, to_char(sysdate, 'yy.mm.dd.hh24:mi:ss'),
        to_char(sysdate+3, 'yy.mm.dd.hh24:mi:ss')"3����",
        to_char(sysdate+3/24, 'yy.mm.dd.hh24:mi:ss')"3�ð���"
from dual;

--�̸��� steven�� ����� ���, �̸�
select employee_id, first_name
from employees
where first_name = 'Steven';

--�̸��� S�� �����ϴ� ����� ���, �̸�  - %�������� ��� ���� ���x
select employee_id, first_name
from employees
where first_name like 'S%';

--�̸��� e�� �����ϰ��ִ� ����� ���, �̸�
select employee_id, first_name
from employees
where first_name like '%e%';

--�̸��� y�� ������ ����� ���, �̸�
select employee_id, first_name
from employees
where first_name like '%y';

--�̸����� ������ ����°�� e�� ����� ���, �̸�   _ : �������� ��� x � o �ڸ����ǹ� 
select employee_id, first_name
from employees
where first_name like '%e__';             

--�μ���ȣ�� 50�� �ƴ� ����� ���, �̸�, �μ���ȣ            != , ^= , <> not���� =�ǹݴ�
select employee_id, first_name, department_id
from employees
where department_id != 50;

select employee_id, first_name, department_id
from employees
where department_id ^= 50;

select employee_id, first_name, department_id
from employees
where department_id <> 50;

--��� ����� ���, �̸�, �޿�     desc :  ��������  asc : ��������
--�� �޿���
select employee_id, first_name, salary
from employees
order by salary desc;

--�μ���ȣ, ���, �̸�, �޿�
--�μ��� �޿������� ����
select department_id, employee_id, first_name, salary
from employees
order by department_id, salary desc;

select department_id did, employee_id, first_name, salary sal
from employees
order by did, sal desc;

--�ٹ����ð� Seattle�� ����� ���, �̸�, �μ���ȣ     ������ table�� �̿��Ͽ� �������� select�� ������
select *
from locations
where city = 'Seattle';

select *
from departments
where location_id = 1700;

select employee_id, first_name, department_id
from employees
where department_id in (10, 90, 110, 190);

select *
from regions
where region_name = 'Americas';

select *
from countries
where region_id = 2;

select *
from locations
where country_id in ('CA', 'US');

select *
from departments
where location_id in ( 1800, 1400, 1500, 1700);

select employee_id, first_name, salary
from employees
where manager_id in (103,124,200,100,205,201)
order by salary desc;

select max(salary)
from employees
where manager_id in (103,124,200,100,205,201);

select employee_id, first_name, salary
from employees
where manager_id in (103,124,200,100,205,201) and salary = 17000;

select *
from employees;
--�޿��� 12000�̻��� ����,���, �̸�, �μ���ȣ, �޿�

select employee_id, first_name, department_id, salary, job_id
from employees
where salary>=12000;

select *
from departments
where department_id in(90, 20, 110);

select *
from locations
where location_id in (1700, 1800);

select employee_id, first_name, salary
from employees
where salary>=12000;

select *
from employees;

select *
from jobs;

select employee_id, first_name || ' '||last_name, hire_date,salary+salary*nvl(commission_pct, 0), department_id
from employees
where job_id = 'AD_PRES';

select 123456789
from dual;