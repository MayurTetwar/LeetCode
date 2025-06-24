-- Write your PostgreSQL query statement below
select 
c.visited_on,
(
    SELECT sum(amount)
    from Customer 
    where visited_on between 
    c.visited_on - INTERVAL '6 day' and 
    c.visited_on
) as amount,
round(
   ( select sum(amount)*1.0/7
    from Customer 
    where visited_on between 
    c.visited_on - INTERVAL '6 day' and
    c.visited_on
),2) as average_amount
from Customer c
where c.visited_on - INTERVAL '6 day' in (
    select cs.visited_on from Customer cs
)
group by c.visited_on
order by visited_on