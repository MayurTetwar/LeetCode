--Write your PostgreSQL query statement below
(
    select u.name as results
    from Users u
    join MovieRating mr
    on u.user_id = mr.user_id
    group by u.name
    order by count(mr.movie_id) desc,u.name
    limit 1
)
union all
(
    select m.title as results
    from Movies m
    join MovieRating mr
    on m.movie_id = mr.movie_id  
    where TO_CHAR(mr.created_at,'YYYY-MM')='2020-02'
    group by m.title 
    order by avg(mr.rating) desc,m.title asc  
    limit 1
 )