## RESTful web-service for credit card validation and mortgage calculation
### [Detailed API info, requests/responses examples and more](https://app.swaggerhub.com/apis/MykytaDan/CVMC_API/1.0.0)

### How to build?
Steps for building and running this app with Docker:

1. Clone this repository
` git clone https://github.com/Nikitosique/ALM.Task_1.git `

2. Go to project source directory

3. Create Docker image 
` docker build -t banking-web-service .`

4. Run Docker container
` docker run -d -p 8080:8080 banking-web-service`

5. Test with [Postman](https://www.postman.com/downloads/).
 
   Requests and responses body examples are [here](https://app.swaggerhub.com/apis/MykytaDan/CVMC_API/1.0.0). 
   Webservise is available on your local machine via ` http://localhost:8000/ `



