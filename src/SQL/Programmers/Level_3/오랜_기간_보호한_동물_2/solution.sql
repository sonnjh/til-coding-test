-- Oracle
SELECT animal_id, name
FROM (SELECT o.animal_id, o.name
      FROM animal_ins i, animal_outs o
      WHERE i.animal_id = o.animal_id
      ORDER BY o.datetime - i.datetime DESC)
WHERE ROWNUM <= 2;