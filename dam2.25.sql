select 1234, 5438, round(1234.5438), round(1234.5438, 0),  --해당 자릿수까지 반올림표현
round(1234.5438, 1), round(1234.5438,-1),
round(1234.5438, 3), round(1234.5438, -3)
from dual;

select 1234, 5438, trunc(1234.5438), trunc(1234.5438, 0),  --해당 자릿수까지유지 내림표현
trunc(1234.5438, 1), trunc(1234.5438,-1),
trunc(1234.5438, 3), trunc(1234.5438, -3)
from dual;

select 1234.5438, floor(1234.5438)    --소수점삭제
from dual;

select 5+3, 5-3, 5/3, mod(5, 3)                --mod 는 나머지
from dual;

select abs(5), abs(-5)  -- abs 절대값
from dual;

select trunc(789.4561, 3)
from dual;

--사원의 사번, 이름, 급여, 커미션포함급여
--커미션 포함 급여는 100의 자리수로 표현

select employee_id, first_name, salary,salary+salary*nvl(commission_pct, 0),
round(salary+salary*nvl(commission_pct, 0), -2)
from employees;

--*사번이 100~199번인 사원의 사번, 이름, 급여, 커미션포함급여 ( 100자리수표현)
---문자함수

select employee_id, first_name, salary, round(salary+salary*nvl(commission_pct, 0), -2)
from employees
where employee_id between 100 and 199;

select 'kiTrI', lower('kiTrI'), upper('kiTrI'), initcap('kiTrI'), length('kiTrI')
from dual;
--full name  --타입이나 행의 개수생각하여 쓰임 함수 속에 함수  -concat(  xx ,xx  ) 총2가지
select employee_id, first_name, last_name,
         first_name||' '|| last_name,
         concat(first_name, concat(' ', last_name))   
from employees;

--substr 하위문자열 db는  인자값 시작이 1 ///  substr( xx1 , x2 , x3)    --x2= 해당자리수부터 끝까지 x3=x1의 문자열 갯수
--instr(x1 , x2, x3 ) x2= x1에서의 첫번째 문자위치 x3는
select 'hello oracel !!!', substr('hello oracle!!!', 2, 6), substr('hello oracle!!!', 2)
          ,instr('hello oacle !!!', 'o'),instr('hello oracle!!!', 'o', 6)                                                                                
from dual;

--'123-456  zipcode, 123 zip2, 456 zip2                substr ('x', x ) / ( 'x' , x , x )substr('xx', 1 , instar('xx','-')-1 or +1),   instr('x', 'x')  /  ('x', 'x' x)
select '123-456' zipcode, substr('123-456',1 ,instr('123-456', '-')-1)"zip1",substr('123-456', instr('123-456', '-')+1)"zip2"
from dual;

select '1234-56' zipcode ,substr('1234-56', 1, instr('1234-56','-')-1), substr('1234-56', instr('1234-56','-')+1)
from dual;

--010-4182-0926
select '1010-14182-0926' simpson, substr('1010-14182-0926', 1 , instr('1010-14182-0926','-')-1) first,
            substr('1010-4182-0926',instr('1010-4182-0926','-')+1, instr('1010-4182-0926', '-')-1)middle,
            substr('1010-4182-0926', instr('1010-4182-0926','-',1,2)+1)last
from dual;

--010-5027-8380
select '010-5027-8380', substr('010-5027-8380',1 ,instr('010-5027-8380','-')-1),
       substr('010-5027-8380', instr('010-5027-8380','-')+1, instr('010-5027-8380','-',2)),
       substr('010-5027-8380', instr('010-5027-8380','-',1,2)+1)
from dual;



--010-27357-9897
select '010-27357-9897' lug , substr('010-27357-9897', 1, instr('010-27357-9897','-')-1)first,
        substr('010-27357-9897', instr('010-27357-9897','-')+1, 5)middle,
        substr('010-27357-9897', instr('010-27357-9897','-',1,2)+1,4)last
from dual;

select '010-4182-0926-02', substr('010-4182-0926-02', instr('010-4182-0926-02','-',1,2)+1, instr('010-4182-0926-02','-'))
          ,substr('010-4182-0926-02', instr('010-4182-0926-02','-',1,3)+1)
