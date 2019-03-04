--사번, 이름, 부서번호, 직원 유형
--직원유형
--부서번호 60개발자
--            90 임원진
--나머지 비개발자
              
select employee_id, first_name,department_id,
     case
      when department_id = 60
       then '개발자'
       when department_id = 90
       then '임원진'
       else '비개발자'
       end 직원유형
from employees
order by department_id;

-- case when then : 등가비교 가능 ex) when 3000< x1 then '개발자' when  5000<x2 then '임원진' else '비개발자' end 직원유형
--  decode( x1 : 대상 , x2 ,x3 , xN ) 같다아니다만 비교가능
select employee_id, first_name,department_id,
     decode(department_id,
                    60, '개발자',
                    90, '임원진',
                    '비개발자') 직원유형
from employees
order by department_id;

--그룹함수
--회사의 총사원수, 급여총합, 급여평균, 최고급여, 최저급여
--count  ,sum , avg , max, min 단일함수
select count(employee_id), sum(salary), avg(salary), max(salary), min(salary) 
from employees;

--평균급여보다 많이 받는사원의 사번, 이름, 급여

select avg(salary)
from employees;

select employee_id, first_name, salary
from employees
where salary > (select avg(salary) from employees);


-- JOIN / join 
--사번, 이름, 부서번호, 부서이름
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
--4 테이별 별칭으로  join
select e.employee_id, e.first_name, d.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id
order by employee_id;

--'seattle'에 근무하는 사원의 사번, 이름, 부서이름, 도시이름
select e.employee_id, e.first_name, d.department_name, city 
from employees e, departments d, locations l
where e.department_id = d.department_id and l.location_id = d.location_id and lower(l.city) =lower('seattle')
order by employee_id;

--'americas'에 근무하는 사원 이름 부서이름 도시이름
select employee_id, first_name, department_name, city, region_name
from employees e, departments d, locations l , countries c , regions g
where e.department_id = d.department_id 
and c.country_id = l.country_id
and d.location_id = l.location_id 
and c.region_id = g.region_id
and lower(g.region_name) = lower('americas')
order by employee_id;
--10, 80 90번 부서에근무중인사원의
--사번, 이름, 직책이름, 부서이름

select e.employee_id, e.first_name, d.department_name, j.job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id 
and e.job_id = j.job_id 
and e.department_id in (10, 80, 90) ;

--사번이 200인 사원의근무 이력
--사번, 이름, 직책이름(근무당시), 부서이름(근무당시),  근무개월(소수2자리)

select e.employee_id, e.first_name, j.job_title , department_name, to_char(months_between(end_date, jh.start_date), '999.99')
from employees e, job_history jh, jobs j, departments d
where e.employee_id = jh.employee_id
and jh.job_id = j.job_id
and jh.department_id = d.department_id
and jh.employee_id = 200;


--직책 아이디가 'SA_REP' 인 사원의
--사번, 이름, 직책이름, 부서이름
--단, 부서가 없는 경우 '대기발령' 으로 출력

select employee_id, first_name, job_title, nvl(department_name, '대기발령') 
from employees e , departments d, jobs j
where e.department_id = d.department_id and e.job_id = j.job_id and lower(j.job_id) = lower('sa_rep');

--

select employee_id, first_name, job_title, department_name 
from employees e , departments d, jobs j
where e.manager_id = d.manager_id and e.job_id = j.job_id and lower(j.job_id) = lower('sa_rep');

--self join
--모든사원의 부서이름, 사번, 이름, 매니저번호, 매니저이름

select d.department_name, e.employee_id, e.first_name, ee.employee_id, ee.first_name 
from employees e,  employees ee, departments d
where e.manager_id = ee.employee_id
and e.department_id = d.department_id;




select *
from employees
order by manager_id asc;