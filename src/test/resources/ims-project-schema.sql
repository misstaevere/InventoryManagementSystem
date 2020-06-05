drop database if exists testdb;
CREATE DATABASE IF NOT EXISTS testdb;
use testdb;
CREATE TABLE if not exists item (item_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, item_name VARCHAR(100) NOT NULL, item_price DEC(7, 2) NOT NULL);
CREATE TABLE customer (customer_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, customer_first_name VARCHAR(100) NOT NULL, customer_last_name VARCHAR(100) NOT NULL, customer_email VARCHAR(100) NOT NULL, customer_password VARCHAR(30), UNIQUE (customer_email));
CREATE TABLE my_order (my_order_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, fk_customer_ID INT NOT NULL, my_order_placed DATE, my_order_total DEC(7 , 2 ), FOREIGN KEY (fk_customer_ID) REFERENCES customer (customer_ID));
CREATE TABLE orderline (orderline_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, fk_my_order_ID INT NOT NULL, fk_item_ID INT NOT NULL, qty_ordered INT, FOREIGN KEY (fk_my_order_ID) REFERENCES my_order (my_order_ID), FOREIGN KEY (fk_item_ID) REFERENCES item (item_ID));