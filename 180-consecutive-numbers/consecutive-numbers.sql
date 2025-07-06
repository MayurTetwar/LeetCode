-- Write your PostgreSQL query statement below

-- select Distinct l1.num as ConsecutiveNums 
-- from 
-- Logs l1 , Logs l2 , Logs l3
-- where 
-- l1.id=l2.id-1 and l2.id=l3.id-1
-- and l1.num=l2.num and l2.num=l3.num;
select distinct num as ConsecutiveNums
from (
    select num,lag(num,1) over (order by id) as l1
    ,lag(num,2) over (order by id) as l2
    from Logs
)
where num=l1 and num=l2;