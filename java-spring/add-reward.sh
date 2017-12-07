curl -X POST \
  http://localhost:8000/api/accounts/rewards \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
  "accountId": "acc1234",
  "customer_id": "cust1234",
  "ar_product_id": "ar1234",
  "transaction_date": "2017-12-07",
  "amount", 1.00
}'
