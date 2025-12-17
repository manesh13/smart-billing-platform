# Smart Billing Platform

A modular Spring Boot 4 backend built with Java 21 to explore modern backend architecture, event-driven design, and production-grade practices.

This project is intentionally designed as a **modular monolith using vertical slice architecture**. It focuses on clarity, boundaries, and real-world decision making rather than over-engineering.

---

## Why this project exists

Most sample Spring Boot projects stop at CRUD. This one goes further.

The goal is to:

* Use **Spring Boot 4** features in realistic scenarios
* Apply **modern Java (21+)** language features intentionally
* Practice **clean architecture and modular design**
* Build something that scales in complexity without becoming messy
* Create a portfolio project that reflects real backend work

---

## High-level architecture

* **Modular monolith**
* **Vertical slice per domain**
* **Single runnable application**
* **Clear dependency boundaries**
* **Event-driven communication between modules**

No premature microservices. The design allows extraction later if needed.

---

## Module structure

```
smart-billing-platform
│
├── common            → Shared configuration and cross-cutting concerns
├── user              → User management
├── subscription      → Plans and subscriptions
├── usage             → Usage ingestion and tracking
├── billing           → Invoice generation and billing logic
└── notification      → Alerts and notifications
```

Each domain module follows the same internal structure:

```
api            → REST controllers & request/response models
application    → Use cases and orchestration logic
domain         → Pure Java domain model
infrastructure → Persistence & external integrations
events         → Domain events
```

---

## Technology stack

* **Java**: 21 (Java 25 ready)
* **Spring Boot**: 4.x
* **Build tool**: Maven (multi-module)
* **Database**: PostgreSQL
* **Security**: JWT-based authentication
* **Observability**: Spring Boot Actuator + Micrometer
* **Deployment**: Railway (free tier)

---

## Java 21 features used

* Records for immutable data structures
* Sealed interfaces for domain rules
* Pattern matching in business logic
* Virtual threads for high-throughput APIs
* Structured concurrency for parallel workflows

These are used where they make sense, not just for demonstration.

---

## Architectural principles

* Domain logic stays free of Spring annotations
* Spring is kept at the edges
* Modules do not depend on each other directly
* Communication happens via events or shared interfaces
* Each module can be extracted into a microservice later

---

## Running the project locally

### Prerequisites

* Java 21
* Maven 3.9+
* PostgreSQL (or Docker)

### Start the application

```
mvn clean install
mvn spring-boot:run -pl app
```

### Health check

```
GET /manage/health
```

---

## Deployment

The application is designed to be deployed as a single service.

* Environment-based configuration
* Externalized secrets
* Public health endpoint
* Free hosting via Railway and Neon (Postgres)

---

## Roadmap

* User management
* Subscription plans
* Usage ingestion with async processing
* Event-driven billing engine
* Invoice generation
* Notifications and alerts
* Observability dashboards
* Optional native image build

---

## Why modular monolith?

Microservices add operational cost early.
This project focuses on **clarity first**, not infrastructure complexity.

The architecture allows:

* Independent development per domain
* Clear ownership
* Easier testing
* Straightforward future decomposition

---

## Author

**Manesh Borkar**

Software Engineer focused on backend systems, clean architecture, and modern Java.

---

