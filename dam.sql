select location_id, postal_code
from locations
where city='Seattle';

--급여를 5000이상 12000미만을 받는 사원, 이름, 급여, 부서번호
select first_name, salary, department_id
from employees
where salary>=5000 and salary<12000;

--부서번호가 50인 사원 중 급여를 5000이상 받는 사원의 사번, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where department_id = 50 and salary>=5000;
----급여를 5000이상 12000이하를 받는 사원, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where salary between 5000 and 12000;

----급여를 5000이상 12000이하를 받는 사원, 이름, 급여, 부서번호
select employee_id, first_name, salary, department_id
from employees
where salary between 5000 and 12000;  -- between 은 미만 불가능.

--커미션을 받는 사원의 사번, 이름, 급여, 커미션포함급여
select employee_id, first_name, salary, salary+salary*nvl(commission_pct, 0)
from employees
where salary<salary+salary*commission_pct;

--근무부서가 50, 60, 80인 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id
from employees
where department_id = 50 or department_id = 60 or department_id = 80;

select employee_id, first_name, department_id
from employees
where department_id in(50, 60, 80);

--근무부서가 50, 60, 80이 아닌 사원의 사번, 이름, 부서번호
select employee_id, first_name, department_id
from employees
where department_id !=50 and department_id !=60 and department_id != 80;

select employee_id, first_name, department_id
from employees
where department_id not in(50, 60, 80);

--급여가 3000이상 이거나 8000이상이거나 5000이상인 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary>=3000 or salary>=8000 or salary>=5000;

select employee_id, first_name, salary
from employees
where salary >= any (3000, 8000, 5000);

--급여가 3000이상이고 8000이상이고 5000이상인 사원의 사번, 이름, 급여
select employee_id, first_name, salary
from employees
where salary >=3000
and salary >=5000
and salary >=8000;

select employee_id, first_name, salary
from employees
where salary >= all (3000, 8000, 5000);    --all 은 모든조건포함  any 는 부분

--현재시간, 3일후, 3시간후             to_char(sysdate 시스템날짜, '연.월.일.시.분.초')
select sysdate, to_char(sysdate, 'yy.mm.dd.hh24:mi:ss'),
        to_char(sysdate+3, 'yy.mm.dd.hh24:mi:ss')"3일후",
        to_char(sysdate+3/24, 'yy.mm.dd.hh24:mi:ss')"3시간후"
from dual;

--이름이 steven인 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name = 'Steven';

--이름이 S로 시작하는 사원의 사번, 이름  - %뭐가오든 몇개가 오든 상관x
select employee_id, first_name
from employees
where first_name like 'S%';

--이름이 e를 포함하고있는 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like '%e%';

--이름이 y로 끝나는 사원의 사번, 이름
select employee_id, first_name
from employees
where first_name like '%y';

--이름에서 끝에서 세번째가 e인 사원의 사번, 이름   _ : 뭐가오든 상관 x 몇개 o 자릿수의미 
select employee_id, first_name
from employees
where first_name like '%e__';             

--부서번호가 50이 아닌 사원의 사번, 이름, 부서번호            != , ^= , <> not연산 =의반대
select employee_id, first_name, department_id
from employees
where department_id != 50;

select employee_id, first_name, department_id
from employees
where department_id ^= 50;

select employee_id, first_name, department_id
from employees
where department_id <> 50;

--모든 사원의 사번, 이름, 급여     desc :  내림차순  asc : 오름차순
--단 급여순
select employee_id, first_name, salary
from employees
order by salary desc;

--부서번호, 사번, 이름, 급여
--부서별 급여순으로 정렬
select department_id, employee_id, first_name, salary
from employees
order by department_id, salary desc;

select department_id did, employee_id, first_name, salary sal
from employees
order by did, sal desc;

--근무도시가 Seattle인 사원의 사번, 이름, 부서번호     연관된 table을 이용하여 여러개의 select로 결과출력
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
--급여가 12000이상인 직업,사번, 이름, 부서번호, 급여

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