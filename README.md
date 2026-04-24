# 🚀 Digital Wallet System (Java + JDBC)

> A console-based wallet system that demonstrates **real-world transaction handling using JDBC (commit & rollback)**.

---

## ✨ Features

* 💸 Transfer money between users
* 🔍 Balance validation before transaction
* 🔁 Automatic rollback on failure
* 📊 Transaction logging (SUCCESS / FAILED)
* 👤 Transfer using user names (instead of IDs)

---

## 🧱 Tech Stack

* Java (Core Java + OOP)
* JDBC (Java Database Connectivity)
* MySQL

---

## 📁 Project Structure

```
wallet-system/
 ├── src/
 │    ├── dao/
 │    ├── service/
 │    ├── main/
 │    ├── model/
 ├── database.sql
 ├── images/
 ├── README.md
```

---

## ⚙️ Setup & Run

### 1. Create Database

```sql
CREATE DATABASE walletdb;
```

Run the `database.sql` file.

---

### 2. Configure Database

Update credentials in `DBConnection.java`:

```java
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

### 3. Compile & Run

```bash
javac -d out src/dao/*.java src/service/*.java src/main/*.java src/model/*.java
java -cp "out;mysql-connector-j-8.0.33.jar" main.MainApp
```

---

## 📸 Sample Outputs

---

### ✅ Successful Transaction

```
Transaction Successful
```

![Success](images/success.png)

---

### ❌ Insufficient Balance

```
Insufficient balance
Transaction Failed
```

![Insufficient](images/Insufficient.png)

---

### ⚠️ Invalid User Name

```
Invalid user name
```

![Invalid](images/Invalid.png)

---

### 🔁 Same Sender & Receiver

```
Sender and receiver cannot be the same
```

![Same](images/same.png)

---

### ⚠️ Database Error (MySQL not running)

```
No suitable driver found for jdbc:mysql://localhost:3306/walletdb
```

---

## 🗄️ Database Design

### users

* user_id (Primary Key)
* name (Unique)
* phone

### wallet

* user_id (Primary Key)
* balance

### transactions

* id (Primary Key)
* sender_id
* receiver_id
* amount
* status
* timestamp

---

## 🧠 What This Project Demonstrates

* Safe transaction handling using commit & rollback
* Separation of concerns (DAO vs Service layer)
* Reliable database interaction using JDBC

---

## ⚠️ Limitations

* Console-based application
* No authentication system
* Case-sensitive input

---

## 🔮 Future Improvements

* Add authentication system
* View transaction history
* Convert to REST API (Spring Boot)
* Build web interface

---

## 👤 Author

**Akhil Reddy**
