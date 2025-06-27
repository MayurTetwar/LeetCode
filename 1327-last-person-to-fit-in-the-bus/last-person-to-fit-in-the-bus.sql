-- Write your PostgreSQL query statement below
-- select person_name
-- from (
    select 
    q1.person_name
    from Queue q1 join Queue q2
    on q1.turn>=q2.turn
    group by q1.turn,q1.person_name
    having sum(q2.weight)<=1000
    order by sum(q2.weight) desc
    limit 1
-- )
-- order by sum desc
-- limit 1;

