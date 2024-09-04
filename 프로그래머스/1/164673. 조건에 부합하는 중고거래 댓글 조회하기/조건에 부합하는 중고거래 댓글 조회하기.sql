-- 코드를 입력하세요
SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, TO_CHAR(B.CREATED_DATE,'YYYY-MM-DD') AS CREATED_DATE
FROM USED_GOODS_BOARD A
INNER JOIN USED_GOODS_REPLY B ON A.BOARD_ID = B.BOARD_ID
WHERE EXTRACT(YEAR FROM A.CREATED_DATE) = 2022 AND EXTRACT(MONTH FROM A.CREATED_DATE) = 10
ORDER BY B.CREATED_DATE, A.TITLE;