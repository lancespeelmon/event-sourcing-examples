curl -X POST \
  http://localhost:8000/api/accounts \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
  "customerId": "cust1234",
  "description": "some description",
  "initialBalance": 0,
  "title": "TITLE #1",
  "productId": "prod1234"
}'
