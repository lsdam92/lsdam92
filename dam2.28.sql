
--SubQuery
--�μ��̸��� 'it'�� �ٹ��ϴ� ����� ���, �̸�, �޿�

select e.employee_id, e.first_name, e.salary
from employees e,departments d
where e.department_id = d.department_id 
and d.department_name = 'IT';
--1
select department_id
    from departments
    where department_name = 'IT';
--2
select employee_id , first_name, salary
                from employees s 
where department_id = '60';

--1������ ���� 2�� where ���� ����   = ������ column�� �����Ƿ� ( )�ؼ� ���� ��� 

select employee_id , first_name, salary
from employees s 
where department_id = (select department_id
                                from departments
                                where department_name = 'IT');
                                
-- 'Seattle' ��  �ٹ��ϴ� ����� ���, �̸�, �޿�
--Sub Query
select location_id
from locations
where city = 'Seattle';

select department_id
from departments
where location_id = (select location_id
                           from locations
                           where city = 'Seattle');

select employee_id, first_name, salary
from employees
where department_id in (select department_id
                               from departments
                               where location_id = (select location_id
                                                          from locations
                                                          where city = 'Seattle'));


-- ������ȣ�� 1700�� �μ����� ���ϴ� �����
--���, �̸�, �μ���ȣ, �μ��̸�

select e.employee_id , e.first_name , e.department_id , d.department_name
from departments d, employees e
where e.department_id = d.department_id and d.location_id = 1700;

select department_id, department_name
from departments
where location_id = 1800;
-- SubQuery �� from ������ ��� ���� 
select e.employee_id , e.first_name , e.department_id , d.department_name
from  employees e , (select department_id, department_name
                            from departments
                            where location_id = 1800) d
where e.department_id = d.department_id;

--'Kevin' ���� �޿��� ���� �޴� ����� ���, �̸� ,�޿�

select salary
from employees
where first_name = 'Kevin';

select e.employee_id, e.first_name, e.salary
from  employees e
where e.salary >  (select salary
                                from employees
                                where first_name = 'Kevin');

--80�� �μ��� �ִ� ����� ���� �޿��� ���� �޴� ����� ��� ,�̸� ,�޿�

select max(salary)
from employees
where department_id = 80;

select e.employee_id , e.first_name , e.salary
from employees e
where e.salary > all (select(salary)
                            from employees
                            where department_id = 80);

select e.employee_id , e.first_name , e.salary
from employees e
where e.salary > any (select(salary)
                            from employees
                            where department_id = 80);      


--�μ���ȣ�� 20���� ��ձ޿����� ũ��,
--�μ����� 20�� �ƴ� �����
--���, �̸� ,�޿� ,�μ���ȣ

select avg(salary)
from employees
where department_id = 20;

select employee_id, first_name, salary
from employees
where salary >(select avg(salary)
                    from employees
                    where department_id = 20);



select e.employee_id , e.first_name , e.salary , e.department_id
from employees e , departments d
where e.employee_id = d.manager_id
and e.salary >(select avg(salary)
                    from employees
                    where department_id = 20)
 and d.department_id  !=20;

--20�� �μ��� ��ձ޿�
--50�� �μ��� �޿�����
--80�� �μ��� �ο���  select�� SubQuery���϶��� �����ุ ����
select
                (select avg(salary) from employees where department_id = 20),
                (select sum(salary)from employees where department_id =50),
                (select count(employee_id)from employees where department_id = 80)
                from dual;

--������� ���, �̸�, �޿�, ���, �μ��̸�
--��, A�� 1���, B�� 2��� ... F��� 6���
select
(select employee_id, first_name, salary from employees),
(select department_name from departments),
(select grade_level from job_grades)
from dual;

select case
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'A'
then '1���'
when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'B'
then '2���'
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'C'
then '3���'
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'D'
then '4���'
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'E'
then '5���'
else '6���'
end grade_level
from job_grades, employees e;


select grade_level, lowest_sal, highest_sal
from job_grades;


select e.employee_id, e.first_name, e.salary, case
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'A'
                                                        then '1���'
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'B'
                                                        then '2���
                                                        'when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'C'
                                                        then '3���'
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'D'
                                                        then '4���'
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'E'
                                                        then '5���'
                                                        else '6���'
                                                        end ��� , d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);   

select e.employee_id, e.first_name, e.salary, decode((select grade_level from job_grades where e.salary between lowest_sal and highest_sal),
                                                                'A', '1���',
                                                                'B', '2���',
                                                                'C', '3���',
                                                                'D', '4���',
                                                                'E', '5���',
                                                                '6���') ���, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);       