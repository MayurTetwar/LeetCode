-- Write your PostgreSQL query statement below
select d.name as Department,
e.name as Employee ,
e.salary as Salary
from Employee e left join Department d 
on e.departmentId = d.id
where (d.name,e.salary) in (
    select d.name , max(salary)
    from Employee e left join
    Department d
    on e.departmentId = d.id
    group by d.name 
)