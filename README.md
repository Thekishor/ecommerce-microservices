# Microservices Architecture with Spring Boot

## Project Description
This Ecommerce-Microservice project showcases a simple yet effective Spring Boot microservices architecture. It features Feign Client, WebClient, Centralized Config Management, Service Discovery, Input Validation, Distributed Tracing with Zipkin, Kafka Messaging, and an API Gateway for Routing and Load Balancing.

## Tech Stack
- Programming Language: Java
- Frameworks: Spring Boot
  - Spring Web
  - Spring Cloud (Eureka, Config Server, API Gateway)
  - Spring Validation
- Tools:
  - Feign Client and Web Client for inter-service communication
  - Eureka Server for service discovery
  - Spring Cloud Config Server for centralized configuration
  - Zipkin for distributing tracing 
  - Apache Kafka
- Build Tool: Maven
- Database: (MySQL/MongoDB/PostgreSQL)

## Features
1. Microservices:
   - customer-Service
   - product-service
   - order-service
   - payment-service
   - notification-service
2. Centralized Configuration Management:
   - Config Server to manage configuration centrally.
3. Service Discovery:
   - Eureka Server to register and discover microservices.
4. API Gateway:
   - Routes requests to appropriate microservices and provides load balancing.
5. Feign Client and Web Client:
   - Simplifies inter-service communication.
6. Input Validation:
   - Starter Validation for validating inputs.
7. Apache Kafka
   - Asynchronous communication
8. Zipkin and Postman
   - Distributing tracing and testing api

## Project Structure
├── api-gateway
├── config-server
├── customer-service
├── discovery-service
├── notification-service
├── order-service
├── payment-service
├── product-service

## How to Run
### Prerequisites
- JDK 21 
- Maven
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Postman or any API testing tool

### Access Points
- Eureka Dashboard: http://localhost:<eureka-port>
- API Gateway: http://localhost:<gateway-port>/<service-name>
- Zipkin: http://localhost:<zipkin-port>

## Future Enhancements
1. Dockerization:
   - Containerize the application using Docker and orchestrate with Docker Compose or Kubernetes.
2. Spring security with jwt token
3. OAuth2 

## Author
- Name: Kishor Pandey
- Contact: [kishorpandey2121@gmail.com]

