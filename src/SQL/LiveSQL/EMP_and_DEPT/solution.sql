-- 문제 출처 (https://blog.naver.com/tkdqja8643/221317891450)
-- 라이브 SQL (https://livesql.oracle.com)
-- 연습용 스크립트 (Code Library -> EMP and DEPT)

-- 1)
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
     , sal + 50 AS "$50 인상된 월 급여"
FROM emp
ORDER BY empno ASC;

-- 2)
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
     , sal * 12 + 100 AS "연 급여"
FROM emp
ORDER BY sal DESC;

-- 3)
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
FROM emp
WHERE sal >= 2000
ORDER BY sal DESC;

-- 4)
SELECT ename AS "사원 이름"
     , deptno AS "부서 번호"
FROM emp
WHERE empno = 7788;

-- 5)
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
FROM emp
WHERE sal NOT BETWEEN 2000 AND 3000
ORDER BY empno ASC;

-- 6) TO_CHAR(hiredate, 'YYYY-MM-DD HH24:MM:DD')
SELECT ename AS "사원 이름"
     , job AS "담당 업무"
     , TO_CHAR(hiredate, 'YYYY-MM-DD') AS "입사 일자"
FROM emp
WHERE hiredate BETWEEN '20-FEB-81' AND '1-MAY-81'
ORDER BY empno ASC;

-- 7)
SELECT ename AS "사원 이름"
     , deptno AS "부서 번호"
FROM emp
WHERE deptno BETWEEN 20 AND 30
ORDER BY ename DESC;

-- 8)
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
     , deptno AS "부서 번호"
FROM emp
WHERE (sal BETWEEN 2000 AND 3000) AND deptno IN (20, 30)
ORDER BY ename ASC;

-- 9)
SELECT ename AS "사원 이름"
     , hiredate AS "입사 일자"
FROM emp
WHERE hiredate LIKE '%81%'
ORDER BY ename ASC;

-- 10)
SELECT ename AS "사원 이름"
     , job AS "담당 업무"
FROM emp
WHERE mgr IS NULL;

-- 11)
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
     , comm AS "커미션"
FROM emp
WHERE comm IS NOT NULL
  AND comm != 0
ORDER BY sal DESC, comm DESC;

-- 12)
SELECT ename AS "사원 이름"
FROM emp
WHERE ename LIKE '__R%'
ORDER BY ename ASC;

-- 13)
SELECT ename AS "사원 이름"
FROM emp
WHERE ename LIKE '%A%'
  AND ename LIKE '%E%'
ORDER BY ename ASC;

-- 14)
SELECT ename AS "사원 이름"
     , job AS "담당 업무"
     , sal AS "월 급여"
FROM emp
WHERE job IN ('CLERK', 'SALESMAN')
  AND sal NOT IN (950, 1300, 1650)
ORDER BY empno ASC;

-- 15)
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
     , comm AS "커미션"
FROM emp
WHERE comm >= 500
ORDER BY empno ASC;

-- 16) SUBSTR(hiredate, 8, 2) -> 8번째 글자부터 2개를 추출
SELECT ename AS "사원 이름"
     , SUBSTR(hiredate, 8, 2) AS "입사 년"
     , SUBSTR(hiredate, 4, 3) AS "입사 월"
FROM emp
ORDER BY empno ASC;

-- 17)
SELECT *
FROM emp
WHERE SUBSTR(hiredate, 4, 3) = 'APR'
ORDER BY empno ASC;

-- 18) MOD(empno, 2) = 0 -> 번호를 2로 나눴을 때 나머지가 0인 것
SELECT *
FROM emp
WHERE MOD(empno, 2) = 0
ORDER BY empno ASC;

-- 19)
SELECT SUBSTR(hiredate, 8, 2) AS "YY"
     , SUBSTR(hiredate, 4, 3) AS "MM"
     , SUBSTR(hiredate, 1, 2) AS "DD"
FROM emp
ORDER BY empno ASC;

-- 20) TO_DATE(sysdate) -> 오늘 날짜
SELECT TO_DATE(sysdate) - TO_DATE('2022-01-01', 'YYYY-MM-DD')
FROM dual;

-- 21) NVL(mgr, 0) -> mgr이 null이면 0으로 변환
SELECT NVL(mgr, 0)
FROM emp
ORDER BY empno ASC;

