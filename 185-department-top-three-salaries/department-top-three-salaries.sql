-- Write your PostgreSQL query statement below
select d.name as Department , 
e.name as Employee,
e.salary as salary
from
Employee e join Department d
on e.departmentId=d.id
where salary in (
    -- select (
        select DISTINCT salary 
        from Employee e1
        where e1.departmentId = e.departmentId
        order by salary desc
        limit 3
    -- ) ;
)