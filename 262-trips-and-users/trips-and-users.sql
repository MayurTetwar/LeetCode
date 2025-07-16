-- Write your PostgreSQL query statement below
select t.request_at as Day,
    round(count(
        Case
            when (t.status='cancelled_by_client' 
            or t.status='cancelled_by_driver') then 1
        End
    )::DECIMAL/count(*),2) as "Cancellation Rate"
from Trips t join Users c
on  t.client_id = c.users_id 
join Users d
on t.driver_id = d.users_id
where t.request_at between '2013-10-01' and '2013-10-03' 
        and c.banned='No' and d.banned='No'
group by t.request_at
having count(*)>0
order by t.request_at;
