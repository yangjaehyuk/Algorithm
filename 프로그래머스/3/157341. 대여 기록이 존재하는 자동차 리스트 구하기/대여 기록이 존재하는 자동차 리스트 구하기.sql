-- 코드를 입력하세요
SELECT DISTINCT(A.CAR_ID) FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A, CAR_RENTAL_COMPANY_CAR AS B WHERE A.CAR_ID=B.CAR_ID AND A.START_DATE LIKE '%-10-%'AND B.CAR_TYPE LIKE '세단' ORDER BY CAR_ID DESC;