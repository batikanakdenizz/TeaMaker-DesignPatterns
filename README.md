# ☕ TeaMaker – Advanced Design Patterns Project 

TeaMaker is a **state-driven tea machine simulation** developed in **Java**, designed to demonstrate the **practical and combined use of software design patterns** in a realistic system.

The project focuses on **behavioral correctness**, **clean separation of concerns**, and **extensibility**, rather than simple UI interactions.  
While **MVC (Model–View–Controller)** is used as a **supporting architectural pattern**, the **core emphasis** of the project is on **behavioral and structural design patterns**, especially the **State Pattern**.

---

## 🚀 Project Overview

TeaMaker simulates the lifecycle of a real tea machine, including:

- State-based behavior transitions  
- Reactive UI updates  
- Health-aware user notifications  
- Persistent usage logging via a database  

The system is intentionally designed to avoid complex conditional logic and instead relies on **well-defined object collaboration**.

---

## ⚡ Key Concepts at a Glance

- **State Pattern** for machine lifecycle control  
- **Observer Pattern** for reactive UI updates  
- **Decorator Pattern** for dynamic message enrichment  
- **Repository Pattern** for persistence abstraction  
- **MVC Architecture** for clean separation of responsibilities  

---

## 🎯 Architectural Motivation

This project was built with the goal of modeling **real-world machine behavior** as accurately and cleanly as possible.

### Why State-Driven Design?

- Avoids `if-else` or `switch`-based logic explosions  
- Each machine state owns its behavior  
- New states can be added with minimal changes  

### Why Observer?

- Keeps UI synchronized without tight coupling  
- Eliminates direct UI manipulation from business logic  

### Why Decorator?

- Enables runtime enhancement of messages  
- Avoids subclass explosion for optional features  

### Why MVC (Supporting Role)?

- Keeps UI, control flow, and business logic independent  
- Improves readability and long-term maintainability  

> **Important:**  
> MVC provides the *structural backbone*, but **system behavior is governed by design patterns**, not controllers.

---

## 🧠 Machine Lifecycle (State Pattern)

The tea machine follows a strict lifecycle:
 ```
Empty → Idle → Boiling → Brewing → Done
 ```


Each state:

- Defines which actions are allowed  
- Controls valid transitions  
- Encapsulates its own behavior  

This ensures the system **cannot enter an invalid state**.

---

## 🔔 Health Monitoring (Decorator Pattern)

The system monitors daily tea consumption:

- Daily limit: **10 cups**
- When exceeded:
  - The message output is dynamically wrapped
  - A health warning is appended **without modifying core logic**

This is achieved via the **Decorator Pattern**, keeping the system open for extension and closed for modification.

---

## 💾 Data Persistence (Repository Pattern)

Every brewing operation is logged into a **MySQL database**.

### Why Repository?

- Decouples SQL logic from business logic  
- Makes the data layer replaceable  
- Improves testability and readability  

All database interactions are handled through:

`TeaLogRepository`


---

## 🧩 MVC Architecture Breakdown

### 🟦 Model
**TeaMakerMachine**

- Holds current state  
- Manages transitions  
- Triggers notifications  

### 🟩 View
**TeaMaker.java**

- Java Swing–based UI  
- Observes system changes  
- Displays messages and machine status  

### 🟥 Controller
**TeaMakerController.java**

- Handles user input  
- Invokes machine actions  
- Coordinates Model and View  

> MVC is intentionally **lightweight** and does not contain business rules.

---

## 🧱 Design Patterns Used

| Pattern | Location | Purpose |
|------|--------|--------|
| **State** | `State`, `EmptyState`, `BoilingWaterState`, `TeaState`, etc. | Encapsulates machine behavior and transitions |
| **Observer** | `Subject`, `Observer` | Keeps UI reactive and loosely coupled |
| **Decorator** | `HealthWarningDecorator`, `BaseMessage` | Dynamically enhances system messages |
| **Repository** | `TeaLogRepository` | Abstracts persistence operations |
| **MVC** | Model / View / Controller classes | Structural separation of concerns |

---

## 🛠️ Technical Stack

- **Language:** Java (JDK 8+)  
- **GUI:** Java Swing  
- **Database:** MySQL 8.0  
- **Driver:** MySQL Connector/J  
- **Build Tool:** Apache Ant  
- **IDE:** NetBeans / IntelliJ IDEA  

---

## 📂 Database Setup

1. Create the database:
   ```sql
   CREATE DATABASE teaMakerDB;
    ```
2. Run the provided SQL script:
 ```
teaMakerDB.sql
 ```
3. Set the database credentials as environment variables. They are read at startup, so no
   password is stored in the source:
 ```bash
 export TEAMAKER_DB_USER=root
 export TEAMAKER_DB_PASSWORD=your_password
 # optional; defaults to jdbc:mysql://localhost:3306/teaMakerDB
 export TEAMAKER_DB_URL="jdbc:mysql://localhost:3306/teaMakerDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Istanbul"
 ```
 On Windows PowerShell:
 ```powershell
 $env:TEAMAKER_DB_USER = "root"
 $env:TEAMAKER_DB_PASSWORD = "your_password"
 ```

---

## ⚙️ How the System Works

### 🔹 Initialization
- The machine starts in **`EmptyState`**

### 🔹 User Flow
1. **Fill water** → transitions to `IdleState`
2. **Boil** → transitions to `BoilingWaterState` (Timer starts)
3. **Brew** → transitions to `TeaState`
4. **Pour** → transitions to `DoneState`
5. **Log usage** → persisted via `TeaLogRepository`

### 🔹 Smart Notifications
Before displaying any message:
- Daily tea consumption is checked
- If the limit is exceeded:
  - The message is wrapped by `HealthWarningDecorator`
  - A health warning is dynamically appended

---

## 🚫 Non-Goals

This project intentionally does **not** aim to:
- Control a real IoT tea machine
- Provide production-level concurrency or scalability
- Act as a full beverage management system

The focus is strictly on:
> **Architecture, design patterns, and clean object-oriented design**

---

## 🔮 Future Improvements

- **Dependency Injection**  
  Introduce Spring or Guice

- **Unit Testing**  
  Add JUnit tests for State transitions

- **Docker Support**  
  Containerize the MySQL environment

- **Logging Framework**  
  Replace `System.out` with Log4j or SLF4J

---

## 📌 Final Notes

This project is intentionally designed to go **beyond textbook examples** by combining multiple design patterns into a **cohesive, realistic system**.

It demonstrates how **state-driven design**, supported by MVC, results in a system that is:
- Easy to reason about
- Easy to extend
- Easy to maintain

---

**Authors:** Batıkan Akdeniz, Zeynep Yıldız

**Focus:** Clean Architecture · Design Patterns · Object-Oriented Design
