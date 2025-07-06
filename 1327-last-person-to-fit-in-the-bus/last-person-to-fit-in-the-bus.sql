-- Write your PostgreSQL query statement below
select person_name
from (
    select q1.person_name,
    sum(q1.weight) over (order by q1.turn)
    from Queue q1
)
where sum<=1000
order by sum desc
limit 1



