# **Jobify: From Monolith to Microservices with Spring Boot, Docker, and Kubernetes**

## **Overview**

Jobify is a job management platform that started as a monolithic Spring Boot application and evolved into a robust microservices-based system. This transformation enabled better scalability, maintainability, and independent deployment using technologies like Docker, RabbitMQ, and Kubernetes.

---

## **1. Monolithic Architecture**

### **Initial Setup**

The monolithic application was built using Spring Boot. It managed jobs, company data, and user reviews within a single codebase, utilizing a layered structure of controllers, services, repositories, and entities.

### **Technologies Used**

* Spring Boot (core framework)
* Spring Data JPA (database operations)
* H2 (for development/testing)
* PostgreSQL (for production)
* Spring Boot Actuator (monitoring and health checks)
* Docker & Docker Compose (for containerization)

### **Functional Highlights**

* CRUD operations for job listings
* Company management
* User review submissions and retrieval

---

## **2. Containerizing the Monolith**

The monolithic application was containerized using Docker. A Dockerfile was created, and the application was packaged into an image. Docker Compose was introduced to manage PostgreSQL and the application together, streamlining local deployment and testing.

---

## **3. Migrating to Microservices**

### **Challenges with the Monolith**

* Difficult to scale specific components
* Slower development cycles
* Complex team collaboration

### **Microservices Identified**

* Company Service
* Job Service
* Review Service

Each service became an independent Spring Boot application, with its own database and infrastructure setup.

---

## **4. Inter-Service Communication**

### **REST APIs**

Each microservice exposed its functionality via RESTful endpoints.

### **OpenFeign Integration**

Initially, RestTemplate was used for HTTP calls. Later, OpenFeign was introduced for more efficient and declarative inter-service communication.

---

## **5. Asynchronous Messaging with RabbitMQ**

To decouple services and improve resilience, RabbitMQ was integrated for event-driven communication. This allowed services to send and receive messages asynchronously, reducing direct dependencies.

RabbitMQ was deployed as a Docker container and configured across microservices to handle events like job creation or review updates.

---

## **6. Dockerizing the Microservices**

Each microservice was prepared for containerization. Dockerfiles were written and Docker images were built using Spring Boot Maven plugins. Environment-specific configurations were managed using Spring profiles.

Docker Compose was used to orchestrate all services locally — including PostgreSQL, RabbitMQ, Zipkin, Eureka Service Registry, Config Server, API Gateway, and the microservices themselves.

---

## **7. Kubernetes Deployment**

### **Setting Up Kubernetes**

Minikube was used to run a local Kubernetes cluster. The Kubernetes dashboard provided a GUI for monitoring workloads.

### **Deployment Highlights**

* Each microservice was deployed as a Pod
* Kubernetes Services exposed internal and external access
* ReplicaSets ensured availability
* Deployments handled rollouts and rollbacks
* Horizontal scaling and autoscaling were enabled

### **Supporting Services in Kubernetes**

* PostgreSQL with persistent storage via StatefulSets
* RabbitMQ with a dedicated Deployment and Service
* Zipkin for distributed tracing, accessible externally

---

## **8. Monitoring, Debugging & Validation**

* Microservices registered with the Eureka Service Registry
* Zipkin was used for tracing request flows
* Spring Boot Actuator exposed health endpoints
* Kubernetes logs and dashboards helped monitor and debug issues
* PostgreSQL databases were validated with real application data


