/* Write your PL/SQL query statement below */
SELECT DISTINCT product_id 
from Products
where low_fats='Y' and recyclable='Y';
