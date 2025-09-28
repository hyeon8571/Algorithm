-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문
SELECT h.hour,
       NVL(COUNT(a.animal_id), 0) AS cnt
FROM   (SELECT LEVEL - 1 AS hour
        FROM dual
        CONNECT BY LEVEL <= 24) h
       LEFT JOIN animal_outs a
              ON TO_NUMBER(TO_CHAR(a.datetime, 'HH24')) = h.hour
GROUP  BY h.hour
ORDER  BY h.hour;