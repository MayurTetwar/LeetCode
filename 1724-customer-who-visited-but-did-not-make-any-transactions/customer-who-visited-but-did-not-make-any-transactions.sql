-- Write your PostgreSQL query statement below
select v.customer_id,count(v.customer_id) count_no_trans
from Visits v 
left join Transactions t 
ON v.visit_id = t.visit_id 
where t.visit_id is null
group by v.customer_id;
--order by count_no_trans;