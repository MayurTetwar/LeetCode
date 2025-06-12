-- Write your PostgreSQL query statement below
SELECT distinct author_id as id FROM Views where author_id = viewer_id order by author_id ASC;