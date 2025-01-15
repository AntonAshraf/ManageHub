CREATE DATABASE shop ;
USE shop;

CREATE TABLE category_details (
    category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    description VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY(category_id)
);

CREATE TABLE brand_details(
    idbrand INT NOT NULL AUTO_INCREMENT,
    brand VARCHAR(50) NOT NULL,
    status varchar(50) NOT NULL,
    PRIMARY KEY(idbrand)
);

CREATE TABLE product_details (
    idproduct INT NOT NULL AUTO_INCREMENT,
    product VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    idcategory INT NOT NULL,
    brand VARCHAR(50) NOT NULL,
    idbrand INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY (idproduct)
    FOREIGN KEY (idcategory) REFERENCES category_details(category_id) ON DELETE CASCADE
    FOREIGN KEY (idbrand) REFERENCES brand_details(idbrand) ON DELETE CASCADE
);


CREATE TABLE customer_details (
    idcustomer INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    shipping_address VARCHAR(50) NOT NULL
);


CREATE TABLE order_details(
    idorder INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idcustomer INT NOT NULL,
    customer VARCHAR(50) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL, 
    pay VARCHAR(50) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    mop VARCHAR(50) NOT NULL,
    date DATE NOT NULL,
    shipping_address VARCHAR(50) NOT NULL
    FOREIGN KEY (idcustomer) REFERENCES customer_details(idcustomer) ON DELETE CASCADE
);


CREATE TABLE orderdproducts (
    idorderdproducts INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idorder INT NOT NULL,
    idproduct INT NOT NULL,
    product VARCHAR(50) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    total DECIMAL(10, 2) NOT NULL
    PRIMARY KEY (idorderdproducts, idorder, idproduct) 
    FOREIGN KEY (idorder) REFERENCES order_details(idorder) ON DELETE CASCADE
    FOREIGN KEY (idproduct) REFERENCES product_details(idproduct) ON DELETE CASCADE
);
