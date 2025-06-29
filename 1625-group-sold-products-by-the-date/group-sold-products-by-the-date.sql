-- Write your PostgreSQL query statement below
select sell_date ,count(Distinct product) as num_sold,STRING_AGG(Distinct product,',' order by product) as products                     
from Activities
group by sell_date
order by sell_date;  
