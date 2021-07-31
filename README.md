## RESTful web-service for credit card validation and mortgage calculation
### This project was developed under the guidance of [Andrii Latyshev](https://www.linkedin.com/in/andrylat/)
### [Detailed API info, requests/responses examples and more](https://app.swaggerhub.com/apis/MykytaDan/CVMC_API/1.0.0)

### Used technologies
- Java 8
- Maven
- Swagger
- Jersey
- JUnit
- Docker
- Github Actions

### How to build?
Steps for building and running this app with Docker:

1. Pull Docker image: ` docker pull nikitosique/banking-app:latest `

2. Run Docker container: ` docker run -d -p 8080:8080 nikitosique/banking-app `

### How to test?

1. Test with [Postman](https://www.postman.com/downloads/).

2. For credit card validation execute ` POST ` request at url ` localhost:8080/cardnumber/validation `. 

      Request body example:

      `{`

      `"card-number": "4455555555555555"`

      `}`

3. For mortgage calculation execute ` POST ` request at url ` localhost:8080/mortgage/calculation `.  

      Request body example:

      `{`
      
      `"loan-amount": "100000",`
      
      `"interest-rate": "6",`
      
      `"term-years": "15"`
      
      `}`
