# 🌱 Farmer Management System

A Spring Boot project that manages **Farmers** and their related entities such as **Crops**, **Land**, and **Cattles**.  
This project demonstrates the use of **JPA Relationships** (One-to-One, One-to-Many, Many-to-One, Many-to-Many) to model real-world farming data.  

---

## 🚀 Tech Stack

- **Java 17+** (or your project version)  
- **Spring Boot**  
- **Spring Data JPA / Hibernate**  
- **SQL Database** (MySQL / PostgreSQL / H2 for dev)  
- **Maven** (build & dependency management)  
- **Postman** (API Testing)  

---

## 📌 Features

- Manage **Farmers** and their details.  
- Associate **Crops, Land, and Cattles** with Farmers.  
- Perform CRUD operations on all entities.  
- RESTful APIs with JSON responses.  
- Relational mapping using **JPA Annotations**.  

---

## 🏗️ Entity Relationships

- **Farmer**  
  - `@OneToMany` → Crops  
  - `@OneToMany` → Land  
  - `@OneToMany` → Cattles  

- **Crop**, **Land**, **Cattle**  
  - `@ManyToOne` → Farmer  

📌 Example: A single Farmer can have multiple Crops, multiple Land plots, and multiple Cattles.

---

