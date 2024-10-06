-- 코드를 작성해주세요
SELECT A.ID, A.EMAIL, A.FIRST_NAME, A.LAST_NAME
FROM DEVELOPERS A
WHERE A.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')
ORDER BY A.ID