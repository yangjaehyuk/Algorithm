-- 코드를 작성해주세요
SELECT A.ID, B.FISH_NAME, A.LENGTH FROM FISH_INFO A, FISH_NAME_INFO B, 
(SELECT MAX(LENGTH) AS LENGTH, FISH_TYPE FROM FISH_INFO GROUP BY FISH_TYPE) C 
WHERE A.FISH_TYPE = B.FISH_TYPE AND A.FISH_TYPE = C.FISH_TYPE AND A.LENGTH = C.LENGTH 
ORDER BY A.ID;