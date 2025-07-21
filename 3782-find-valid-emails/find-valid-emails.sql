SELECT *
FROM users
WHERE email ~ '^[a-zA-Z0-9_]+@[a-zA-Z]+.com$'
ORDER BY user_id;