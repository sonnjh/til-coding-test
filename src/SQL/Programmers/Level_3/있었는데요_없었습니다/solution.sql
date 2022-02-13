-- Oracle
SELECT i.animal_id, i.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id = o.animal_id AND i.datetime > o.datetime
ORDER BY i.datetime ASC;