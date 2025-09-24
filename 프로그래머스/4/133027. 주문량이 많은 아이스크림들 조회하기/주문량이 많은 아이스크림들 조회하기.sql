-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.

SELECT T.FLAVOR
FROM 
    (
        SELECT A.FLAVOR, A_TOTAL + B_TOTAL
        FROM 
            (
                SELECT FLAVOR, SUM(TOTAL_ORDER) AS A_TOTAL
                FROM FIRST_HALF
                GROUP BY FLAVOR
            ) A JOIN
            (
                SELECT FLAVOR, SUM(TOTAL_ORDER) AS B_TOTAL
                FROM JULY
                GROUP BY FLAVOR
            ) B ON A.FLAVOR = B.FLAVOR
        ORDER BY A_TOTAL + B_TOTAL DESC
    ) T
WHERE ROWNUM <= 3

