-- Write your PostgreSQL query statement below
select contest_id ,
round(100.0*count(user_id)/(SELECT COUNT(user_id) FROM Users),2) as percentage 
from Register 
group by contest_id
order by percentage desc,contest_id asc;