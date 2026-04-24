# Digital Wallet System (Java + JDBC)

## About the Project

This is a simple console-based wallet system I built using Java and MySQL.
The main idea was to understand how transactions work in real systems.

Users can transfer money between accounts, and the system ensures that the transaction is either completed fully or rolled back if something fails.

---

## What I implemented

* Money transfer between users
* Balance checking before transfer
* Transaction success/failure tracking
* Rollback using JDBC transactions
* Database connection using JDBC

---

## Technologies used

* Java (Core Java concepts)
* JDBC
* MySQL

---

## How to run the project

1. Create a database named `walletdb`
2. Run the `database.sql` file
3. Update your MySQL username and password in `DBConnection.java`
4. Compile and run:

```
javac -d out src/dao/*.java src/service/*.java src/main/*.java src/model/*.java
java -cp "out;mysql-connector-j-8.0.33.jar" main.MainApp
```

---

## Sample output

```
1. Transfer Money
2. Exit
Enter choice: 1

Sender Name: akhil
Receiver Name: ravi
Amount: 500

Transaction Successful
```

---

## What I learned

* How JDBC works with MySQL
* How to handle transactions (commit & rollback)
* Importance of separating DAO and service layers
* Basic backend design structure

---

## Limitations

* No user interface (console only)
* No login system
* Input is case-sensitive

---

## Future improvements

* Add user authentication
* Show transaction history
* Convert into a web-based application using Spring Boot
