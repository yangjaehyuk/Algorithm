-- 코드를 작성해주세요
SELECT ID,
CASE
WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) <= 0.25 THEN 'CRITICAL'
WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) <= 0.50 THEN 'HIGH'
WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) <= 0.75 THEN 'MEDIUM'
ELSE 'LOW' 
END AS COLONY_NAME
FROM ECOLI_DATA
ORDER BY ID