SELECT 
    DISTINCT CAR_ID,
        CASE 
        WHEN CAR_ID IN (
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE END_DATE >= TO_DATE('2022-10-16', 'yyyy-mm-dd') 
                AND START_DATE <= TO_DATE('2022-10-16', 'yyyy-mm-dd') 
        ) THEN '대여중'
        ELSE '대여 가능'
        END AS AVAILABILITY
    
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
ORDER BY CAR_ID DESC
