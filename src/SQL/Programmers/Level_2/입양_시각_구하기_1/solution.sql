-- Oracle
SELECT TO_CHAR(datetime, 'HH24') AS "hour", COUNT(*) AS "count"
FROM animal_outs
WHERE TO_CHAR(datetime, 'HH24') BETWEEN 09 AND 19
GROUP BY TO_CHAR(datetime, 'HH24')
ORDER BY TO_CHAR(datetime, 'HH24') ASC;

-- Oracle
SELECT hour, COUNT(*) AS "count"
FROM (SELECT TO_CHAR(datetime, 'HH24') AS hour
      FROM animal_outs)
WHERE hour BETWEEN 09 AND 19
GROUP BY hour
ORDER BY hour;