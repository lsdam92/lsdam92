
--non-equi join
--������� ���, �̸�, �޿� �޿����
select *
from job_grades;

select e.employee_id, e.first_name, e.salary, jd.grade_level
from employees e, job_grades jd
where e.salary between jd.lowest_sal and jd.highest_sal
order by salary desc;

select e.employee_id, e.first_name, e.salary, jd.grade_level
from employees e, job_grades jd
where e.salary >= jd.lowest_sal 
and e.salary <jd.highest_sal
order by salary desc;

--������� ���,�̸�, �μ���ȣ, �μ��̸�-----1

select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e , departments d
where e.department_id = d.department_id;

select *
from employees
where department_id is null;

--������� ���,�̸�, �μ���ȣ, �μ��̸�-----2
--��, �μ��� �������� ��� �μ��̸��� ' ���߷���'���� ���
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '���߷���')
from employees e , departments d
where e.department_id = d.department_id(+);

select e.employee_id, e.first_name, e.department_id, j.job_id
from employees e, departments d , jobs j
where e.department_id = d.department_id and e.job_id= j.job_id;


--outer join
--������� ���, �̸�, ������, ����̸�
--�� ����� ���� ��� ����̸��� '����'

select e.employee_id, e.first_name, ee.employee_id, nvl(ee.first_name, '����')
from employees e, employees ee
where e.manager_id = ee.employee_id(+);

--������� ���, �̸�, ������, ����̸�, �μ��̸�
--�� ����� ���� ��� ����̸��� '����'
--�� �μ��� �������� ��� �μ��̸��� '���߷���'���� ���

select e.employee_id, e.first_name, ee.employee_id, nvl(ee.first_name, '����') , nvl(d.department_name, '���߷�')
from employees e ,employees ee, departments d
where e.manager_id = ee.employee_id(+)
and e.department_id = d.department_id(+)
order by e.employee_id asc;

--------------------------------------------------------------------
--ANCI join
select *
from employess, departments;

select *
from employees cross join departments;

--50�� �μ��� ���, �̸�, �μ��̸�
--cross join
select e.employee_id, e.first_name, d.department_name
from employees e, departments d             --crossjoin�� ��� 160��
where e.department_id = d.department_id;
-- inner join on �� ���   inner join �� ����Ʈ�� inner �� �Ⱥپ o
select e.employee_id, e.first_name, d.department_name
from employees e inner join departments d        
on e.department_id = d.department_id
where e.department_id= 50;
-- inner join using               using �� ���� =���踦 ������� �ʾƵ��ȴ�
select e.employee_id, e.first_name, d.department_name
from employees e join departments d        
using (department_id)
where department_id= 50;
-- natural join �ΰ��� ���̺��� ���� column�� �ϳ� �� ��� ����
--ex)�� ��� department_id �� manager_id �ΰ��� column �� �����Ͽ� ���� ex)�� ���� �ٸ�
select e.employee_id, e.first_name, d.department_name
from employees e natural join departments d        
where department_id= 50;

--'seattle' �� �ٹ��ϴ� ���, �̸�, �μ��̸�, ����
select e.employee_id, first_name, d.department_name, l.city
from employees e, departments d, locations l
where  e.department_id= d.department_id 
and d.location_id = l.location_id
and l.city = 'Seattle';
-- join �� ����� join ���� �ݵ�� on �� �� ���;������� tab�� 3�� �̻��� ����� ����
select e.employee_id, first_name, d.department_name, l.city
from employees e join departments d
on  e.department_id= d.department_id
join locations l
on d.location_id = l.location_id
where lower(l.city) = lower('seattle');

--outer join
--��� ����� ���, �̸�, �μ���ȣ ,�μ��̸�
select e.employee_id , e.first_name, e.department_id , d.department_name
from employees e , departments d
where e.department_id = d.department_id(+);

select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '���߷���')
from employees e , departments d
where e.department_id = d.department_id(+);
--+�� ��ġ�� left/right �� ���� 
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '���߷���')
from employees e left outer join departments d
on e.department_id = d.department_id(+);

--��� �μ��� �ٹ��ϴ� ����� ���, �̸�, �μ���ȣ, �μ��̸�
-- + �� ��ġ�� ����
select e.employee_id, nvl(e.first_name,'�������'), d.department_id, d.department_name 
from employees e , departments d
where e.department_id = d.department_id(+);
-- +�� ��ġ�� right outer join ���� ����
select e.employee_id, nvl(e.first_name,'�������'), d.department_id, d.department_name 
from employees e right outer join departments d
on e.department_id = d.department_id;
--��� �μ��� ������� ���, �̸� ,�μ���ȣ, �μ��̸�
--+�� ��ġ�� ���ʿ� ���°�� full outer join 
select e.employee_id, nvl(e.first_name,'�������'), d.department_id, nvl(d.department_name, '���߷���') 
from employees e full outer join departments d
on e.department_id = d.department_id;


--�ڰ�����
--������� ���, �̸�, �μ��̸� ,�μ���ȣ , ������, ����̸� , ����μ���ȣ, ����μ��̸�
--null : �������, ���� , ���߷�
select e.employee_id, nvl(e.first_name,'�������') , nvl(d.department_name, '���߷�'),d.department_id ,ee.employee_id, nvl(ee.first_name,'����'),dd.department_id , nvl(dd.department_name,'���߷�')
from employees e 
left outer join employees ee
on e.manager_id = ee.employee_id
full outer join departments d
on e.department_id = d.department_id
full outer  join departments dd
on ee.department_id = dd.department_id;

--'americas'�� �ٹ��ϴ� ��� �̸� �μ��̸� �����̸�, �����̸�
--join Ȱ��
select employee_id, first_name, department_name, city, region_name
from employees e, departments d, locations l , countries c , regions g
where e.department_id = d.department_id 
and c.country_id = l.country_id
and d.location_id = l.location_id 
and c.region_id = g.region_id
and lower(g.region_name) = lower('americas')
order by employee_id;
--��� ����� �̸� �μ��̸� �����̸�, �����̸�
--join Ȱ�� null �� ����� �������.
select e.employee_id, nvl(e.first_name,'�������'), d.department_name, l.city, r.region_name, e.department_id
from employees e , departments d , locations l , countries c , regions r
where e.department_id = d.department_id(+)
and d.location_id = l. location_id(+)
and l.country_id = c.country_id(+)
and c.region_id = r.region_id(+);


select e.employee_id, nvl(e.first_name,'�������'), d.department_name, l.city, r.region_name, e.department_id
from employees e left outer join departments d
on e.department_id = d.department_id
join locations l 
using (location_id)
join countries
using (country_id)
join regions r
using (region_id);

select e.employee_id, nvl(e.first_name,'�������')
from employees e right outer join departments d 
on e.department_id = d.department_id;

select e.employee_id, nvl(e.first_name,'�������')
from employees e full outer join departments d
on e.department_id = d.department_id;

select e.employee_id, nvl(e.first_name,'�������')
from employees e , departments d
where e.department_id = d.department_id(+)
