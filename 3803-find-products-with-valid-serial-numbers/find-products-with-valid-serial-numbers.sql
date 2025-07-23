-- Write your PostgreSQL query statement below
with cte as (
    select p3.product_id, 
    unnest(string_to_array(description, ' ')) AS word
    from products p3
),cte2 as (
    select product_id,
    count(
        case
            when word ~ '^SN([0-9]{4}-)+[0-9]{4}$' then 1
        end
    )
    from cte
    group by product_id
)

select c.product_id,p1.product_name,p1.description   
from cte2 c join products p1
on c.product_id=p1.product_id
where c.count>=1 
order by c.product_id 