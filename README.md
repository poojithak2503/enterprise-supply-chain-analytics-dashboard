# Enterprise Supply Chain Analytics Dashboard

## Overview

The Enterprise Supply Chain Analytics Dashboard is a Spring Boot-based logistics analytics platform that collects shipment information from multiple global logistics providers through REST APIs, transforms heterogeneous payloads into a standardized format, and stores them as BSON documents in MongoDB. The application performs real-time analytics, aggregation, and predictive forecasting while exposing REST APIs that power an interactive Angular dashboard with Chart.js visualizations.

The project demonstrates enterprise backend development using Spring Boot, Hibernate architecture, MongoDB, REST API integration, analytics processing, and dashboard reporting commonly used in logistics and supply chain management systems.

---

# Features

- Global Logistics Data Ingestion
- REST API Integration
- Shipment Tracking
- Multi-format Payload Transformation
- MongoDB BSON Document Storage
- Supply Chain Analytics
- Aggregation Queries
- Dashboard Metrics
- Shipment Cost Analysis
- Delay Prediction
- Forecasting Engine
- Chart.js Data Generation
- RESTful APIs
- Interactive Dashboard Support

---

# Technology Stack

| Technology | Version |
|------------|----------|
| Java | 11 |
| Spring Boot | 2.x |
| Hibernate | 5.x |
| MongoDB | Latest |
| Angular | 15+ |
| Chart.js | Latest |
| Maven | 3.x |

---

# Project Structure

```
enterprise-supply-chain-analytics-dashboard
│
├── controller
│     ShipmentController.java
│
├── model
│     Shipment.java
│
├── repository
│     MongoShipmentRepository.java
│
├── service
│     ShipmentService.java
│     LogisticsApiService.java
│     AnalyticsService.java
│     DashboardService.java
│     ForecastService.java
│     ChartDataService.java
│
└── SupplyChainAnalyticsApplication.java
```

---

# System Architecture

```
                 Global Logistics APIs

                          │

                          ▼

               LogisticsApiService

                          │

                          ▼

            Payload Transformation Engine

                          │

                          ▼

             MongoShipmentRepository

                          │

                          ▼

                 MongoDB (BSON)

                          │

          ┌───────────────┼────────────────┐
          │               │                │

          ▼               ▼                ▼

 AnalyticsService  DashboardService  ForecastService

          │               │                │

          └───────────────┼────────────────┘

                          ▼

                ChartDataService

                          │

                          ▼

               Angular Dashboard

                          │

                          ▼

                    Chart.js Charts
```

---

# Data Ingestion Workflow

```
External Logistics Provider

            │

            ▼

REST API Request

            │

            ▼

Receive Shipment Payload

            │

            ▼

Validate Payload

            │

            ▼

Transform Data

            │

            ▼

Convert to BSON Document

            │

            ▼

Store in MongoDB

            │

            ▼

Generate Analytics
```

---

# Analytics Workflow

```
Shipment Data

      │

      ▼

MongoDB Repository

      │

      ▼

Aggregation Queries

      │

      ▼

Analytics Service

      │

      ▼

Forecast Engine

      │

      ▼

Chart Data Service

      │

      ▼

Angular Dashboard
```

---

# Dashboard Metrics

The dashboard displays

- Total Shipments
- Delivered Shipments
- Delayed Shipments
- Shipments In Transit
- Total Shipment Cost
- Average Shipment Cost
- Shipment Weight
- Highest Cost Shipment
- Delivery Success Rate
- Predicted Shipment Risk

---

# Forecast Categories

```
Delay Percentage

0% - 10%

Low Risk

----------------------

10% - 25%

Medium Risk

----------------------

Above 25%

High Risk
```

---

# REST APIs

## Create Shipment

```
POST /api/shipments
```

Example Request

```json
{
    "shipmentId":1001,
    "trackingNumber":"TRK10001",
    "originCountry":"USA",
    "destinationCountry":"India",
    "carrier":"DHL",
    "shipmentStatus":"IN_TRANSIT",
    "transportationMode":"AIR",
    "quantity":120,
    "shipmentCost":4500,
    "shipmentWeight":250
}
```

---

## Get All Shipments

```
GET /api/shipments
```

---

## Get Shipment

```
GET /api/shipments/{shipmentId}
```

---

## Update Shipment Status

```
PUT /api/shipments/{shipmentId}/status
```

---

## Synchronize Global Logistics Data

```
POST /api/shipments/sync
```

---

## Analytics Report

```
GET /api/shipments/analytics
```

---

# Business Components

## ShipmentController

Exposes REST endpoints for shipment management, synchronization, analytics, and reporting.

---

## ShipmentService

Handles shipment creation, updates, delivery status management, and business logic.

---

## LogisticsApiService

Connects to external logistics REST APIs, retrieves shipment information, validates payloads, and converts data into internal shipment objects.

---

## MongoShipmentRepository

Stores shipment information as MongoDB BSON documents and provides repository operations.

---

## AnalyticsService

Executes aggregation operations to calculate shipment counts, costs, delivery statistics, and operational metrics.

---

## DashboardService

Generates dashboard summaries consumed by the Angular frontend.

---

## ForecastService

Predicts shipment delays and calculates delivery success rates based on historical shipment data.

---

## ChartDataService

Produces Chart.js-compatible datasets for shipment status, shipment cost, and dashboard visualizations.

---

# Sample Dashboard Summary

```
Enterprise Supply Chain Dashboard

-------------------------------------

Total Shipments : 520

Delivered : 410

In Transit : 82

Delayed : 28

Total Shipment Cost : $2,450,000

Average Shipment Cost : $4,711

Highest Shipment Cost : $18,750

Delivery Success Rate : 78.8%

Forecast Risk : LOW
```

---

# Sample Aggregation Output

```
Shipment Status

Delivered      : 410

In Transit     : 82

Delayed        : 28

---------------------------------

Shipment Cost

Total Cost     : $2,450,000

Average Cost   : $4,711

Maximum Cost   : $18,750
```

---

# Enterprise Concepts Demonstrated

- Spring Boot
- REST API Development
- Hibernate Layered Architecture
- MongoDB BSON Documents
- Repository Pattern
- REST API Integration
- Data Transformation
- Aggregation Queries
- Analytics Engine
- Dashboard Reporting
- Predictive Analytics
- Chart.js Integration
- Angular Backend Services
- Object-Oriented Programming

---

# Future Enhancements

- Spring Data MongoDB
- MongoDB Atlas
- Apache Kafka
- RabbitMQ
- Redis Caching
- Elasticsearch
- Kubernetes
- Docker Compose
- JWT Authentication
- Spring Security
- Swagger/OpenAPI
- Email Notifications
- SMS Notifications
- Machine Learning Delay Prediction
- Route Optimization
- Google Maps Integration
- Jenkins CI/CD
- SonarQube
- Prometheus Monitoring
- Grafana Dashboard

---

# Learning Outcomes

This project demonstrates practical implementation of

- Java Enterprise Development
- Spring Boot REST APIs
- Hibernate Architecture
- MongoDB Integration
- REST API Consumption
- BSON Document Processing
- Data Transformation
- Aggregation Queries
- Dashboard Analytics
- Predictive Forecasting
- Chart.js Backend Integration
- Enterprise Supply Chain Design

---

## Author

**Poojitha Kanuri**

Java Full Stack Developer

Email: poojithakanuri03@gmail.com

LinkedIn: https://linkedin.com/in/poojithakanuri

GitHub: https://github.com/poojithak2503
