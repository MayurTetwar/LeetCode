-- Write your PostgreSQL query statement below
select p.product_name, s.year, s.price from Product p 
inner join  Sales s ON p.product_id=s.product_id;