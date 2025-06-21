-- Write your PostgreSQL query statement below
select 
TO_CHAR(trans_date,'YYYY-MM') as month,
country,
count(state) as trans_count,
sum(
    case
        when state='approved' then 1
        else 0
    end
) as approved_count,
sum(amount) as trans_total_amount,
sum(
    case
        when state='approved' then amount
        else 0
    end
) as approved_total_amount 
from 
Transactions 
group by country,TO_CHAR(trans_date,'YYYY-MM');