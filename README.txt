In order to confirm data is actually being written to a SQL database go here in your browser http://localhost:8080/h2-console

Then make sure you go to the below db and you will see tables ORDER & ORDER_ITEM which will be populated after a request is made
JDBC URL: jdbc:h2:mem:testdb
User Name: sa

Call service @ http://localhost:8080/submitOrder with below JSON to create an order. Will return order id on successful creation:

{
	"customerId": "12345",
	"items": [
		{
			"productId":"8ed0e6f7",
			"quantity":1
		},
		{
			"productId":"c0258525",
			"quantity":3
		},
		{
			"productId":"0a207870",
			"quantity":2
		}
	]
}

To return an order call http://localhost:8080/getOrder?orderId={orderId} with order id created in submit call