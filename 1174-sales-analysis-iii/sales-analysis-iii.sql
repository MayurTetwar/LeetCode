-- Write your PostgreSQL query statement below
select product_id,product_name 
from Product
where product_id not in (
    select s.product_id 
    from Sales s
    where s.sale_date not between '2019-01-01' and '2019-03-31'
) and product_id in (
    select s.product_id from sales s
)