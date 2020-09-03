# A CRUD project for handling Supplier and Product data along with their related connection

The following project is a back-end (i.e. Rest Api project) as well as a front-end, implementation.

# Structure

### Back-End:

The database includes **Supplier** entities containing the following fields:
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

The database also includes **Product** entities containing the following fields:
* Product name
* Type
* Barcode
- There is a CRUD + Search REST API, able to handle Product entities and searches by:
  - Product name
  - Barcode
