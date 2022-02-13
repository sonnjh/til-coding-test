-- Oracle
SELECT name
FROM (SELECT name
      FROM animal_ins
      ORDER BY datetime ASC)
WHERE ROWNUM = 1;