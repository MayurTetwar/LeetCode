-- Write your PostgreSQL query statement below
select distinct a.* 
from Stadium a,Stadium b,Stadium c
where a.people>=100 and b.people>=100 and c.people>=100
and (
    (a.id-b.id=1 and b.id-c.id=1) or
    (c.id-b.id=1 and b.id-a.id=1) or
    (b.id-a.id=1 and a.id-c.id=1)
)
ORDER BY visit_date;