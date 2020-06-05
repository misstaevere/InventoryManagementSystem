use testdb;
INSERT INTO item (item_name, qty_ordered, item_price, item_category) VALUES ('Floral Maxi Dress', 1, 95.00, 'Dresses');
INSERT INTO item (item_name, qty_ordered, item_price, item_category) VALUES ('Chunky Sandals in Black', 1, 50.00, 'Shoes');
INSERT INTO item (item_name, qty_ordered, item_price, item_category)VALUES ('2-pack Face Mask in Bandana Print', 5, 12.00, 'Accessories');
UPDATE item SET item_price=45 WHERE item_name='Chunky Sandals in Black';
INSERT INTO customer (customer_first_name, customer_last_name, customer_email, customer_password) VALUES ('Simon', 'Smith', 'si@mail.co.uk', '123456');
INSERT INTO customer (customer_first_name, customer_last_name, customer_email, customer_password) VALUES ('Maria', 'Morris', 'mm@gmail.com', 'qwerty');
INSERT INTO customer (customer_first_name, customer_last_name, customer_email, customer_password) VALUES ('Abu', 'Allen', 'abu@mail.com', '0000');
UPDATE customer SET customer_first_name='Paul', customer_last_name='Powell' WHERE customer_first_name='Simon';
INSERT INTO my_order (fk_customer_ID, my_order_placed) VALUES (1, '2020-03-03');
INSERT INTO my_order (fk_customer_ID, my_order_placed) VALUES (2, '2020-04-03');
INSERT INTO my_order (fk_customer_ID, my_order_placed) VALUES (3, '2020-05-03');
UPDATE my_order SET my_order_ID = 100 WHERE my_order_placed = '2020-03-03';
INSERT INTO orderline (fk_my_order_ID, fk_item_ID) VALUES (1, 1);
INSERT INTO orderline (fk_my_order_ID, fk_item_ID) VALUES (2, 5);
INSERT INTO orderline (fk_my_order_ID, fk_item_ID) VALUES (2, 8);
UPDATE orderline SET qty_ordered = 107 WHERE orderline_ID = 1;