-- Write your PostgreSQL query statement below
select employee_id
from Employees 
where manager_id not in (
    select employee_id from Employees
)
and
manager_id is not null and salary <30000
order by employee_id;