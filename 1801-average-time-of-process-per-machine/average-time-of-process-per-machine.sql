# Write your MySQL query statement below
select
    machine_id,round(sum(case 
        when activity_type='end' then timestamp
        else -timestamp 
    end)*2/count(process_id),3) as processing_time 
from Activity
group by machine_id;