-- 코드를 입력하세요
SELECT C.APNT_NO, A.PT_NAME, C.PT_NO, C.MCDP_CD, B.DR_NAME, APNT_YMD 
FROM PATIENT A, DOCTOR B, APPOINTMENT C 
WHERE A.PT_NO = C.PT_NO AND
B.DR_ID = C.MDDR_ID AND
C.MCDP_CD = 'CS' AND
EXTRACT(YEAR FROM C.APNT_YMD) = '2022' AND
EXTRACT(MONTH FROM C.APNT_YMD) = '4' AND
EXTRACT(DAY FROM C.APNT_YMD) = '13' AND
C.APNT_CNCL_YN = 'N'
ORDER BY C.APNT_YMD ASC;
