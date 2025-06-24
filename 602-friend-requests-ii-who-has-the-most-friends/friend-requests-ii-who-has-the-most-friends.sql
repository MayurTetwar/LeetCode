-- Write your PostgreSQL query statement below

select requester_id as id,max(count) as num
    from (
        select requester_id,count(requester_id)
        from 
        (
            SELECT requester_id from RequestAccepted 
            UNION ALL
            SELECT accepter_id  from RequestAccepted 
        )
        group by requester_id
    )
group by requester_id
order by max(count) desc limit 1;