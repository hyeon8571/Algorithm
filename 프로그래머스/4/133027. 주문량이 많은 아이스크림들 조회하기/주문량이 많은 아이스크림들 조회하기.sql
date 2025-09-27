-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 
SELECT FLAVOR
FROM 
    (
        SELECT FF.FLAVOR, FF.TOTAL_ORDER + TT.TOTAL_ORDER AS TOTAL_ORDER
        FROM 
            (
                SELECT FLAVOR, SUM(TOTAL_ORDER) TOTAL_ORDER
                FROM 
                    FIRST_HALF
                GROUP BY FLAVOR
            ) FF JOIN
            (
                SELECT FLAVOR, SUM(TOTAL_ORDER) TOTAL_ORDER
                FROM
                    JULY
                GROUP BY FLAVOR
            ) TT
            ON FF.FLAVOR = TT.FLAVOR
        ORDER BY TOTAL_ORDER DESC
    )
WHERE ROWNUM <= 3
    

