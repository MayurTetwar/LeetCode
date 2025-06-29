-- Write your PostgreSQL query statement below
select p.product_name,sum(o.unit) as unit
from Orders o
left join Products p
on p.product_id=o.product_id
where TO_CHAR(o.order_date,'YYYY-MM')='2020-02'
group by p.product_name
having sum(o.unit)>=100;