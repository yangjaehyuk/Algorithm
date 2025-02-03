-- 코드를 입력하세요
SELECT A.FLAVOR
FROM FIRST_HALF A
INNER JOIN (SELECT SUM(TOTAL_ORDER) TOTAL_ORDER, FLAVOR FROM JULY GROUP BY FLAVOR) B
ON A.FLAVOR = B.FLAVOR
ORDER BY A.TOTAL_ORDER + B.TOTAL_ORDER DESC
FETCH FIRST 3 ROWS ONLY;