# EvamPatikaFinalProject
The final project of Evam-Patika Bootcamp

### CRUD PROCESS
* A GET request is used to obtain details from the server and does not have any impact on the server.
* Postman POST request allows appending data to the endpoint. This is a method used to add information within the request body in the server.
* A Postman PUT request is used to pass data to the server for creation or modification of a resource.
* Postman DELETE request deletes a resource already present in the server. The DELETE method sends a request to the server for deleting the request mentioned in the endpoint.

## Post Request for Customer
```http
  POST /api/customers
```
![post customer](https://user-images.githubusercontent.com/24360606/180658977-5502029c-f171-47e6-83a0-7ce2777f9e5c.PNG)

Here the STATUS code is 200 OK (This code is used for a successful request); this means the server approved the request, and we received a positive response. Here, "Customer with ID: 1 is created successfully" means your entry has been created successfully, and your POST request has done successfully. 

## Get Request for Customer
```http
  GET /api/customers
```
![get customer](https://user-images.githubusercontent.com/24360606/180658867-eea4dde2-b508-4a2e-a3d8-769661b59077.PNG)

Once a request has been sent, we can see the response code 200 OK populated in the Response. This signifies a successful request and a correct endpoint.

## Get Request for Customer id
```http
  GET /api/customers{id}
```
![get id customer](https://user-images.githubusercontent.com/24360606/180659017-74b4f01d-bd17-41f7-ba6c-f7a4122b2118.PNG)

Once a request has been sent, we can see the response code 200 OK populated in the Response. This signifies a successful request and a correct endpoint.

## Put Request for Customer
```http
  PUT /api/customers/{customerId}?name = Henry
```
```http
  PUT /api/customers/{customerId}?surname = Loveridge
```
![put customer](https://user-images.githubusercontent.com/24360606/180659024-b986f73b-671e-47d3-a1df-c44719657063.PNG)

Once a request has been sent, we can see the response code 200 OK populated in the Response body. This signifies a successful request and the request we have sent has been accepted by the server.

## Delete Request for Customer
```http
  DELETE /api/customers/{id}
```
![delete customer](https://user-images.githubusercontent.com/24360606/180659041-44b0badd-8730-4ebc-b66e-1c08450c58eb.PNG)

Once a request has been sent, we can see the Response code 200 OK populated in the Response. This signifies a successful request and the request we have sent has been accepted by the server.

## Post Request for Invoice
```http
  POST /api/customers/{customerId}/invoices
```
![post invoices;](https://user-images.githubusercontent.com/24360606/180659050-378c060b-efc9-4baa-877e-211e88fc04af.PNG)

Here the STATUS code is 201 Created (For a successful request and data was created); this means the server approved the request, and we received a positive response. Here, -you will see your request as a JSON format in body- means your entry has been created successfully, and your POST request has done successfully.

## Post Request for Invoice 
```http
  POST /api/customers/{customerId}/invoices
```
![post invoices1](https://user-images.githubusercontent.com/24360606/180659096-49760490-5212-49a7-b8d1-65697178890e.PNG)

Here the STATUS code is 201 Created (For a successful request and data was created); this means the server approved the request, and we received a positive response. Here, -you will see your request as a JSON format in body- means your entry has been created successfully, and your POST request has done successfully. 

## Get Request for Invoice id!
```http
  GET /api/customers/{customerId}/invoices/{id}
```
[get id invoice](https://user-images.githubusercontent.com/24360606/180659054-4560a678-5685-45ef-95eb-7cffece7b8dc.PNG)

Once a request has been sent, we can see the response code 200 OK populated in the Response. This signifies a successful request and a correct endpoint.

## Get Request for Customers/ Invoices
```http
  GET /api/customers/{customerId}/invoices
```
![get customers invoices](https://user-images.githubusercontent.com/24360606/180659063-d59d4dce-cacd-41dc-8e50-7af3dece9f79.PNG)

Once a request has been sent, we can see the response code 200 OK populated in the Response. This signifies a successful request and a correct endpoint.

## DELETE Request for Invoice
```http
  DELETE /api/invoices/{id}
```
![delete invoices](https://user-images.githubusercontent.com/24360606/180659074-d23eae15-bac4-4dca-a8fb-11318bd041c3.PNG)

The HTTP 204 No Content success status response code indicates that a request has succeeded, but that the client doesn't need to navigate away from its current page. So, the request deleted successfully. 

## Put Request for Invoice
```http
  PUT /api/invoices1/{id}
```
![put invoices](https://user-images.githubusercontent.com/24360606/180659072-2bd457c5-eaee-429a-9025-dd4d8e50a47d.PNG)

Once a request has been sent, we can see the response code 200 OK populated in the Response body. This signifies a successful request and the request we have sent has been accepted by the server.

## Post Request for Payment
```http
  POST /api/customers/{customerId}/payments/{id}
```
![post payment](https://user-images.githubusercontent.com/24360606/180659097-707446bd-045b-4539-aea8-f0e0de3e76d2.PNG)

Here the STATUS code is 201 Created; this means the server approved the request, and we received a positive response. Here, -you will see your request as a JSON format in body- means your entry has been created successfully, and your POST request has done successfully. 

## Get Request for Payment
```http
  GET /api/payments/{id}
```
![get payment](https://user-images.githubusercontent.com/24360606/180659104-9c46fd0f-70eb-43ce-a102-1013363889d2.PNG)

Once a request has been sent, we can see the response code 200 OK populated in the Response. This signifies a successful request and a correct endpoint.

## Delete Request for Payment
```http
  DELETE /api/payments/{id}
```
![delete payment](https://user-images.githubusercontent.com/24360606/180659111-52cd424e-2b03-4408-b65f-ef73669fabee.PNG)

The HTTP 204 No Content success status response code indicates that a request has succeeded, but that the client doesn't need to navigate away from its current page. So, the request deleted successfully. 





