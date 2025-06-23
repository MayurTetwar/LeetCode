-- Write your PostgreSQL query statement below
select 
round(
    (
    select count(*)
    from (
        select customer_id
        from Delivery 
        group by customer_id
        having min(order_date)=
        min(customer_pref_delivery_date)
    )
)*100.0/count(Distinct customer_id),2
)
as immediate_percentage
from Delivery;
    
-- )/count(Distinct customer_id)
-- from Delivery;
