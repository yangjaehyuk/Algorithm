-- 코드를 작성해주세요
SELECT B.EMP_NO, B.EMP_NAME,
CASE WHEN AVG(C.SCORE) >= 96 THEN 'S'
WHEN AVG(C.SCORE) >= 90 THEN 'A'
WHEN AVG(C.SCORE) >= 80 THEN 'B'
ELSE 'C'
END AS GRADE,
CASE WHEN AVG(C.SCORE) >= 96 THEN B.SAL * 0.2
WHEN AVG(C.SCORE) >= 90 THEN B.SAL * 0.15
WHEN AVG(C.SCORE) >= 80 THEN B.SAL * 0.1
ELSE B.SAL * 0
END AS BONUS
FROM HR_DEPARTMENT A, HR_EMPLOYEES B, HR_GRADE C
WHERE B.EMP_NO = C.EMP_NO AND A.DEPT_ID = B.DEPT_ID
GROUP BY B.EMP_NO, B.EMP_NAME
ORDER BY B.EMP_NO ASC;