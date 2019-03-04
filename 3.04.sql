--3.04
--union        합집합 중복 제거
--union all    합집합 중복포함
--intersect   교집합
--minus  A와 B 에서 A-B 를 한값

--부서번호가 50이거나 90인 사원과
--급여가 5000이상인 사원
--사번, 이름, 급여, 부서번호
--union 중복값 제거
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union
select employee_id, first_name, salary, department_id
from employees
where salary>=10000;
--union all 중복값 출력
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
union all
select employee_id, first_name, salary, department_id
from employees
where salary>=10000;
--intersect  교집합 - 중복된값만 출력
select employee_id, first_name, salary, department_id
from employees
where department_id in (50, 90)
intersect
select employee_id, first_name, salary, department_id
from employees
where salary>=10000;
--minus 중복값제거 ( A -B )와 (B- A) 의 값은 다름. 
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
--부서별 총합, 평균급여, 사원수, 최대급여, 최소급여

select department_id, sum(salary), avg(Salary), count(employee_id), max (Salary), min(salary)
from employees
group by department_id;
--부서별 총합, 평균급여, 사원수, 최대급여, 최소급여
--평균급여가 5000이하인 부서
select department_id, sum(salary), avg(Salary), count(employee_id), max (Salary), min(salary)
from employees
where salary = all(select max(salary) from employees group by department_id)
group by department_id;

--부서별 총합, 평균급여, 사원수, 최대급여, 최소급여
--평균급여가 5000이하인 부서
select department_id, sum(salary), avg(Salary), count(employee_id), max (Salary), min(salary)
from employees
group by department_id having avg(salary)<=5000;--그룹화한 함수에서는 having절 사용 / 일반함수에서는 where 절

--각 부서의 평균 급여보다 많이 받는 사원의   - 각부서별의 평균급여보다 이므로 각부서의 평균급여중 모든평균을 포함하는 가장큰값 (각부서별o/각부서마다x)
--사번, 이름, 급여
select department_id, employee_id, first_name ,salary
from employees
where salary = any(select max(salary)
                        from employees
                        group by department_id);

select avg(salary)
from employees
group by department_id;

--부서마다 최고급여를 받는 사원의
--부서이름, 사번, 이름, 급여

select department_name, employee_id, first_name ,salary
from employees e, departments d
where e.department_id = d.department_id(+) and  salary = any(select max(salary) --department_id 없이 출력시 같은 salary의 모든사원을 출력  -문제는 "각부서마다"
                                                                                from employees
                                                                                group by department_id);

select d.department_name, e.employee_id, e.salary
from employees e , (select department_id, max(salary) msal
                            from employees
                            group by department_id) m, departments d
where e.department_id = m. department_id
and e.salary = m.msal
and e.department_id = d. department_id;
--rounum 행번호
select rownum, employee_id, salary
from employees;
--rownum은 작다 비교 가능 커지는값을 비교 불가
select rownum, employee_id, salary
from employees
where rownum <=10
and rownum >5; -- 5보다 큰것이므로 무한대까지 이므로 불가

select employee_id, salary
from employees
order by employee_id asc;

select rownum, employee_id, salary
from employees
order by employee_id desc;

--순위 , 사번, 이름, 급여 , 입사년도, 부서이름
--급여순 순위
--한 페이지당 5명씩 출력
--2page 출력
--1980년대, 1990년대, 2000년대
select salary
from employees 
order by salary desc;

select rownum , e.employee_id, e.first_name ,e.salary, d.department_name,
            case
                when to_char(e.hire_date,'yy') between 80 and 89 
                then '1980년대'
                when  to_char(e.hire_date,'yy') between 90 and 99
                then '1990년대'
                else '2000년대'
                end 입사년도
from employees e, departments d
where e.department_id = d.department_id(+)
order by e.salary desc;

select rownum, employee_id,salary
from employees
order by salary desc;

select rownum, e.employee_id, e.first_name ,e.salary, d.department_name, to_char(hire_date, 'yyyy') 입사년도
from employees e, departments d, (select rownum, employee_id
from employees) 
where e.department_id = d.department_id(+) and  dd.employee_id= e.employee_id
order by e.salary desc;

select rownum "순위", e.employee_id ,e.first_name, e.salary ,
            case
                when to_char(e.hire_date,'yy') between 80 and 89 
                then '1980년대'
                when  to_char(e.hire_date,'yy') between 90 and 99
                then '1990년대'
                else '2000년대'
                end 입사년도 , department_name
from employees e , (select e.employee_id, e.first_name ,e.salary, d.department_name
                            from employees e, departments d
                            where e.department_id = d.department_id(+)
                            order by e.salary desc) ee
where e.employee_id = ee.employee_id and rownum <= 5*&page;

select  bbb.ranking , bbb.employee_id, bbb.salary ,bbb.department_name, 
            case
                when to_char(bbb.hire_date,'yy') between 80 and 89 
                then '1980년대'
                when  to_char(bbb.hire_date,'yy') between 90 and 99
                then '1990년대'
                else '2000년대'
                end 입사년도
 from (select rownum ranking, ee.employee_id ,ee.first_name, ee.salary , d.department_name
         from departments dd , (select e.employee_id, e.first_name ,e.salary, d.department_id
                                                                    from employees e, departments d
                                                                    where e.department_id = d.department_id(+)
                                                                    order by e.salary desc) ee , departments ddd
         where ee.employee_id = employee_id and rownum <= 5*&page) bbb
where bbb.ranking >&page*5 -5;
--답
select ee.rn ranking , ee.employee_id , ee.first_name , ee.salary , dd.department_name
from  (select rownum rn , e.* , d.department_name
            from (select employee_id, first_name , salary, department_id
                        from employees 
                        order by salary desc) e , departments d
            where e.department_id = d.department_id(+) and rownum <= 5*&page) ee , departments dd
where ee.department_id = dd.department_id(+) and ee.rn > &page*5 -5
order by ranking asc;

