-- Write your PostgreSQL query statement below
select employee_id ,
    case when count(employee_id)=1 
            then(
                select department_id 
                from Employee
                where employee_id=e.employee_id
            )
        else (   
            select department_id 
            from Employee
            where primary_flag='Y' and employee_id=e.employee_id
        )
    end
from Employee e 
group by e.employee_id;
