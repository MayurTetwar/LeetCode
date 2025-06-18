-- Write your PostgreSQL query statement below
select p.product_id,
case 
    when sum(us.units) is null then 0
    else round(CAST(sum(p.price*us.units*1.0)/sum(us.units)as numeric),2) 
    end
as average_price
from Prices p left join UnitsSold us
on p.product_id=us.product_id and
us.purchase_date between p.start_date and p.end_date
group by p.product_id;