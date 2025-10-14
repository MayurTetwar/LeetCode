/* Write your PL/SQL query statement below */
SELECT p.project_id ,round(avg(experience_years),2) as average_years  
FROM Project p natural join Employee e
group by p.project_id;