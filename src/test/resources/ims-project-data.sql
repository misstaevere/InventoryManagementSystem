use testdb;
INSERT INTO item (item_ID, item_name, qty_ordered, item_price, item_category) VALUES (0, 'Floral Maxi Dress', 1, 95.00, 'Dresses');
INSERT INTO item (item_ID, item_name, qty_ordered, item_price, item_category) VALUES (0, 'Chunky Sandals in Black', 1, 50.00, 'Shoes');
INSERT INTO item (item_ID, item_name, qty_ordered, item_price, item_category)VALUES (0, '2-pack Face Mask in Bandana Print', 5, 12.00, 'Accessories');
UPDATE item SET item_price=45 WHERE item_name='Chunky Sandals in Black';
INSERT INTO customer (customer_ID, customer_first_name, customer_last_name, customer_email, customer_password) VALUES (0, 'Simon', 'Smith', 'si@mail.co.uk', '123456');
INSERT INTO customer (customer_ID, customer_first_name, customer_last_name, customer_email, customer_password) VALUES (0, 'Maria', 'Morris', 'mm@gmail.com', 'qwerty');
INSERT INTO customer (customer_ID, customer_first_name, customer_last_name, customer_email, customer_password) VALUES (0, 'Abu', 'Allen', 'abu@mail.com', '0000');
UPDATE customer SET customer_first_name='Paul', customer_last_name='Powell' WHERE customer_first_name='Simon';
INSERT INTO my_order (my_order_ID, fk_customer_ID, my_order_placed) VALUES (0, 1, '2020-03-03');
INSERT INTO my_order (my_order_ID, fk_customer_ID, my_order_placed) VALUES (0, 2, '2020-04-03');
INSERT INTO my_order (my_order_ID, fk_customer_ID, my_order_placed) VALUES (0, 3, '2020-05-03');
UPDATE my_order SET my_order_ID = 100 WHERE my_order_placed = '2020-03-03';
INSERT INTO orderline (orderline_ID, fk_my_order_ID, fk_item_ID) VALUES (0, 3, 1);
INSERT INTO orderline (orderline_ID, fk_my_order_ID, fk_item_ID) VALUES (0, 4, 5);
INSERT INTO orderline (orderline_ID, fk_my_order_ID, fk_item_ID) VALUES (0, 5, 8);
UPDATE orderline SET qty_ordered = 107 WHERE orderline_ID = 1;