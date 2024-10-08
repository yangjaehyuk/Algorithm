-- 코드를 입력하세요
-- SELECT TO_NUMBER(TO_CHAR(DATETIME,'HH24'))
SELECT A.HOUR, COUNT(B.ANIMAL_ID)
FROM (SELECT LEVEL - 1 AS HOUR FROM DUAL CONNECT BY LEVEL - 1 < 24) A
LEFT JOIN ANIMAL_OUTS B ON A.HOUR = TO_NUMBER(TO_CHAR(B.DATETIME, 'HH24'))
GROUP BY A.HOUR
ORDER BY A.HOUR