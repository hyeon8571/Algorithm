-- 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회하는 SQL 문
SELECT MI.CART_ID
FROM 
    (
        SELECT CART_ID
        FROM CART_PRODUCTS
        WHERE NAME = 'Milk'
    ) MI
JOIN
    (
        SELECT CART_ID
        FROM CART_PRODUCTS
        WHERE NAME = 'Yogurt'
    ) YO
ON MI.CART_ID = YO.CART_ID
ORDER BY MI.CART_ID

