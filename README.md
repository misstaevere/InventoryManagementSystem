### Fundamental Project Specification:  Inventory Management System (IMS)

An application that an end user can interact with via a CLI (Command Line Interface). The application needs to be an inventory management system that needs to be able to: 

* Add a customer to the system
* View all customers in the system
* Update a customer in the system
* Delete a customer in the system
* Add an item to the system
* View all items in the system
* Update an item in the system
* Delete an item in the system
* Create an order in the system
* View all orders in the system
* Delete an order in the system
* Add an item to an order
* Calculate a cost for an order
* Delete an item in an order 

When considering the entities in this domain:

* A customer needs to have a name
* An item needs to have a name and a value
* An order needs to have a customer and contains items

##### Getting started

1. I created a Jira board with full expansion on user stories and tasks needed to complete the project.
2. I set up a remote database on MySQL Workbench and made sure the ERD for the project was present in the root of the project repository.
3. I then also hard coded SQL CRUD statements for customers, items and orders and made sure they worked as expected.
4. The hard-coded SQL statements then take in variables to create dynamically generated SQL statements. 
5. Added a Java method for the application to take in these variables and use JDBC to connect and send these queries to my remote database.
6. Added a method to take in user input and send the information to the database.
7. I have reports for tests in the root of the project repository.

Finally I have a running, working and tested application which takes in user input and can create, read, update and delete customers, items and orders. 

### Prerequisites

```
Java 1.8
MySQL 1.2.17
Maven 2.4
```
### Installing

```
git clone git@github.com:misstaevere/InventoryManagementSystem.git
cd InventoryManagementSystem/
mvn package
java -jar Kat-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

### To run tests 

In the directory where pom.xml is run:

```
mvn test
```
This runs the tests using a suitable testing framework, these tests should not require the code to be packaged or deployed.

## Authors

* **Kärt Taevere** - *Initial work* - [misstaevere](https://github.com/misstaevere)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thanks to our very patient QA trainers Chris Perrins, Piers Barber and Alan Davis
* also the training wouldn't have been the same without Mya the cat