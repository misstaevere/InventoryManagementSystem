use shopdb;

-- ITEM
#Create
INSERT INTO item (item_ID, item_name, item_price)
VALUES (0, 'Floral Maxi Dress', 95.00);

INSERT INTO item (item_ID, item_name, item_price)
VALUES (0, 'Chunky Sandals in Black', 50.00);

INSERT INTO item (item_ID, item_name, item_price)
VALUES (0, '2-pack Face Mask in Bandana Print', 12.00);

#Read
SELECT * FROM item;
DESCRIBE item;
SELECT item_name, item_price FROM item;
SELECT DISTINCT (item_name) FROM item;

#Update
UPDATE item SET item_price=45 WHERE item_name='Chunky Sandals in Black';

#Delete
DELETE FROM item WHERE item_ID = 1;

-- Customer
#Create
INSERT INTO customer (customer_ID, customer_first_name, customer_last_name, customer_email, customer_password)
VALUES (0, 'Simon', 'Smith', 'si@mail.co.uk', '123456');

INSERT INTO customer (customer_ID, customer_first_name, customer_last_name, customer_email, customer_password)
VALUES (0, 'Maria', 'Morris', 'mm@gmail.com', 'qwerty');

INSERT INTO customer (customer_ID, customer_first_name, customer_last_name, customer_email, customer_password)
VALUES (0, 'Abu', 'Allen', 'abu@mail.com', '0000');

#Read
SELECT * FROM customer;
DESCRIBE customer;
SELECT customer_first_name, customer_email FROM customer;
SELECT * from customer WHERE customer_first_name LIKE '%s';

#Update
UPDATE customer SET customer_first_name='Paul', customer_last_name='Powell' WHERE customer_first_name='Simon';

#Delete
DELETE FROM customer WHERE customer_email = 'mm@gmail.com';

-- My_Order
#Create
INSERT INTO my_order (my_order_ID, fk_customer_ID)
VALUES (0, 1);

INSERT INTO my_order (my_order_ID, fk_customer_ID)
VALUES (0, 4);

INSERT INTO my_order (my_order_ID, fk_customer_ID)
VALUES (0, 3);

#Read
SELECT * FROM my_order;
DESCRIBE my_order;
SELECT my_order_placed, my_order_total FROM my_order;
SELECT * from my_order ORDER BY my_order_placed;

#Update
UPDATE my_order SET my_order_ID = 100 WHERE my_order_ID = 1;

#Delete
DELETE FROM my_order WHERE my_order_ID = 3;

-- Orderline
#Create
INSERT INTO orderline (orderline_ID, fk_my_order_ID, fk_item_ID)
VALUES (0, 2, 2);

INSERT INTO orderline (orderline_ID, fk_my_order_ID, fk_item_ID)
VALUES (0, 4, 3);

INSERT INTO orderline (orderline_ID, fk_my_order_ID, fk_item_ID)
VALUES (0, 100, 4);

#Read
SELECT * FROM orderline;
DESCRIBE orderline;
SELECT * from orderline ORDER BY orderline_ID LIMIT 3;

#UPDATE
UPDATE orderline SET qty_ordered = 107 WHERE orderline_ID = 1;

#Delete
DELETE FROM orderline WHERE orderline_ID = 3;

DROP TABLE orderline;
DROP TABLE my_order;
DROP TABLE customer;
DROP TABLE item;

-- DROP DATABASE shopdb;