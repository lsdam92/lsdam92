--���, �̸�, �μ���ȣ, ���� ����
--��������
--�μ���ȣ 60������
--            90 �ӿ���
--������ �񰳹���
              
select employee_id, first_name,department_id,
     case
      when department_id = 60
       then '������'
       when department_id = 90
       then '�ӿ���'
       else '�񰳹���'
       end ��������
from employees
order by department_id;

-- case when then : ��� ���� ex) when 3000< x1 then '������' when  5000<x2 then '�ӿ���' else '�񰳹���' end ��������
--  decode( x1 : ��� , x2 ,x3 , xN ) ���پƴϴٸ� �񱳰���
select employee_id, first_name,department_id,
     decode(department_id,
                    60, '������',
                    90, '�ӿ���',
                    '�񰳹���') ��������
from employees
order by department_id;

--�׷��Լ�
--ȸ���� �ѻ����, �޿�����, �޿����, �ְ�޿�, �����޿�
--count  ,sum , avg , max, min �����Լ�
select count(employee_id), sum(salary), avg(salary), max(salary), min(salary) 
from employees;

--��ձ޿����� ���� �޴»���� ���, �̸�, �޿�

select avg(salary)
from employees;

select employee_id, first_name, salary
from employees
where salary > (select avg(salary) from employees);


-- JOIN / join 
--���, �̸�, �μ���ȣ, �μ��̸�
select employee_id, first_name, department_id, department_name
from employees;

select department_id, department_name
from departments;
--1 cartesian join(cross join)
select *
from employees, departments
order by employee_id;
--2
select *
from employees, departments
where employees.department_id = departments.department_id
order by employee_id;
--3 equi join( natural join)
select employees.employee_id, employees.first_name, departments.department_id, departments.department_name
from employees, departments
where employees.department_id = departments.department_id
order by employee_id;
--4 ���̺� ��Ī����  join
select e.employee_id, e.first_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id
order by employee_id;

--'seattle'�� �ٹ��ϴ� ����� ���, �̸�, �μ��̸�, �����̸�
select e.employee_id, e.first_name, d.department_name, city 
from employees e, departments d, locations l
where e.department_id = d.department_id and l.location_id = d.location_id and lower(l.city) =lower('seattle')
order by employee_id;

--'americas'�� �ٹ��ϴ� ��� �̸� �μ��̸� �����̸�
select employee_id, first_name, department_name, city, region_name
from employees e, departments d, locations l , countries c , regions g
where e.department_id = d.department_id 
and c.country_id = l.country_id
and d.location_id = l.location_id 
and c.region_id = g.region_id
and lower(g.region_name) = lower('americas')
order by employee_id;
--10, 80 90�� �μ����ٹ����λ����
--���, �̸�, ��å�̸�, �μ��̸�

select e.employee_id, e.first_name, d.department_name, j.job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id 
and e.job_id = j.job_id 
and e.department_id in (10, 80, 90) ;

--����� 200�� ����Ǳٹ� �̷�
--���, �̸�, ��å�̸�(�ٹ����), �μ��̸�(�ٹ����),  �ٹ�����(�Ҽ�2�ڸ�)

select e.employee_id, e.first_name, j.job_title , department_name, to_char(months_between(end_date, jh.start_date), '999.99')
from employees e, job_history jh, jobs j, departments d
where e.employee_id = jh.employee_id
and jh.job_id = j.job_id
and jh.department_id = d.department_id
and jh.employee_id = 200;


--��å ���̵� 'SA_REP' �� �����
--���, �̸�, ��å�̸�, �μ��̸�
--��, �μ��� ���� ��� '���߷�' ���� ���

select employee_id, first_name, job_title, nvl(department_name, '���߷�') 
from employees e , departments d, jobs j
where e.department_id = d.department_id and e.job_id = j.job_id and lower(j.job_id) = lower('sa_rep');

--

select employee_id, first_name, job_title, department_name 
from employees e , departments d, jobs j
where e.manager_id = d.manager_id and e.job_id = j.job_id and lower(j.job_id) = lower('sa_rep');

--self join
--������� �μ��̸�, ���, �̸�, �Ŵ�����ȣ, �Ŵ����̸�

select d.department_name, e.employee_id, e.first_name, ee.employee_id, ee.first_name 
from employees e,  employees ee, departments d
where e.manager_id = ee.employee_id
and e.department_id = d.department_id;




select *
from employees
order by manager_id asc;