
--SubQuery
--부서이름이 'it'에 근무하는 사원의 사번, 이름, 급여

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

--1에서의 값을 2의 where 값에 대입   = 다음은 column이 나오므로 ( )해서 먼저 계산 

select employee_id , first_name, salary
from employees s 
where department_id = (select department_id
                                from departments
                                where department_name = 'IT');
                                
-- 'Seattle' 에  근무하는 사원의 사번, 이름, 급여
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


-- 지역번호가 1700인 부서에서 일하는 사원의
--사번, 이름, 부서번호, 부서이름

select e.employee_id , e.first_name , e.department_id , d.department_name
from departments d, employees e
where e.department_id = d.department_id and d.location_id = 1700;

select department_id, department_name
from departments
where location_id = 1800;
-- SubQuery 는 from 절에도 사용 가능 
select e.employee_id , e.first_name , e.department_id , d.department_name
from  employees e , (select department_id, department_name
                            from departments
                            where location_id = 1800) d
where e.department_id = d.department_id;

--'Kevin' 보다 급여를 많이 받는 사원의 사번, 이름 ,급여

select salary
from employees
where first_name = 'Kevin';

select e.employee_id, e.first_name, e.salary
from  employees e
where e.salary >  (select salary
                                from employees
                                where first_name = 'Kevin');

--80번 부서에 있는 사원들 보다 급여를 많이 받는 사원의 사번 ,이름 ,급여

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


--부서번호가 20번의 평균급여보다 크고,
--부서장이 20이 아닌 사원의
--사번, 이름 ,급여 ,부서번호

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

--20번 부서의 평균급여
--50번 부서의 급여총합
--80번 부서의 인원수  select를 SubQuery쓰일때는 단일행만 가능
select
                (select avg(salary) from employees where department_id = 20),
                (select sum(salary)from employees where department_id =50),
                (select count(employee_id)from employees where department_id = 80)
                from dual;

--모든사원의 사번, 이름, 급여, 등급, 부서이름
--단, A는 1등급, B는 2등급 ... F등급 6등급
select
(select employee_id, first_name, salary from employees),
(select department_name from departments),
(select grade_level from job_grades)
from dual;

select case
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'A'
then '1등급'
when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'B'
then '2등급'
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'C'
then '3등급'
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'D'
then '4등급'
when (select grade_level from job_grades  where e.salary between lowest_sal and highest_sal) = 'E'
then '5등급'
else '6등급'
end grade_level
from job_grades, employees e;


select grade_level, lowest_sal, highest_sal
from job_grades;


select e.employee_id, e.first_name, e.salary, case
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'A'
                                                        then '1등급'
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'B'
                                                        then '2등급
                                                        'when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'C'
                                                        then '3등급'
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'D'
                                                        then '4등급'
                                                        when (select grade_level from job_grades where e.salary between lowest_sal and highest_sal) = 'E'
                                                        then '5등급'
                                                        else '6등급'
                                                        end 등급 , d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);   

select e.employee_id, e.first_name, e.salary, decode((select grade_level from job_grades where e.salary between lowest_sal and highest_sal),
                                                                'A', '1등급',
                                                                'B', '2등급',
                                                                'C', '3등급',
                                                                'D', '4등급',
                                                                'E', '5등급',
                                                                '6등급') 등급, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);       