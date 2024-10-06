-- 코드를 입력하세요
SELECT TO_NUMBER(TO_CHAR(DATETIME,'HH24')) HOUR, COUNT(ANIMAL_ID)
FROM ANIMAL_OUTS
GROUP BY TO_NUMBER(TO_CHAR(DATETIME,'HH24'))
HAVING TO_NUMBER(TO_CHAR(DATETIME,'HH24')) >= 9 AND TO_NUMBER(TO_CHAR(DATETIME,'HH24')) < 20
ORDER BY TO_NUMBER(TO_CHAR(DATETIME,'HH24'))