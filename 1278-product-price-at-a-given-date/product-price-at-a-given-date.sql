-- Write your PostgreSQL query statement below
SELECT
  product_id,
  10 AS price
FROM
  Products
GROUP BY
  product_id
HAVING
  MIN(change_date) > '2019-08-16'
UNION ALL
select 
    product_id ,
    new_price AS price
from Products 
where (product_id,change_date) in (
    select 
    product_id ,
    max(change_date)
    from Products  
    where change_date <= '2019-08-16'
    group by product_id 
)

