SELECT DISTINCT CAR_ID, CASE WHEN CAR_ID IN (SELECT CAR_ID
                                   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                   WHERE TO_DATE('2022-10-16', 'YYYY-MM-dd') BETWEEN START_DATE AND END_DATE)
                                   THEN '대여중'
                                   ELSE '대여 가능' END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
ORDER BY CAR_ID DESC