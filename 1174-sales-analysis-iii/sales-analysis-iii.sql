-- Write your PostgreSQL query statement below
select p.product_id,p.product_name 
from Product p join Sales s
ON p.product_id = s.product_id
where 
p.product_id not in (
    select product_id 
    from Sales
    where sale_date<'2019-01-01' or sale_date>'2019-03-31'
)  
GROUP BY p.product_id, p.product_name
