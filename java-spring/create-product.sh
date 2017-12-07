curl -X POST \
  http://localhost:8000/api/products \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
  "productId": "prod1234",
  "productLongName": "Product Long Name #1",
  "productAbbreviation": "NO1",
  "productCategory": "cat1234",
  "activeDate": "2017-12-07"
}'
