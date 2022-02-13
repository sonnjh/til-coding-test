-- Oracle
SELECT *
FROM places p
WHERE p.host_id IN (SELECT host_id
                    FROM places
                    GROUP BY host_id
                    HAVING COUNT(host_id) > 1)
ORDER BY id ASC;