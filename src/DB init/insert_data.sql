INSERT INTO category_details (category_name, description, status) VALUES
('Electronics', 'Devices and gadgets', 'Active'),
('Clothing', 'Apparel and attire', 'Active'),
('Home & Kitchen', 'Household items and appliances', 'Active'),
('Books', 'Literature and reading materials', 'Active'),
('Sports & Outdoors', 'Athletic gear and outdoor equipment', 'Active'),
('Beauty & Personal Care', 'Cosmetics and grooming products', 'Active'),
('Toys & Games', 'Playthings and entertainment', 'Active'),
('Health & Wellness', 'Fitness and well-being products', 'Active'),
('Automotive', 'Vehicle-related products', 'Active'),
('Pet Supplies', 'Items for pets', 'Active');

INSERT INTO brand_details (brand, status) VALUES
('Nike', 'Active'),
('Adidas', 'Active'),
('Apple', 'Active'),
('Samsung', 'Active'),
('Sony', 'Active'),
('Microsoft', 'InActive'),
('Google', 'InActive'),
('LG', 'InActive'),
('Amazon', 'InActive'),
('Puma', 'InActive');

INSERT INTO product_details (product, category, idcategory, brand, idbrand, price, quantity, status) VALUES
('Laptop XYZ', 'Electronics', 1, 'Dell', 1, 1200.00, 50, 'Available'),
('Running Shoes', 'Sports & Outdoors', 5, 'Nike', 1, 89.99, 100, 'Available'),
('Kitchen Blender', 'Home & Kitchen', 3, 'KitchenAid', 1, 199.50, 30, 'Available'),
('Smartphone ABC', 'Electronics', 1, 'Samsung', 4, 799.99, 80, 'Available'),
('Novel Mystery Island', 'Books', 4, 'Penguin', 1, 15.99, 120, 'Available'),
('T-shirt Red', 'Clothing', 2, 'Adidas', 2, 29.99, 200, 'Available'),
('Cat Food', 'Pet Supplies', 10, 'Whiskas', 1, 9.99, 300, 'Available'),
('Yoga Mat', 'Sports & Outdoors', 5, 'Puma', 10, 19.50, 150, 'Available'),
('Smart Watch', 'Electronics', 1, 'Apple', 3, 299.00, 70, 'Available'),
('Gaming Console', 'Toys & Games', 7, 'Sony', 5, 499.99, 90, 'Available');

INSERT INTO customer_details (customer, email, gender, birthdate, shipping_address) VALUES
('John Doe', 'johndoe@example.com', 'Male', '1990-05-15', '123 Main St, Cityville'),
('Jane Smith', 'janesmith@example.com', 'Female', '1985-10-22', '456 Elm St, Townsville'),
('Michael Johnson', 'michaeljohnson@example.com', 'Male', '1995-03-07', '789 Oak St, Villageton'),
('Emily Brown', 'emilybrown@example.com', 'Female', '1992-12-18', '101 Pine St, Hamletville'),
('William Garcia', 'williamgarcia@example.com', 'Male', '1988-07-30', '555 Cedar St, Burgville'),
('Sophia Martinez', 'sophiamartinez@example.com', 'Female', '1998-09-25', '777 Maple St, Villatown'),
('Daniel Wilson', 'danielwilson@example.com', 'Male', '1982-06-14', '888 Birch St, Oakville'),
('Olivia Lee', 'olivialee@example.com', 'Female', '1996-11-03', '999 Spruce St, Pineville'),
('Ethan Thompson', 'ethanthompson@example.com', 'Male', '1989-04-28', '222 Walnut St, Beachville'),
('Ava Hernandez', 'avahernandez@example.com', 'Female', '1993-08-12', '333 Cherry St, Riverside');

INSERT INTO order_details (idcustomer, customer, subtotal, pay, balance, mop, date, shipping_address) VALUES
(1, 'John Doe', 250, 'Paid', 20, 'Credit Card', '2023-12-15', '123 Main St, Cityville'),
(2, 'Jane Smith', 150, 'Paid', 30, 'PayPal', '2023-12-16', '456 Elm St, Townsville'),
(3, 'David Johnson', 500, 'Paid', 0, 'Cash On Delivery', '2023-12-17', '789 Oak St, Villageton'),
(4, 'Emily Williams', 350, 'Paid', 50, 'Credit Card', '2023-12-18', '101 Pine St, Hamletville'),
(5, 'Michael Brown', 200, 'Paid', 80, 'PayPal', '2023-12-19', '111 Cedar St, Countryside'),
(6, 'Olivia Miller', 450, 'Paid', 70, 'Credit Card', '2023-12-20', '222 Birch St, Hillside'),
(7, 'Sophia Wilson', 300, 'Paid', 50, 'PayPal', '2023-12-21', '333 Maple St, Lakeside'),
(8, 'William Garcia', 600, 'Paid', 20, 'Cash On Delivery', '2023-12-22', '444 Walnut St, Riverside'),
(9, 'Daniel Martinez', 420, 'Paid', 210, 'Credit Card', '2023-12-23', '555 Oak St, Mountainside'),
(10, 'Ava Hernandez', 280, 'Paid', 250, 'PayPal', '2023-12-24', '666 Pine St, Beachside');

-- Inserting order details for products
INSERT INTO orderdproducts (idorder, idproduct, product, brand, price, quantity, total) VALUES
(1, 1, 'Laptop XYZ', 'Dell', 1200.00, 2, 2400.00),
(2, 6, 'T-shirt Red', 'Adidas', 29.99, 3, 89.97),
(3, 8, 'Gaming Console', 'Sony', 499.99, 1, 499.99),
(4, 4, 'Smartphone ABC', 'Samsung', 799.99, 1, 799.99),
(5, 2, 'Running Shoes', 'Nike', 89.99, 2, 179.98),
(6, 9, 'Novel Mystery Island', 'Penguin', 15.99, 5, 79.95),
(7, 3, 'Kitchen Blender', 'KitchenAid', 199.50, 1, 199.50),
(8, 5, 'Yoga Mat', 'Puma', 19.50, 4, 78.00),
(9, 7, 'Cat Food', 'Whiskas', 9.99, 10, 99.90),
(10, 10, 'Smart Watch', 'Apple', 299.00, 1, 299.00);