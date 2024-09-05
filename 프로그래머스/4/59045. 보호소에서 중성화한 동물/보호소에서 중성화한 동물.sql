-- 코드를 입력하세요
SELECT B.ANIMAL_ID, B.ANIMAL_TYPE, B.NAME
FROM ANIMAL_OUTS B
INNER JOIN ANIMAL_INS A ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE != B.SEX_UPON_OUTCOME
ORDER BY B.ANIMAL_ID;