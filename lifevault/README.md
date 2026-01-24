# LifeVault – Secure Digital Legacy Management System

LifeVault is a backend-driven system designed to securely manage and release sensitive digital assets (documents, files, information) based on well-defined triggers such as **owner inactivity**, **scheduled dates**, or **death verification workflows**.
The project focuses on **clean architecture, real-world business logic, and automation**, not just CRUD operations.

---

## 🚀 Project Vision

> *To ensure that a person’s important digital assets are safely released to trusted nominees under controlled and verifiable conditions.*

LifeVault is built with **security, traceability, and automation** in mind.

---

## 🧱 Architecture Overview

The project follows a **layered architecture**:

```
Controller → Service → Repository → Database
```

Key design principles:

* Business logic strictly inside **Service layer**
* Controllers remain thin (request/response only)
* Entities never exposed directly (DTO-based responses)
* Automated system actions via **Schedulers (Cron jobs)**

---

## 🛠 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **Spring Scheduler (Cron Jobs)**
* **MySQL**
* **Maven**

---

## 📦 Core Modules Implemented

### 1️⃣ User & Role Model

* Unified `User` entity (Owner / Nominee / Admin via role)
* Owner lifecycle managed through last login tracking

---

### 2️⃣ Vault Management

* Folder-based vault structure
* Each owner can create multiple vault folders
* Each folder has a release state (`isReleased`)

**APIs implemented:**

* Create vault folder
* Fetch owner-specific folders

---

### 3️⃣ Nominee Management

* Nominee creation with clean DTO-based APIs
* Owner–Nominee relationship handled via a mapping entity
* Supports real-life relationships (Brother, Sister, etc.)

**APIs implemented:**

* Create nominee
* Assign nominee to owner
* Fetch nominees linked to an owner

---

### 4️⃣ Owner Dashboard (Aggregation API)

A single API that provides:

* Owner’s vault folders
* Linked nominees with relationships

This avoids multiple frontend calls and reflects real dashboard behavior.

---

## ⚙️ Automated Vault Release (Core USP)

### 🔑 Inactivity-Based Release Trigger

* Each owner can have a release rule based on inactivity duration
* Rule stored in `release_triggers` table
* Condition:

  ```
  last_login_at + inactivity_months < current_time
  ```

### ⏱ Scheduler (Cron Job)

* Background job runs automatically at scheduled intervals
* No manual API trigger required
* Fully automated system behavior

**Result:**

* All unreleased folders of an inactive owner are automatically released

---

## 🧾 Audit Log Integration (Security & Traceability)

* Every system-triggered release action is logged automatically
* Audit logs store:

  * Target user (owner)
  * Action performed
  * Timestamp

Example log:

> *System released vault due to owner inactivity*

This ensures:

* Transparency
* Security compliance
* Easy debugging & auditing

---

## 🧪 Database Design Highlights

Core tables:

* `users`
* `vault_folders`
* `vault_items`
* `nominees`
* `owner_nominees`
* `release_triggers`
* `audit_logs`
* `death_verification_requests`
* `approvals`

Foreign key relationships are carefully ordered and validated using Hibernate.

---

## 🧠 Design Decisions Worth Noting

* **No Lombok** – full control and clarity over code
* **DTO Layer** – prevents entity exposure & sensitive data leaks
* **Entity-managed timestamps** – avoids accidental overwrites
* **Release logic centralized** – reusable across multiple trigger types

---

## 🔮 Planned Enhancements

* Date-based release trigger
* Death verification workflow with admin approval
* Nominee read-only access for released vaults
* Email notifications (optional)
* JWT-based authentication & authorization
* Frontend integration (React – already partially built)

---

## 📌 Current Status

✅ Core backend completed
✅ Automation & scheduler working
✅ Audit logging integrated
🚧 Frontend & advanced workflows in progress

---

## 👨‍💻 Author

**Krishnkant Malviya**
Java Backend Developer | Spring Boot | System Design Learner

---

> *This project focuses on real-world backend engineering concepts such as automation, traceability, and clean architecture rather than simple CRUD operations.*
