-- Oracle
SELECT o.animal_id, o.animal_type, o.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id = o.animal_id
  AND i.sex_upon_intake LIKE '%Intact%'
  AND o.sex_upon_outcome NOT LIKE '%Intact%'
ORDER BY o.animal_id;