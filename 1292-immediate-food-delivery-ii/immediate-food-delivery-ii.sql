SELECT 
    ROUND(
        (
            (SELECT COUNT(*) 
             FROM (
                 SELECT customer_id
                 FROM Delivery
                 GROUP BY customer_id
                 HAVING MIN(order_date) = MIN(customer_pref_delivery_date)
             )
            ) * 100.0
        ) / 
        (SELECT COUNT(DISTINCT customer_id) FROM Delivery),
        2
    ) AS immediate_percentage
FROM dual;
