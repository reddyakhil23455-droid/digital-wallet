CREATE DATABASE walletdb;
USE walletdb;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

CREATE TABLE wallet (
    user_id INT PRIMARY KEY,
    balance DOUBLE
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    amount DOUBLE,
    status VARCHAR(20)
);