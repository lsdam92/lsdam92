
--non-equi join
--모든사원의 사번, 이름, 급여 급여등급
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

--모든사원의 사번,이름, 부서번호, 부서이름-----1

select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e , departments d
where e.department_id = d.department_id;

select *
from employees
where department_id is null;

--모든사원의 사번,이름, 부서번호, 부서이름-----2
--단, 부서가 미지정일 경우 부서이름을 ' 대기발령중'으로 출력
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '대기발령중')
from employees e , departments d
where e.department_id = d.department_id(+);

select e.employee_id, e.first_name, e.department_id, j.job_id
from employees e, departments d , jobs j
where e.department_id = d.department_id and e.job_id= j.job_id;


--outer join
--모든사원의 사번, 이름, 상관사번, 상관이름
--단 상관이 없을 경우 상관이름에 '사장'

select e.employee_id, e.first_name, ee.employee_id, nvl(ee.first_name, '사장')
from employees e, employees ee
where e.manager_id = ee.employee_id(+);

--모든사원의 사번, 이름, 상관사번, 상관이름, 부서이름
--단 상관이 없을 경우 상관이름에 '사장'
--단 부서가 미지정일 경우 부서이름을 '대기발령중'으로 출력

select e.employee_id, e.first_name, ee.employee_id, nvl(ee.first_name, '사장') , nvl(d.department_name, '대기발령')
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

--50번 부서의 사번, 이름, 부서이름
--cross join
select e.employee_id, e.first_name, d.department_name
from employees e, departments d             --crossjoin일 경우 160개
where e.department_id = d.department_id;
-- inner join on 을 사용   inner join 은 디폴트값 inner 가 안붙어도 o
select e.employee_id, e.first_name, d.department_name
from employees e inner join departments d        
on e.department_id = d.department_id
where e.department_id= 50;
-- inner join using               using 절 사용시 =관계를 사용하지 않아도된다
select e.employee_id, e.first_name, d.department_name
from employees e join departments d        
using (department_id)
where department_id= 50;
-- natural join 두개의 테이블에서 같은 column이 하나 일 경우 쓰임
--ex)의 경우 department_id 와 manager_id 두개의 column 이 존재하여 위의 ex)와 값이 다름
select e.employee_id, e.first_name, d.department_name
from employees e natural join departments d        
where department_id= 50;

--'seattle' 에 근무하는 사번, 이름, 부서이름, 도시
select e.employee_id, first_name, d.department_name, l.city
from employees e, departments d, locations l
where  e.department_id= d.department_id 
and d.location_id = l.location_id
and l.city = 'Seattle';
-- join 을 쓸경우 join 다음 반드시 on 절 이 나와야함으로 tab이 3개 이상인 경우의 예시
select e.employee_id, first_name, d.department_name, l.city
from employees e join departments d
on  e.department_id= d.department_id
join locations l
on d.location_id = l.location_id
where lower(l.city) = lower('seattle');

--outer join
--모든 사원의 사번, 이름, 부서번호 ,부서이름
select e.employee_id , e.first_name, e.department_id , d.department_name
from employees e , departments d
where e.department_id = d.department_id(+);

select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '대기발령중')
from employees e , departments d
where e.department_id = d.department_id(+);
--+의 위치를 left/right 로 지정 
select e.employee_id, e.first_name, e.department_id, nvl(d.department_name, '대기발령중')
from employees e left outer join departments d
on e.department_id = d.department_id(+);

--모든 부서에 근무하는 사원의 사번, 이름, 부서번호, 부서이름
-- + 의 위치를 지정
select e.employee_id, nvl(e.first_name,'사원없음'), d.department_id, d.department_name 
from employees e , departments d
where e.department_id = d.department_id(+);
-- +의 위치를 right outer join 으로 지정
select e.employee_id, nvl(e.first_name,'사원없음'), d.department_id, d.department_name 
from employees e right outer join departments d
on e.department_id = d.department_id;
--모든 부서와 모든사원의 사번, 이름 ,부서번호, 부서이름
--+의 위치가 양쪽에 들어가는경우 full outer join 
select e.employee_id, nvl(e.first_name,'사원없음'), d.department_id, nvl(d.department_name, '대기발령중') 
from employees e full outer join departments d
on e.department_id = d.department_id;


--자가문제
--모든사원의 사번, 이름, 부서이름 ,부서번호 , 상관사번, 상관이름 , 상관부서번호, 상관부서이름
--null : 사원없음, 사장 , 대기발령
select e.employee_id, nvl(e.first_name,'사원없음') , nvl(d.department_name, '대기발령'),d.department_id ,ee.employee_id, nvl(ee.first_name,'사장'),dd.department_id , nvl(dd.department_name,'대기발령')
from employees e 
left outer join employees ee
on e.manager_id = ee.employee_id
full outer join departments d
on e.department_id = d.department_id
full outer  join departments dd
on ee.department_id = dd.department_id;

--'americas'에 근무하는 사원 이름 부서이름 도시이름, 국가이름
--join 활용
select employee_id, first_name, department_name, city, region_name
from employees e, departments d, locations l , countries c , regions g
where e.department_id = d.department_id 
and c.country_id = l.country_id
and d.location_id = l.location_id 
and c.region_id = g.region_id
and lower(g.region_name) = lower('americas')
order by employee_id;
--모든 사원의 이름 부서이름 도시이름, 국가이름
--join 활용 null 은 사원은 사원없음.
select e.employee_id, nvl(e.first_name,'사원없음'), d.department_name, l.city, r.region_name, e.department_id
from employees e , departments d , locations l , countries c , regions r
where e.department_id = d.department_id(+)
and d.location_id = l. location_id(+)
and l.country_id = c.country_id(+)
and c.region_id = r.region_id(+);


select e.employee_id, nvl(e.first_name,'사원없음'), d.department_name, l.city, r.region_name, e.department_id
from employees e left outer join departments d
on e.department_id = d.department_id
join locations l 
using (location_id)
join countries
using (country_id)
join regions r
using (region_id);

select e.employee_id, nvl(e.first_name,'사원없음')
from employees e right outer join departments d 
on e.department_id = d.department_id;

select e.employee_id, nvl(e.first_name,'사원없음')
from employees e full outer join departments d
on e.department_id = d.department_id;

select e.employee_id, nvl(e.first_name,'사원없음')
from employees e , departments d
where e.department_id = d.department_id(+)