from dual;

--날짜함수
select sysdate, sysdate +3, sysdate-3, sysdate+3/24, to_char(sysdate+3/24, 'yyyy-mm-dd hh24:mi:ss')
from dual;
--months_between ( sysdate, sysdate +xx) xx개월 차이
--next_day(sysdate, x)  오늘 기준으로 다음 요일 ( 1 : 일요일 2: 월요일 ~~)
--add_months(sysdate , x) 오늘기준 x달뒤
select sysdate, months_between(sysdate, sysdate +70)
        ,next_day(sysdate, 1), next_day(sysdate, 3)
        ,add_months(sysdate, 2)
        ,last_day(sysdate)
from dual;
--to_char 날짜 문자열을 숫자로표현  - w  :이번달의 몇번쨰주  ww : 그해의 몇주차  d : 그주의 몇요일 dd :  그 달의 일 ddd : 그해의 몇번째 일 dy : x요일 day : x요일
--mi : 몇분 ss : 몇초
select sysdate, to_char(sysdate, 'yyyy mm mon month w ww d dd ddd dy day')
        ,to_char(sysdate,  'am hh hh24 mi ss')
from dual;
--round : 반올림 / trunc : 내림
select to_char(sysdate, 'yyyy mm dd hh24 mi ss')"1",
        to_char(round(sysdate), 'yyyy mm dd hh24 mi ss')"2" ,
         to_char(round(sysdate, 'dd'), 'yyyy mm dd hh24 mi ss')"3",
          to_char(round(sysdate, 'mm'), 'yyyy mm dd hh24 mi ss')"4",
           to_char(round(sysdate, 'yy'), 'yyyy mm dd hh24 mi ss')"5",
            to_char(round(sysdate, 'hh'), 'yyyy mm dd hh24 mi ss')"6",
             to_char(round(sysdate, 'mi'), 'yyyy mm dd hh24 mi ss')"7"
from dual
union
select to_char(sysdate, 'yyyy mm dd hh24 mi ss')"1",
        to_char(trunc(sysdate), 'yyyy mm dd hh24 mi ss')"2" ,
         to_char(trunc(sysdate, 'dd'), 'yyyy mm dd hh24 mi ss')"3",
          to_char(trunc(sysdate, 'mm'), 'yyyy mm dd hh24 mi ss')"4",
           to_char(trunc(sysdate, 'yy'), 'yyyy mm dd hh24 mi ss')"5",
            to_char(trunc(sysdate, 'hh'), 'yyyy mm dd hh24 mi ss')"6",
             to_char(trunc(sysdate, 'mi'), 'yyyy mm dd hh24 mi ss')"7"
from dual;

--변환함수   숫자 : 오른쪽정렬 문자 : 왼쪽정렬  +는 숫자연산에만 사용 '  ' 가 붙더라도 자동형변환 ex) '3'+5  = 8  -'3'+  +가 붙음으로써 문자인 '3'이  자동숫자변환
select 'a', 3, '3' , 3+5, '3'+5
from dual;

select 1123456.789,
        to_char(1123456.789, '000,000,000.00'),
        to_char(1123456.789, '999,999,999.99'),
        length(to_char(1123456.789, '000,000,000.00')),
        length(to_char(1123456.789, '999,999,999.99'))
from dual;

-- 문자 -> 숫자    --'123,456.98'  ' ' 안에 , 가 들어가 문자취급
select '123,456.98', '123,456.98'+3  
from dual;   -- 나오지않음

select '123,456.98', to_number('123,456.98', '000,000.00')+3
from dual;

select sysdate, to_char(sysdate, 'yy mm dd')
    ,to_char(sysdate, 'am hh mi ss')
    ,to_char(sysdate, 'hh24 mi ss')
from dual;

--20190225142154  > 날짜 >> 3일후       숫자 - > 문자 - > 날짜 -> 3일후
select 20190225142154, to_date(to_char(20190225142154, '00000000000000'), 'yyyymmdd hh24 mi ss')                      
from dual;

select to_char(to_date(to_char(20190225142154,'00000000000000'), 'yyyymmdd hh24 mi ss')+3, 'yyyy.mm.dd hh24:mi:ss')
from dual;

--19920415131313 > 날자 > 3일후

