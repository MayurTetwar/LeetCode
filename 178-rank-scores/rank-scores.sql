-- Write your PostgreSQL query statement below
SELECT score, 
DENSE_RANK() OVER (ORDER BY score desc) as rank
from Scores;