-- 22) DECODE(job, 'A', sal + 1, 'B', sal + 2, ...) -> job이 A이면 sal + 1, B이면 sal + 2, ...
SELECT ename AS "사원 이름"
     , sal AS "월 급여"
     , DECODE(job, 'ANALYST', sal + 200
    , 'SALESMAN', sal + 180
    , 'MANAGER', sal + 150
    , 'CLERK', sal + 100) AS "인상된 월 급여"
FROM emp
ORDER BY empno ASC;

-- 23) ROUND(AVG(sal)) -> 소수를 정수로 반올림, ROUND(AVG(sal), 2) -> 소수 둘째자리까지 반올림
SELECT COUNT(empno) AS "사원 수"
     , MAX(sal) AS "최고 급여"
     , MIN(sal) AS "최저 급여"
     , SUM(sal) AS "급여 합계"
     , ROUND(AVG(sal)) AS "급여 평균"
FROM emp;

-- 24)
SELECT job AS "담당 업무"
     , COUNT(job) AS "업무 인원"
     , MAX(sal) AS "최고 급여"
     , MIN(sal) AS "최저 급여"
     , SUM(sal) AS "급여 합계"
     , ROUND(AVG(sal)) AS "급여 평균"
FROM emp
GROUP BY job
ORDER BY job ASC;

-- 25)
SELECT job AS "담당 업무"
     , COUNT(*) AS "업무 인원"
FROM emp
GROUP BY job
ORDER BY job ASC;

-- 26) COUNT(DISTINCT mgr) -> null 제외한다.
SELECT COUNT(DISTINCT mgr) AS "관리자 인원"
FROM emp;

-- 27)
SELECT MAX(sal) AS "최고 급여"
     , MIN(sal) AS "최저 급여"
     , MAX(sal) - MIN(sal) AS "차액"
FROM emp;

-- 28)
SELECT job AS "담당 업무"
     , MAX(sal) AS "최고 급여"
     , MIN(sal) AS "최저 급여"
     , MAX(sal) - MIN(sal) AS "차액"
FROM emp
GROUP BY job
HAVING MIN(sal) > 2000
ORDER BY MIN(sal) DESC;

-- 29)
SELECT deptno AS "부서 번호"
     , COUNT(deptno) AS "부서 인원"
     , ROUND(AVG(sal), 2) AS "평균 급여"
FROM emp
GROUP BY deptno
ORDER BY deptno ASC;

-- 30) DECODE(deptno, 10, 'a', 20, 'b', ...) -> deptno이 10이면 a, 20이면 b, ...
SELECT deptno AS "부서 번호"
     , DECODE(deptno, 10, 'ACCOUNTING'
    , 20, 'RESEARCH'
    , 30, 'SALES'
    , 40, 'OPERATIONS') AS "부서 이름"
     , DECODE(deptno, 10, 'NEW YORK'
    , 20, 'DALLAS'
    , 30, 'CHICAGO'
    , 40, 'BOSTON') AS "지역 이름"
     , COUNT(*) AS "사원 수"
     , ROUND(AVG(sal)) AS "평균 급여"
FROM emp
GROUP BY deptno
ORDER BY deptno ASC;

-- 31)
SELECT e.deptno AS "부서 번호"
     , d.dname AS "부서 이름"
     , SUM(e.sal) AS "급여 합계"
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY e.deptno, d.dname
ORDER BY e.deptno ASC;

-- 32)
SELECT e.ename AS "사원 이름"
     , e.deptno AS "부서 번호"
     , d.dname AS "부서 이름"
FROM emp e, dept d
WHERE e.deptno = d.deptno
  AND e.ename = 'SCOTT';

-- 33) JOIN ON or JOIN USING
SELECT e.ename AS "사원 이름"
     , d.dname AS "부서 이름"
     , d.loc AS "부서 지역"
FROM emp e INNER JOIN dept d ON e.deptno = d.deptno
ORDER BY d.dname ASC, e.ename ASC, d.loc ASC;

SELECT e.ename AS "사원 이름"
     , d.dname AS "부서 이름"
     , d.loc AS "부서 지역"
FROM emp e INNER JOIN dept d USING (deptno)
ORDER BY d.dname ASC, e.ename ASC, d.loc ASC;

-- 34)
SELECT e.empno AS "사원 번호"
     , e.job AS "담당 업무"
     , d.loc AS "부서 지역"
FROM emp e INNER JOIN dept d USING (deptno)
WHERE deptno = 10
ORDER BY e.empno ASC;

