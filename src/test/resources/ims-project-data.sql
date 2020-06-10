use testdb;
INSERT INTO item (item_name,  item_price) VALUES ('Floral Maxi Dress', 95.00), ('Chunky Sandals in Black', 50.00), ('2-pack Face Mask in Bandana Print', 12.00);
UPDATE item SET item_price=45 WHERE item_name='Chunky Sandals in Black';
INSERT INTO customer (customer_first_name, customer_last_name, customer_email, customer_password) VALUES ('Simon', 'Smith', 'si@mail.co.uk', '123456'), ('Maria', 'Morris', 'mm@gmail.com', 'qwerty'), ('Abu', 'Allen', 'abu@mail.com', '0000');
UPDATE customer SET customer_first_name='Paul', customer_last_name='Powell' WHERE customer_first_name='Simon';
INSERT INTO my_order (fk_customer_ID) VALUES (1), (2), (3);
UPDATE my_order SET my_order_ID = 100 WHERE my_order_placed = '2020-03-03';
INSERT INTO orderline (fk_my_order_ID, fk_item_ID) VALUES (100, 1), (2, 2), (2, 3);
UPDATE orderline SET qty_ordered = 107 WHERE orderline_ID = 1;