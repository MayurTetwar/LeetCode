/* Write your PL/SQL query statement below */
SELECT 
product_id,year as first_year,quantity,price 
FROM Sales 
where (product_id,year) in (
    SELECT product_id,MIN(YEAR) 
    FROM Sales
    GROUP BY product_id
)
