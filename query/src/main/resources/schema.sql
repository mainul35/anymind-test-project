CREATE VIEW hourly_wallet_balance_history AS
SELECT row_number() OVER () as id, date_trunc('hour', datetime) as datetime_hour, wallet_id, sum(amount) as balance
FROM transaction
GROUP BY date_trunc('hour', datetime), wallet_id;