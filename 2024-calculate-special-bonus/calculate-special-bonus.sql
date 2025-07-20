-- Write your PostgreSQL query statement below
select 
employee_id,
(
    CASE
        WHEN employee_id%2=1 and not (name like 'M%') then salary 
        else 0
    END
) as bonus  
from Employees 
order by employee_id;