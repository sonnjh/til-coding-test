-- Oracle
SELECT o.animal_id, o.name
FROM animal_ins i, animal_outs o
WHERE i.animal_id(+) = o.animal_id AND i.animal_id IS NULL
ORDER BY o.animal_id;

-- Oracle
SELECT animal_id, name
FROM animal_outs
WHERE animal_id NOT IN (SELECT animal_id
                        FROM animal_ins)
ORDER BY animal_id;