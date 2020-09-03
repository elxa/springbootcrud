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
* If you want to include some data in the database you need to run these queries: 
  - insert into supplier values(null, "ethnarxou", "athens", "publicsoft", "greece", "elenh”, "dd", "papadopoulou", "ddd", "10443");
   - insert into supplier values(null, "sepolia", "athens", "accenture", "greece", "giorgos", "dd", "gewrgiou", "hhh12", "10443");
    - insert into supplier values(null, "paiania", "athens", "intralot", "greece", "stelios", "dd", "steliou", "kiki", "10443");
    - insert into supplier values(null, "hlioupolh", "athens", "publicsoft", "greece", "xrhstos", "dd", "xrhstou", "dw121", "10443");
    - insert into person values(null,"dddde", "ggg@gmai.com", "MALE", 0, "6937861214", "jim");
    - insert into product values(null, "12sde", "fer", "pen");
    - insert into product values(null, "342sde", "20000 leuges katw apo th 8alassa", "book");
    - insert into product values(null, "12345", "h panagia twn parisiwn", "book");
    - insert into supplierproduct values(null, 1,1);
    - insert into supplierproduct values(null, 1,2);
    - insert into supplierproduct values(null, 2,1); 

