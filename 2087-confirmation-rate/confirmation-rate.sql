-- Write your PostgreSQL query statement below
select s.user_id,
    case 
    when count(c.action)!=0 then
    round(count(
            case
            when c.action='confirmed' then 1
            end
        )*1.0/count(c.action),2)
    else 0 
    end as confirmation_rate 
from Signups s left join
Confirmations c
on s.user_id=c.user_id
group by s.user_id;