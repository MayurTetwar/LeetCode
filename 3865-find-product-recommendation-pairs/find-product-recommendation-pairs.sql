-- Write your PostgreSQL query statement below
with product_count as (
    select 
        p1.product_id as product1_id,
        p2.product_id as product2_id , 
        count(p1.user_id) as customer_count 
    from
    ProductPurchases p1 cross join ProductPurchases p2
    where p1.product_id < p2.product_id and p1.user_id = p2.user_id
    group by p1.product_id,p2.product_id
    having count(p1.user_id) > 2
)

select 
    p.product1_id,
    p.product2_id,
    pi1.category as product1_category,
    pi2.category as product2_category,
    p.customer_count
from 
product_count p join 
ProductInfo pi1 on p.product1_id = pi1.product_id 
join 
ProductInfo pi2 on p.product2_id = pi2.product_id 
order by p.customer_count desc,p.product1_id,p.product2_id; 
