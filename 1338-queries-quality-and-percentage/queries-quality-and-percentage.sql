-- Write your PostgreSQL query statement below
select query_name,
round(avg(rating*1.0/position),2) as quality ,
round((
    count(case 
        when rating<3 then 1
    end)*100.0/count(query_name)
),2) as poor_query_percentage 
from Queries 
group by query_name