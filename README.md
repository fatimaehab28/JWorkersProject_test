# 🛒 Camunda 8 Order Processing System

This project is a **Spring Boot application** integrated with **Camunda 8 (Self-Managed)** to automate an order processing workflow.

The system demonstrates:

- Message-driven process start
- Service task workers
- Variable handling between workflow and Java
- Spring Boot + Camunda 8 integration

---

## 🚀 Features

### 📩 Message-Triggered Start
On application startup, a message named:


is automatically published to Zeebe to start the workflow.

### 💰 Automated Discount Calculation
The `DiscountWorker`:

- Listens to job type: `calculate-discount`
- Reads the `price` process variable
- Calculates a 10% discount
- Returns a new variable: `discount`

### 🚚 Shipping Handler
The `ShippingWorker`:

- Listens to job type: `ship-order`
- Logs shipping confirmation
- Completes the workflow

### 🌱 Spring Boot Integration
The project uses:


Workers are automatically registered using `@JobWorker`.

---

## 🛠 Prerequisites

Before running this project, ensure you have:

- ✅ **Java 21**
- ✅ **Maven 3.8+**
- ✅ **Docker**
- ✅ **Camunda 8 Self-Managed running locally**

---

## ⚙️ Configuration

The application is configured for **Self-Managed Camunda 8**.

Update:


```properties
camunda.client.mode=self-managed

camunda.client.auth.client-id=orchestration
camunda.client.auth.client-secret=secret

# Uncomment and adjust if ports differ
# camunda.client.zeebe.grpc-address=http://localhost:26500
# camunda.client.zeebe.rest-address=http://localhost:8088