-- 35)
SELECT e.ename AS "사원 이름"
     , d.dname AS "부서 이름"
     , d.loc AS "부서 지역"
FROM emp e NATURAL JOIN dept d
WHERE comm IS NOT NULL
  AND comm != 0
ORDER BY e.ename ASC;

-- 36)
SELECT e.ename AS "사원 이름"
     , d.dname AS "부서 이름"
FROM emp e, dept d
WHERE e.deptno = d.deptno
  AND e.ename LIKE '%A%'
ORDER BY e.ename ASC, d.dname ASC;

-- 37)
SELECT e.ename AS "사원 이름"
     , e.job AS "담당 업무"
     , deptno AS "부서 번호"
     , d.dname AS "부서 이름"
FROM emp e NATURAL JOIN dept d
WHERE d.loc = 'NEW YORK'
ORDER BY e.ename ASC;

-- 38)
SELECT e1.empno AS "사원 번호"
     , e1.ename AS "사원 이름"
     , e2.empno AS "관리자 번호"
     , e2.ename AS "관리자 이름"
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
ORDER BY e2.empno ASC, e1.empno ASC;

-- 39)
SELECT e1.empno AS "사원 번호"
     , e1.ename AS "사원 이름"
     , e2.empno AS "관리자 번호"
     , e2.ename AS "관리자 이름"
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno(+)
ORDER BY e1.empno DESC;

SELECT e1.empno AS "사원 번호"
     , e1.ename AS "사원 이름"
     , e2.empno AS "관리자 번호"
     , e2.ename AS "관리자 이름"
FROM emp e1 LEFT OUTER JOIN emp e2 ON e1.mgr = e2.empno
ORDER BY e1.empno DESC;

-- 40)
SELECT e1.empno AS "사원 번호"
     , e1.ename AS "사원 이름"
     , e2.empno AS "부서원 번호"
     , e2.ename AS "부서원 이름"
FROM emp e1, emp e2
WHERE e1.deptno = e2.deptno
  AND e1.ename = 'SCOTT'
  AND e1.empno != e2.empno
ORDER BY e2.empno ASC;

-- 41)
SELECT e1.ename AS "사원 이름"
     , TO_CHAR(e1.hiredate, 'YYYY-MM-DD') AS "입사 일자"
     , e2.ename AS "사원 이름"
     , TO_CHAR(e2.hiredate, 'YYYY-MM-DD') AS "입사 일자"
FROM emp e1, emp e2
WHERE e1.hiredate < e2.hiredate
  AND e1.ename = 'WARD'
ORDER BY e2.hiredate ASC;

-- 42)
SELECT e1.ename AS "사원 이름"
     , TO_CHAR(e1.hiredate, 'YYYY-MM-DD') AS "입사 일자"
     , e2.ename AS "관리자 이름"
     , TO_CHAR(e2.hiredate, 'YYYY-MM-DD') AS "입사 일자"
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
  AND e1.hiredate < e2.hiredate
ORDER BY e1.hiredate ASC;

-- 43)
SELECT e1.ename AS "사원 이름"
     , e1.job AS "담당 업무"
     , e2.ename AS "사원 이름"
     , e2.job AS "담당 업무"
FROM emp e1, emp e2
WHERE e1.empno = 7788
  AND e2.empno != 7788
  AND e1.job = e2.job
ORDER BY e1.ename DESC;

-- 44)
SELECT e1.ename AS "사원 이름"
     , e1.sal AS "월 급여"
     , e2.ename AS "사원 이름"
     , e2.job AS "담당 업무"
     , e2.sal AS "월 급여"
FROM emp e1, emp e2
WHERE e1.empno = 7499
  AND e1.sal < e2.sal
ORDER BY e2.sal DESC;

-- 45) 최소 급여를 받는 사원 찾기
SELECT ename AS "사원 이름"
     , job AS "담당 업무"
     , sal AS "월 급여"
FROM emp
WHERE sal = (SELECT MIN(sal)
             FROM emp);

SELECT *
FROM (SELECT ename AS "사원 이름"
           , job AS "담당 업무"
           , sal AS "월 급여"
      FROM emp
      ORDER BY sal ASC)
WHERE ROWNUM = 1;

-- 46)
SELECT *
FROM (SELECT job AS "담당 업무"
           , AVG(sal) AS "평균 급여"
      FROM emp
      GROUP BY job
      ORDER BY AVG(sal) ASC)
WHERE ROWNUM = 1;