select to_char(to_date(to_char(19920415131313,'00000000000000'), 'yyyy mm dd hh24 mi ss')+3, 'yyyy mm dd hh24:mi:ss')
from dual;




--일반함수   nvl2(commission_pct, 1, 0)          1 : null 일경우 1로변환  0 : null 일경우 0으로 변환
select commission_pct, nvl(commission_pct, 0), nvl2(commission_pct, 1, 0)
from employees;
--연봉등급          교제 p65 case  / decode
-- 급여가 4000미만인 사원은 저연봉           case시작 when then else조건빼고 나머지 end끝
--급여가 10000미만은          평균연봉
--급여가 10000이상은           고연봉
--사번,이름,급여,연봉등급
select employee_id, first_name, salary, 
        case
           when salary<4000
           then '저연봉'
           when salary<10000
           then '평균연봉'
           else '고연봉'
           end 연봉등급
from employees
order by salary desc;

사원번호, 이름, 급여, 커미션포함급여, 급여등급-커미션포함급여 ( 내림차순)
select employee_id, first_name, salary, salary+salary*nvl(commission_pct, 0 ),
      case
      when salary+salary*nvl(commission_pct, 0 ) <3000
      then 'A'
      when salary+salary*nvl(commission_pct, 0 ) <6000
      then 'B'
      when salary+salary*nvl(commission_pct, 0 )<10000
      then 'C'
      when salary+salary*nvl(commission_pct, 0 ) < 15000
      then 'D'
      when salary+salary*nvl(commission_pct, 0 ) < 25000
      then 'E'
      else 'F'
      end 급여등급
      from employees
order by salary+salary*nvl(commission_pct, 0 ) desc;

select *
from jobs;

select employee_id, last_name, job_id, case
     when job_id like 'AD_%'
     then 'Administration'
     when job_id like 'AC_%'
     then 'Accounting'
     when job_id like 'SA_%'
     then 'Sales'
     when job_id like 'IT_%'
     then 'IT'
     when job_id like 'MK_%'
     then 'Marketing'
     else 'Stock'
     end 사업부
from employees
order by employee_id asc;
select
    employee_id as 사번
    , last_name as 이름
    , job_id as 직업코드
    --, substr(lower(job_id),1, instr(job_id, '_' )-1)
    , case
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ad' then
            'Administration'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ac' then
            'Accounting'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'sa' then
            'Sales'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'st' then
            'Stock'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'it' then
            'It'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'mk' then
            'Marketing'
        else
            '사업부없음'
      end as "사업부"
from
    employees
order by 사업부, employee_id;

--1980년도 입사 임원
--90년도            평사원
--2000년도        신입사원
--사번,이름,입사일, 사원구분

select employee_id, first_name, hire_date,
          case
            when hire_date<to_date(to_char('19900101'),'yyyymmdd')
            then '임원'
            when hire_date< to_date(to_char('20000101'),'yyyy mm dd')
            then '평사원'
            else '신입사원'
            end 사원구분
from employees
order by hire_date asc;

select employee_id, first_name, hire_date,
          case
            when to_number(to_char(hire_date, 'yyyy'), '0000')<1990
            then '임원'
            when to_number(to_char(hire_date, 'yyyy'), '0000')<2000
            then '평사원'
            else '신입사원'
            end 사원구분
from employees
order by hire_date asc;

select job_id
from jobs;

select 
from employees;

select to_char(to_date(to_char(12341230, '00000000'), 'yyyymmdd'), ' yyyy mm dd')
from dual;

select concat(concat(concat(first_name,'의 근무년수는 '),to_number(to_char(sysdate,'yyyy'),'0000')-to_number(to_char(hire_date,'yyyy'),'0000')),'년 입니다.')
from employees;

--매니저 번호가 130미만은 초보  130이상 150이하는 중급 그외는 고급이다. 사번 이름 매니저번호를 오름차순으로 정리하라.

select employee_id, first_name, manager_id,
         case
         when manager_id <130
         then '초보'
         when manager_id >=130 and manager_id <= 150
         then '중급'
         else '고급'
         end as "매니저등급"
from employees
order by manager_id desc;

select ascii('0'), ascii('A'), ascii('a')
from dual;