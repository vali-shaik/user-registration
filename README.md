# user-registration
REST API to register users based on GEO location


# app-url API documentation
http://localhost:8080/ibm/swagger-ui/index.html

# POST API to register a user
[http://localhost:8080/ibm/register](http://localhost:8080/ibm/register)

<img width="1534" alt="Screenshot 2023-04-20 at 16 35 55" src="https://user-images.githubusercontent.com/60362102/233470185-1c273b1a-63c9-429d-bc96-cb9a6a7f9680.png">

# Github actions CI CD
<img width="1536" alt="Screenshot 2023-04-20 at 17 19 02" src="https://user-images.githubusercontent.com/60362102/233479027-f2f124ca-438a-45e0-bfd5-663c49d0e013.png">

<img width="981" alt="Screenshot 2023-04-20 at 17 19 35" src="https://user-images.githubusercontent.com/60362102/233479223-60ea81af-d249-4735-9fd0-8fea4be3804b.png">


# Code Assignment
Write an API microservice using spring boot to simulate user registration:
- Expose REST API to accept a payload of username, password, and IP address.
- All parameters must not be blank (!= empty and null). Return error messages if not valid
- Password need to be greater than 8 characters, containing at least 1 number, 1 Captialized letter, 1 special character in this set "_ # $ % ." Return error messages if not valid
- Call this end point to get geolocation for the provided IP:IP-API.com - Geolocation API - Documentation - JSON. If the IP is not in Canada, return error message that user is not elligible to register
- When all validation is passed, return a random uuid and a welcome message with his username and his City Name (resolved using ip-geolocation api)
- The API need to have OpenAPI specification, no matter what your approach is code first or design first.
- Project must use maven or gradle to build. Generate a spring boot project here: Spring Initializr 
- Need to have JUnit Tests
- Code must be shared via bitbucket or github
