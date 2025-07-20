-- Write your PostgreSQL query statement below
with cte as (
    select
    r.user_id,sum(r.distance)as travelled_distance
    from Rides r
    group by r.user_id
), cte2 as (
    select u.name,(
        case 
            when c.travelled_distance is null then 0
            else c.travelled_distance
        end
    )
    from Users u left join cte c
    on u.id=c.user_id
)
select * from cte2
order by travelled_distance desc,name;

