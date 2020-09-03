# A CRUD project for handling Supplier and Product data along with their related connection

The following project is a back-end (i.e. Rest Api project) as well as a front-end, implementation.

# Structure

### Back-End:

1. The database includes **Supplier** entities containing the following fields:
  * Company name
  * First name
  * Last name
  * VAT number
  * IRS office
  * Address
  * ZIP code
  * City
  * Country
  - There is a CRUD + Search REST API, able to handle Supplier entities and searches by:
    - Company name
    - VAT number

2. The database also includes **Product** entities containing the following fields:
  * Product name
  * Type
  * Barcode
  - There is a CRUD + Search REST API, able to handle Product entities and searches by:
    - Product name
    - Barcode

3. The database finally runs a matching between the Supplier and Product entities
-There is the 

### Front-End:
Implemention of the matching CRUD + Search screen(s) for the REST API defined above.

# Instructions
Initially it is necessary to have installed the following requirements:
* OpenJDK 1.8
* Maven 3.x
* Git 2.x
* MySQL 5.x
* Node.js 6.x

### Back-End:
* Create an empty database with name: springbootcrud
* Later, open the file: springbootcrud-webapp/src/main/resources/application.properties and
modify the following properties, depending on your MySQL installation:
  - spring.datasource.username=root
  - spring.datasource.password=”your password”
  - Run the Application.class
  
* **Finally, check your application:**
  - You can make use of Swagger when running your application:
  - Type in your browser this url http://localhost:8080/swagger-ui.html
    - For example, If you want to add a supplier to the database, follow the steps: supplier-controller→ post → try it out→ configure the json file → execute. If the data has successfully been saved in the database, the response will be ‘200’ with the description ‘ok’ and the supplier you have created. If not, then a ‘400’ followed by a description of the error will ensue.
    - If you choose to get all the suppliers from the database, follow the steps: supplier-controller → get → try it out → execute.
    - if you want to search by Company name or VAT number :supplier-controller→ get → try it out → put in the input the corresponding data.

Similar steps are to be followed for the rest controllers. 



