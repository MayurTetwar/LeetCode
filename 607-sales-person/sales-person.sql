-- Write your PostgreSQL query statement below
select sp.name
from SalesPerson sp left join Orders o
on sp.sales_id = o.sales_id        
left join Company com 
on o.com_id = com.com_id
group by sp.name
having 0=count(
    case
        when com.name='RED' then 1
    end
);