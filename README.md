# FarmerMGMT App

**FarmerMGMT** is a Spring Boot-based application designed to manage farmers, their crops, and livestock. This project provides a simple, intuitive REST API for CRUD operations on farmers, crops, and cattle data.

---

## Features

* **Farmer Management**

  * Add, update, view, and delete farmer records.
  * Manage personal details like name, contact, gender, and address.

* **Crop Management**

  * Add, update, and view crops for a farmer.
  * Track crop type and quantity.

* **Cattle Management**

  * Add, update, and view livestock (cows, buffaloes, goats, sheep) for a farmer.

* **Database Integration**

  * Uses Spring Data JPA with MySQL (configurable) for persistence.
  * Automatic creation of tables with relationships:

    * One-to-many (Farmer → Crops)
    * One-to-one (Farmer → Cattle)

* **RESTful API Endpoints**

  * `/farmers` → Manage farmers
  * `/crops` → Manage crops
  * `/cattle` → Manage livestock

---

## Tech Stack

* **Backend:** Java, Spring Boot
* **Database:** MySQL
* **ORM:** Hibernate / JPA
* **Build Tool:** Maven
* **JSON Handling:** Jackson






