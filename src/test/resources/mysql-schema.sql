drop database imsDB
create database if not exists imsDB;
create table if not exists imsDB.customers(customer_id int(11) primary key NOT NULL auto_increment, forename varchar(120) NOT NULL, surname varchar(40) NOT NULL);
create table if not exists imsDB.products(product_id int primary key NOT NULL auto_increment, name varchar(200) NOT NULL, category varchar(20) DEFAULT 'Miscellaneous' NOT NULL, price double(10,2) DEFAULT 0, inventory int(11) DEFAULT 0);
create table if not exists imsDB.orders(order_id int primary key NOT NULL auto_increment, customer_id int(11) NOT NULL, date_ordered date NOT NULL, FOREIGN KEY (customer_id) REFERENCES customers(customer_id));
create table if not exists imsDB.orderline(product_id int(11) NOT NULL, order_id int(11) NOT NULL, quantity_ordered int(11) NOT NULL, FOREIGN KEY (product_id) REFERENCES products(product_id), FOREIGN KEY (order_id) REFERENCES orders(order_id));
