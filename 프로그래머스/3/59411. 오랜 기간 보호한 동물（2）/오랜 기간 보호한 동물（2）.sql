-- 코드를 입력하세요
SELECT B.ANIMAL_ID, B.NAME
FROM ANIMAL_INS A
INNER JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY B.DATETIME - A.DATETIME DESC
FETCH NEXT 2 ROWS ONLY