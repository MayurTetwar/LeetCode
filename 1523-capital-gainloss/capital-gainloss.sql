-- Write your PostgreSQL query statement below
select stock_name,
sum(
    case 
        when operation='Sell' then price 
    end
)-sum(
    case 
        when operation='Buy' then price 
    end
) as capital_gain_loss
from Stocks 
group by stock_name    