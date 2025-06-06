-- 코드를 입력하세요
SELECT FP.product_id, FP.product_name, SUM(FO.amount) * FP.price as total_sales
FROM FOOD_PRODUCT FP JOIN FOOD_ORDER FO ON FP.product_id = FO.product_id
WHERE extract(month from FO.PRODUCE_DATE) = 5 AND extract(year from FO.PRODUCE_DATE) = 2022
GROUP BY FP.product_id, FP.product_name, FP.price
ORDER BY SUM(FO.amount) * FP.price DESC, FP.product_id