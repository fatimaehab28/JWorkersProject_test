# Camunda 8 Spring Boot Worker Project

This project demonstrates a simple order processing workflow using **Camunda 8** and **Spring Boot**. It includes automated workers for calculating discounts and handling shipping, triggered by message events.

## 🚀 Features
- **DiscountWorker**: Listens for `calculate-discount` tasks and applies a 10% discount.
- **ShippingWorker**: Listens for `ship-order` tasks.
- **Message Start Event**: The application automatically triggers the process by publishing a message (`Message_2c9etcg`) upon startup.

## 🛠 Prerequisites
- Java 21 
- Maven 3.8+
- A running Camunda 8 instance (SaaS or Self-Managed)
- Connection credentials (Client ID, Secret, etc.)

## ⚙️ Configuration
Update your `src/main/resources/application.properties` (or YAML) with your Camunda credentials:
```properties
camunda.client.mode=saas
camunda.client.cluster-id=your-cluster-id
camunda.client.auth.client-id=your-client-id
camunda.client.auth.client-secret=your-client-secret
camunda.client.region=your-region