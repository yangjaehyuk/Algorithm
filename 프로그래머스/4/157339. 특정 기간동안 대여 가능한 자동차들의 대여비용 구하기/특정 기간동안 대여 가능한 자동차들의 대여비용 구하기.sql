-- 코드를 입력하세요
SELECT A.CAR_ID, A.CAR_TYPE, 
A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE) / 100 FEE
FROM CAR_RENTAL_COMPANY_CAR A
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN C ON A.CAR_TYPE = C.CAR_TYPE
WHERE A.CAR_TYPE IN ('세단', 'SUV')
AND C.DURATION_TYPE = '30일 이상'
AND A.CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE TO_CHAR(END_DATE,'YYYYMMDD') >= '20221101')
AND A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE) / 100 >= 500000
AND A.DAILY_FEE * 30 * (100 - C.DISCOUNT_RATE) / 100 < 2000000
ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID DESC