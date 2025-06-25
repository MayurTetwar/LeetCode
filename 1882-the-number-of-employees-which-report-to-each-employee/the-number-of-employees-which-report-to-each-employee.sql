-- Write your PostgreSQL query statement below
select el.reports_to as employee_id,rl.name,count(el.age) as reports_count,round(avg(el.age)) as average_age 
from Employees el join Employees rl
on el.reports_to=rl.employee_id
group by el.reports_to,rl.name
having el.reports_to is not null
order by el.reports_to;
