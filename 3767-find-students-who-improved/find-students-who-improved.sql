-- Write your PostgreSQL query statement below
with fltable as (
    select 
        student_id, subject,
        first_value(score) over(partition by student_id,subject order by exam_date) as first_score ,
        last_value(score) over(partition by student_id,subject order by exam_date) as latest_score,
        row_number() over (partition by student_id,subject order by exam_date desc) as rnk
        from Scores
    order by student_id, subject
)

select student_id , subject , first_score , latest_score from fltable
where first_score<latest_score and rnk=1;