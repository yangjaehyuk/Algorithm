-- 코드를 입력하세요
SELECT A.MEMBER_NAME, C.REVIEW_TEXT, TO_CHAR(C.REVIEW_DATE, 'YYYY-MM-DD')
FROM MEMBER_PROFILE A
INNER JOIN (SELECT MEMBER_ID, COUNT(MEMBER_ID) FROM REST_REVIEW GROUP BY MEMBER_ID ORDER BY COUNT(MEMBER_ID) DESC FETCH FIRST ROW ONLY) B ON A.MEMBER_ID = B.MEMBER_ID
INNER JOIN REST_REVIEW C ON B.MEMBER_ID = C.MEMBER_ID
ORDER BY C.REVIEW_DATE, C.REVIEW_TEXT