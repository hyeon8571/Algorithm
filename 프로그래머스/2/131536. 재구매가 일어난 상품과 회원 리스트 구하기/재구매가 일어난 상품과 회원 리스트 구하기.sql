-- 코드를 입력하세요
SELECT DISTINCT USER_ID, PRODUCT_ID
FROM ONLINE_SALE o1
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) >= 2
ORDER BY USER_ID, PRODUCT_ID DESC;