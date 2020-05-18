Test Coverage: Junit - 70.5%, SonarQube 53.3%
# Redfern Inventory Management System - QA Individual Project 

The Redfern Inventory Management System is a [Java](https://www.java.com/en/)-based application which utilises [JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html) to create, read, update and destroy entries within an [MySQL](https://www.mysql.com/) database hosted on [GCP](https://console.cloud.google.com/). The project's source code is being developed on [Eclipse IDE](https://www.eclipse.org/) and is built using [Maven](https://maven.apache.org/). [Jenkins](https://www.jenkins.io/) is used as a CI Pipeline to send to an instance on GCP, which hosts [SonarQube](https://www.sonarqube.org/), and to send to [Nexus Artifact Repository](https://www.sonatype.com/product-nexus-repository).
Progress on the project can be viewed in the [Projects tab on GitHub as a kanban board](https://github.com/Christian-QA/ims-redfern-project/projects/1).

The program can be run on a terminal of your choice, though is only confirmed to work on cmd.exe (Windows Command Prompt).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To use this program, you will need:

- [Java SE 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) or later (needed to run the jar file located in the target folder)
- A [mySQL](https://www.mysql.com/) database, preferably one hosted on [GCP](https://console.cloud.google.com/) as this application was built with GCP in mind.

There is currently no MySQL database linked to this project and will need to be set up by the user. If you wish to change the database, you can configure the JDBC Connection Url and the local schema directory within the DBConfiguration class within the project (either through eclipse in the same package as the Runner or directly by navigating to the '\src\main\java\com\qa\ims' in your file explorer and opening 'DBConfiguration' using a text editor of your choice.

To develop using this project, you will need:

- [Eclipse IDE](https://www.eclipse.org/) or a similar IDE
- [Apache Maven](https://maven.apache.org/)

If you use this project for your own development, you will need to follow the instructions above in order to use your own database.

## Getting Started

To run the application, use a terminal of your choice (Windows Command Prompt is recommended). You will be prompted to enter your username and password. By default, these are both set to 'root', though will differ based on how you configured your database if you have changed the JDBC Connection Url.

From here, you will have five options (Domain Commands) which can either be selected by inputting the number or word surrounded by square brackets ([ ]). The words are not case sensitive. These options are:

1. Review customers - This selects the customers table for manipulation. The customer table contains three fields:

   - customer_id (primary key)
   - forename
   - surname

2. Review products - This selects the products table for manipulation. The products table contains five fields:

   - product_id (primary key)
   - name
   - category
   - price
   - inventory

3. Review orders - This displays an additional option asking if you want to manipulate all orders or a specific orderline. The orders table is what links the customers to their orders, while the orderline table is what links the products to a specific order.

- The orders table contains three fields:
  - order_id (primary key)
  - customer_id (foreign key)
  - date_ordered
- The orderline table contains three fields:
  - product_id (foreign key)
  - order_id (foreign key)
  - quanitity_ordered

4. Help - This displays a simple explanation of what each option does, after which you cannot proceed until you've selected an option (note: if you select 'help' twice, the help task will repeat and you will still need to select an option).

5. Stop - Ends the program

If you entered either options one or two, or you entered three followed by one, you will be given six new options:

- Create - Allows you to add an entity to the table selected from the previous set of options.
- Read - Allows you to read every entry within the selected table.
- Update - Allows you to edit an entity within the selected table.
- Delete - Allows you to delete an entity from the table.
- Help - This displays a simple explanation of what each option does, after which you cannot proceed until you've selected an option (note: if you select 'help' twice, the help task will repeat and you will still need to select an option).
- Return - Brings you back to the previous set of options.

### Customer

The mySQL database is set up to automatically input and auto-increment the customer_id, meaning all you need to create a customer is their forename and surname.

Choosing to read the customers table will display every entry in the table. With the current version, specific selection of a customer to read is yet to be implemented, so this read function is the only way to find the customer_id of a customer you wish to update or delete.
To update a customer, you need to know their customer_id. The only way to find their id is to use the read command or to directly interface with the mySQL. Once you have their customer_id, you can input it when prompted following the selection of the update option. Following this, you enter the new forename and surname of the customer. You do not need to specify the original name of the customer at any point. The customer_id will not change following this action.

As with updating a customer, deleting a customer from the database requires knowing their customer_id. This can be found using the read action. Once the customer_id has been inputted following the selection of this option, the customer is removed from the database. The customer_id does not decrement, meaning this customer_id cannot be used again unless the table or the entire database is dropped and recreated (you can do this by inputting the mySQL commands found in the '/src/test/resources/mysql-schema.sql', **though this will delete every entity from the entire database**).

### Product

The mySQL database is set up to automatically input and auto-increment the product_id, meaning all you need to create a product is the name. The other values (category, price and quantity) are nullable and can be left blank, though can be given values using this option if desired. Category will default to 'Miscellaneous', price will default to '0.0' and quantity will default to '0'.

Reading the products table will read the entire table, and is the only way to find the product_id from the application.

To update a product, you need to know its product_id. This can be found through the read action, the same as when reading the customer table. Following this, you will be asked for the new name, category, price and quantity. All values need to be inputted in the current version to avoid throwing an error.

To delete a product, you need to know its product_id. This can also be found using the read action. As with the customer delete option, the auto-increment will not be reset in any way, meaning that product_id will not be used again unless the table or database is dropped.

### Order and Orderline

The difference between an order and an orderline is that an order takes in details about a customer and when the order was made, but doesn't contain anything about the contents of the order itself. The orderline gives the order meaning by adding products to the order in question by its id. To manipulate customer and date related details of an order, select order. To manipulate the contents of an order (i.e. add and remove products), select orderline.

Choosing to create an order will ask you to input the customer_id you wish to attach to it. You will need to read the customers table to know the specific id of the customer you wish to affiliate with the order. The date is set to local time upon the creation of the order, and can be changed by updating the order.

Choosing to create an orderline will ask you which product you would like to add by its product_id and the quantity. To find the product_id, you will need to read the products table. With the current version, you can only add the products one at a time.

Choosing to read the orders table will display every order made by the order_id, customer_id and date_ordered.

Choosing to read the orderline table will prompt you to ask the order_id of the order you wish to read. Once inputted, you will be shown the product_id, name of the product, quantity and price (both the price of each product and a price taken from multiplying the price value by the quantity, not to be confused with the overall price) of each product (by id) ordered. You will not be shown details about the customer or the date ordered, as these are viewed from the orders table. At the bottom will be the total price of the order, adding together the price multiplied by quantity of every product in the order.

Choosing to update the orders table will ask you to enter the order_id of the order you wish to modify. You can find the order_id by reading the orders table. Following this, you will be asked which customer_id you wish to use (you need to enter a value to avoid an error, making it recommended to view the orders table first to see the customer_id if you do not wish to change it). You will be asked to input a date, as updating it will not default it to local time. If you do not wish to change the date, you will need to enter the original date in the format specified (yyyy-mm-dd).

You cannot update the orderline with the current version of this application as the only value which could be changed is the quantity_ordered. As the use is too niche to be above low priority, it has been set aside until there is a demand for it as a feature.

Choosing to delete an order will ask you the order_id of the order you wish to delete. Entering the order_id will attempt to delete the order, **but the orderline linked to this order_id must be empty first**. For now, the number three command which is usually fulfilled by update is reserved for a read specific function where the user can search for a customer by username.

Choosing to delete an orderline will ask you the order_id of the order you wish to delete from, and the product you wish to delete. If you wish to delete the enter order, you will need to delete every product from within the orderline and then delete the order.

## Running the Tests

The project utilises three different tools for testing: JUnit for Unit Testing, JUnit with Mockito for Integration Testing, and SonarQube for Coding Style Tests.

### Unit Tests

Individual modules within the program can be tested using JUnit, which tests the methods within their main counterpart.

To test on JUnit (Eclipse):

1. Right click on the class you wish to test in the file explorer of the Eclipse IDE, as found in src/test/java, not the actual classes found in src/main/java (to run all tests, right click the src/test/java folder instead).
2. Hover over 'Run As' on the dropdown menu.
3. Click '2 JUnit Test'.
4. All tests within the application are undertaken and can be reviewed using the 'JUnit' and 'Coverage' windows.

## Integration Tests

Mockito is used to run integration tests by mocking user input, creating a map of possible inputs to test if they're consistently error-proofed. Mockito tests are run using JUnit alongside the basic unit tests, meaning they follow the same steps as unit tests.

## Coding Style Tests

To test on SonarQube (you must have Maven installed on your computer to build the project for SonarQube to read):

1. Create a VM Instance on GCP called 'sonarqube'.
2. Click on the instance name.
3. Click 'edit'.
4. Scroll down to network tags and give it the tag 'tcp-9000'.
5. Go back to your instance list and click 'SSH' beneath 'connect'
6. Once you have access to the terminal, enter 'docker start sonarqube'
7. Open a new tab in any browser and enter the external IP of your instance (next to 'SSH'), followed by a semicolon, followed by '9000'. You should now have access to SonarQube.

Deploy to SonarQube using a local terminal:

8. Open a terminal within your local project directory.
9. Enter 'mvn clean package test'.
10. Enter 'mvn sonar:sonar -Dsonar.host.url=http://<YOUR EXTERNAL IP>:9000 -Dsonar.login.admin=admin -Dsonar.password=admin'.

Deploy to SonarQube using Jenkins:

8. Create a project on Jenkins.
9. Link it to your GitHub Repository URL for this project (either from this repository or your own forked version).
10. Ensure 'Poll SCM' and 'Abort the build if it's stuck' are checkout (optional: build periodically with 'H \* \* \* \*' typed into the 11. Schedule for hourly testing).
11. Create two 'Execute Windows batch commands'
    12.In the first Windows batch command, enter 'mvn clean package test'.
12. In the second Windows batch command, enter 'mvn sonar:sonar -Dsonar.host.url=http://<YOUR EXTERNAL IP>:9000 -Dsonar.login.admin=admin -Dsonar.password=admin'.

Following these steps, the project should now be viewable on the tab you opened for SonarQube.

## Deployment

The project is open source, therefore is available to anyone to clone or fork.
Regardless of whether you clone this repository or a repository you forked, you will need to open a terminal within the local directory and enter the following:

- mvn clean package
- cd target/
- java -jar ChristianRedfern-SoftwareMarch16-jar-with-dependencies.jar

Note: if you changed the Artifact Id within your pom.xml, you will need to enter the new id followed by .jar instead. If you are unsure

## Built With

- [Eclipse](https://www.eclipse.org/) - IDE
- [Maven](https://maven.apache.org/) - Dependency Management
- [GCP (Google Cloud Platform](https://console.cloud.google.com/) - Database and Instance Host
- [MySQL](https://www.mysql.com/) - Database Language
- [Jenkins](https://www.jenkins.io/) - CI Pipeline
- [Git](https://git-scm.com/) - Local Repository and Version Control
- [GitHub](https://github.com/) - Online Repository, Version Control and Project Management
- [SonarQube](https://www.sonarqube.org/) - Static Program Analysis
- [Nexus](https://www.sonatype.com/product-nexus-repository) - Artifact Repository
- [JUnit](https://junit.org/junit5/) - Testing
- [Mockito](https://site.mockito.org/) - Testing

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

- \*_Christian Redfern_ - _Author_ - [Christian-QA](https://github.com/Christian-QA)
- \*_Chris Perrins_ - _Initial work_ - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details

_For help in [Choosing a license](https://choosealicense.com/)_

## Acknowledgements

- Chris Perrins - Provided a working early version of the project capable of CRUD functionality with the customers table - [christophperrins](https://github.com/christophperrins)
- Nicholas Johnson - Software Trainer - [nickrstewarttds](https://github.com/nickrstewarttds)
- Jordan Harrison - Software Trainer - [JHarry444](https://github.com/JHarry444)
- Caroline Strasenburgh - Advice with Java and Github - [CarolineS-QA](https://github.com/CarolineS-QA)
- Korbinian Ring - Assistance with Java planning - [KMRRingQA](https://github.com/KMRRingQA)
