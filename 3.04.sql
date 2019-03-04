--3.04
--union        ������ �ߺ� ����
--union all    ������ �ߺ�����
--intersect   ������
--minus  A�� B ���� A-B �� �Ѱ�

--�μ���ȣ�� 50�̰ų� 90�� �����
--�޿��� 5000�̻��� ���
--���, �̸�, �޿�, �μ���ȣ
--union �ߺ��� ����
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union
select employee_id, first_name, salary, department_id
from employees
where salary>=10000;
--union all �ߺ��� ���
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union all
select employee_id, first_name, salary, department_id
from employees
where salary>=10000;
--intersect  ������ - �ߺ��Ȱ��� ���
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
intersect
select employee_id, first_name, salary, department_id
from employees
where salary>=10000;
--minus �ߺ������� ( A -B )�� (B- A) �� ���� �ٸ�. 
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
minus
select employee_id, first_name, salary, department_id
from employees
where salary>=10000;
--minus 2   (B-A)
select employee_id, first_name, salary, department_id
from employees
where salary>=10000
minus
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90);

--Group by
--�μ��� ����, ��ձ޿�, �����, �ִ�޿�, �ּұ޿�

select department_id, sum(salary), avg(Salary), count(employee_id), max (Salary), min(salary)
from employees
group by department_id;
--�μ��� ����, ��ձ޿�, �����, �ִ�޿�, �ּұ޿�
--��ձ޿��� 5000������ �μ�
select department_id, sum(salary), avg(Salary), count(employee_id), max (Salary), min(salary)
from employees
where salary = all(select max(salary) from employees group by department_id)
group by department_id;

--�μ��� ����, ��ձ޿�, �����, �ִ�޿�, �ּұ޿�
--��ձ޿��� 5000������ �μ�
select department_id, sum(salary), avg(Salary), count(employee_id), max (Salary), min(salary)
from employees
group by department_id having avg(salary)<=5000;--�׷�ȭ�� �Լ������� having�� ��� / �Ϲ��Լ������� where ��

--�� �μ��� ��� �޿����� ���� �޴� �����   - ���μ����� ��ձ޿����� �̹Ƿ� ���μ��� ��ձ޿��� �������� �����ϴ� ����ū�� (���μ���o/���μ�����x)
--���, �̸�, �޿�
select department_id, employee_id, first_name ,salary
from employees
where salary = any(select max(salary)
                        from employees
                        group by department_id);

select avg(salary)
from employees
group by department_id;

--�μ����� �ְ�޿��� �޴� �����
--�μ��̸�, ���, �̸�, �޿�

select department_name, employee_id, first_name ,salary
from employees e, departments d
where e.department_id = d.department_id(+) and  salary = any(select max(salary) --department_id ���� ��½� ���� salary�� ������� ���  -������ "���μ�����"
                                                                                from employees
                                                                                group by department_id);

select d.department_name, e.employee_id, e.salary
from employees e , (select department_id, max(salary) msal
                            from employees
                            group by department_id) m, departments d
where e.department_id = m. department_id
and e.salary = m.msal
and e.department_id = d. department_id;
--rounum ���ȣ
select rownum, employee_id, salary
from employees;
--rownum�� �۴� �� ���� Ŀ���°��� �� �Ұ�
select rownum, employee_id, salary
from employees
where rownum <=10
and rownum >5; -- 5���� ū���̹Ƿ� ���Ѵ���� �̹Ƿ� �Ұ�

select employee_id, salary
from employees
order by employee_id asc;

select rownum, employee_id, salary
from employees
order by employee_id desc;

--���� , ���, �̸�, �޿� , �Ի�⵵, �μ��̸�
--�޿��� ����
--�� �������� 5�� ���
--2page ���
--1980���, 1990���, 2000���
select salary
from employees 
order by salary desc;

select rownum , e.employee_id, e.first_name ,e.salary, d.department_name,
            case
                when to_char(e.hire_date,'yy') between 80 and 89 
                then '1980���'
                when  to_char(e.hire_date,'yy') between 90 and 99
                then '1990���'
                else '2000���'
                end �Ի�⵵
from employees e, departments d
where e.department_id = d.department_id(+)
order by e.salary desc;

select rownum, employee_id,salary
from employees
order by salary desc;

select rownum, e.employee_id, e.first_name ,e.salary, d.department_name, to_char(hire_date, 'yyyy') �Ի�⵵
from employees e, departments d, (select rownum, employee_id
from employees) 
where e.department_id = d.department_id(+) and  dd.employee_id= e.employee_id
order by e.salary desc;

select rownum "����", e.employee_id ,e.first_name, e.salary ,
            case
                when to_char(e.hire_date,'yy') between 80 and 89 
                then '1980���'
                when  to_char(e.hire_date,'yy') between 90 and 99
                then '1990���'
                else '2000���'
                end �Ի�⵵ , department_name
from employees e , (select e.employee_id, e.first_name ,e.salary, d.department_name
                            from employees e, departments d
                            where e.department_id = d.department_id(+)
                            order by e.salary desc) ee
where e.employee_id = ee.employee_id and rownum <= 5*&page;

select  bbb.ranking , bbb.employee_id, bbb.salary ,bbb.department_name, 
            case
                when to_char(bbb.hire_date,'yy') between 80 and 89 
                then '1980���'
                when  to_char(bbb.hire_date,'yy') between 90 and 99
                then '1990���'
                else '2000���'
                end �Ի�⵵
 from (select rownum ranking, ee.employee_id ,ee.first_name, ee.salary , d.department_name
         from departments dd , (select e.employee_id, e.first_name ,e.salary, d.department_id
                                                                    from employees e, departments d
                                                                    where e.department_id = d.department_id(+)
                                                                    order by e.salary desc) ee , departments ddd
         where ee.employee_id = employee_id and rownum <= 5*&page) bbb
where bbb.ranking >&page*5 -5;
--��
select ee.rn ranking , ee.employee_id , ee.first_name , ee.salary , dd.department_name
from  (select rownum rn , e.* , d.department_name
            from (select employee_id, first_name , salary, department_id
                        from employees 
                        order by salary desc) e , departments d
            where e.department_id = d.department_id(+) and rownum <= 5*&page) ee , departments dd
where ee.department_id = dd.department_id(+) and ee.rn > &page*5 -5
order by ranking asc;

