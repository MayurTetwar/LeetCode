-- Write your PostgreSQL query statement below
with cte as (
    select 
        ip
    from logs
    where (
        array_length(string_to_array(ip,'.'),1)!=4 or (
            split_part(ip,'.',1) ~ '^[0][0-9]*$' or split_part(ip,'.',1)::int>255
        ) or (
            split_part(ip,'.',2) ~ '^[0][0-9]*$' or split_part(ip,'.',2)::int>255
        ) or (
            split_part(ip,'.',3) ~ '^[0][0-9]*$' or split_part(ip,'.',3)::int>255
        ) or (
            split_part(ip,'.',4) ~ '^[0][0-9]*$' or split_part(ip,'.',4)::int>255
        )
    )
)
select ip,count(ip) as invalid_count from cte
group by ip
order by invalid_count desc, ip desc