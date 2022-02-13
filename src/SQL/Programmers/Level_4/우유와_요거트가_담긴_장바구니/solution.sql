-- Oracle
SELECT DISTINCT cart_id
FROM cart_products
WHERE name = 'Milk' AND cart_id IN (SELECT DISTINCT cart_id
                                    FROM cart_products
                                    WHERE name = 'Yogurt')
ORDER BY cart_id ASC;

-- Oracle
SELECT cart_id
FROM cart_products
WHERE name = 'Milk'
INTERSECT
SELECT cart_id
FROM cart_products
WHERE name = 'Yogurt';