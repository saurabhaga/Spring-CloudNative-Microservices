# Authenticate User API

### **Overview**

- This API will be used to authenticate the receptionist based on the username and password and will generate the JWT token which will be required to be passed in other api calls.
- login table is being used to store the username and password. 
- password is kept un-encrypted in table as this is just a demo.
- JPA is being used to interact with database and db details are configurable.


### **End Point Details**
**URL** - /authenticate

**Method-** POST

**Request Header -** 

- username
- password 

**Response Status Code**

- Authenticated - 200
- Unauthenticated - 401

**Response Header**

- token - This will be the signed JWT contains the token of limited expiry time of 15 mins.  API gateway OR other services will validate the expiry of token and will serve request only if token is not expired

_Note:_ token validation can be enhanced but for tutorial purpose, validation for expiry is applied.

 
**Sample Response** 

