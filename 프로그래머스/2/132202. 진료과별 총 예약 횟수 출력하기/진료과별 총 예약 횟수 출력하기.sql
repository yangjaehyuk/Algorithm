-- 코드를 입력하세요
SELECT MCDP_CD, COUNT(APNT_NO)
FROM APPOINTMENT
WHERE TO_CHAR(APNT_YMD,'YYYYMM') = '202205'
GROUP BY MCDP_CD
ORDER BY COUNT(APNT_NO), MCDP_CD