/* Write your PL/SQL query statement below */
select 
(case
    when count(*)=0 then null
    else max(num)
end)as num
from 
(select num 
from MyNumbers
group by num 
having count(num)=1);
