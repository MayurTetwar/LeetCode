-- Write your PostgreSQL query statement below
SELECT (
SELECT distinct salary
FROM Employee 
ORDER BY salary desc offset 1 limit 1
) AS SecondHighestSalary 