-- 47) MIN(sal) AS "SAL" -> e1.sal = e2.sal 조건을 맞추기 위해 별명을 추가함.
SELECT e1.ename AS "사원 이름"
     , e1.deptno AS "부서 번호"
     , e1.sal AS "월 급여"
FROM emp e1, (SELECT deptno, MIN(sal) AS "SAL"
              FROM emp
              GROUP BY deptno) e2
WHERE e1.sal = e2.sal
ORDER BY e1.sal ASC;

-- 48) ANALYST 업무 사원보다 급여가 작은 다른 업무 사원 찾기
SELECT DISTINCT (e1.empno) AS "사원 번호"
              , e1.ename AS "사원 이름"
              , e1.job AS "담당 업무"
              , e1.sal AS "월 급여"
FROM emp e1, (SELECT sal AS "SAL"
              FROM emp
              WHERE job = 'ANALYST') e2
WHERE e1.sal < e2.sal
  AND e1.job != 'ANALYST'
ORDER BY e1.empno ASC;

-- 49) 부하 직원이 없는 사원 이름 찾기
SELECT ename "사원 이름"
FROM emp
WHERE ename NOT IN (SELECT e1.ename
                    FROM emp e1, emp e2
                    WHERE e1.empno = e2.mgr)
ORDER BY ename ASC;

-- 50) 부하 직원이 있는 사원 이름 찾기
SELECT DISTINCT (e1.ename) AS "관리자 이름"
FROM emp e1, emp e2
WHERE e1.empno = e2.mgr
ORDER BY e1.ename ASC;

SELECT e1.ename AS "관리자 이름"
     , e2.ename AS "부하 사원 이름"
FROM emp e1, emp e2
WHERE e1.empno = e2.mgr
ORDER BY e1.ename ASC;

-- 51) BLAKE와 같은 부서원 찾기
SELECT e2.ename AS "사원 이름"
     , TO_CHAR(e2.hiredate, 'YYYY-MM-DD') AS "입사 일자"
FROM emp e1, emp e2
WHERE e1.deptno = e2.deptno
  AND e1.ename = 'BLAKE'
  AND e2.ename != 'BLAKE'
ORDER BY e2.ename ASC;

-- 52)
SELECT empno AS "사원 번호"
     , ename AS "사원 이름"
     , sal AS "월 급여"
FROM emp
WHERE sal > (SELECT AVG(sal)
             FROM emp)
ORDER BY sal ASC;

-- 53)
SELECT DISTINCT (e2.empno) AS "사원 번호"
              , e2.ename AS "사원 이름"
FROM emp e1, emp e2
WHERE e1.deptno = e2.deptno
  AND e1.ename LIKE '%K%'
ORDER BY e2.empno ASC;

-- 54)
SELECT e.empno AS "사원 번호"
     , e.ename AS "사원 이름"
     , e.deptno AS "부서 이름"
     , e.job AS "담당 업무"
FROM emp e, dept d
WHERE e.deptno = d.deptno
  AND d.loc = 'DALLAS'
ORDER BY e.empno ASC;

-- 55)
SELECT e1.ename AS "사원 이름"
     , e1.sal AS "월 급여"
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
  AND e2.ename = 'KING'
ORDER BY e1.empno ASC;

-- 56)
SELECT e.deptno AS "부서 번호"
     , e.ename AS "사원 이름"
     , e.job AS "담당 업무"
FROM emp e, dept d
WHERE e.deptno = d.deptno
  AND d.dname = 'RESEARCH'
ORDER BY e.empno ASC;

-- 57)
SELECT empno AS "사원 번호"
     , ename AS "사원 이름"
     , sal AS "월 급여"
FROM emp
WHERE sal > (SELECT AVG(sal)
             FROM emp)
ORDER BY empno ASC;

-- 58) 평균 급여가 가장 작은 업무 찾기
SELECT *
FROM (SELECT job AS "업무"
      FROM emp
      GROUP BY job
      ORDER BY AVG(sal) ASC)
WHERE ROWNUM = 1;

-- 59) PRESIDENT 사원이 속한 부서와 같은 부서의 사원 찾기
SELECT DISTINCT (e1.ename) AS "사원 이름"
              , e1.deptno AS "부서 번호"
              , e1.job AS "담당 업무"
FROM emp e1, (SELECT deptno, job
              FROM emp
              WHERE job = 'PRESIDENT') e2
WHERE e1.deptno = e2.deptno
  AND e1.job != e2.job
ORDER BY e1.ename ASC;