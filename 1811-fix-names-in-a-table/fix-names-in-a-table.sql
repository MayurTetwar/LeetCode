-- Write your PostgreSQL query statement below
SELECT user_id,concat(upper(substring(name,1,1)),lower(substring(name,2,length(name)))) as name FROM Users ORDER BY user_id;