-- Oracle
SELECT name, datetime
FROM (SELECT i.name, i.datetime
      FROM animal_ins i, animal_outs o
      WHERE i.animal_id = o.animal_id(+) AND o.animal_id IS NULL
      ORDER BY i.datetime ASC)
WHERE ROWNUM <= 3;