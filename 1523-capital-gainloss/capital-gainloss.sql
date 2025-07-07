-- Write your PostgreSQL query statement below
select distinct stock_name,
sum(
    case
        when operation='Sell' then price
        else -price
    end
) over (partition by stock_name) as capital_gain_loss 
from Stocks