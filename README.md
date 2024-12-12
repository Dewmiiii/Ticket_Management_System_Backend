# Project Name: Ticket Management System

Welcome to the Real-Time Ticket Management System repository! This project is a Real-Time Event Ticketing System designed to handle concurrent ticket releases and purchases using advanced producer-consumer implementation. The system is built using Spring Boot for the backend and React for the frontend.
- *CLI*: Command-Line Interface for managing and monitoring the system.
- *Frontend*: React application for user interaction.
- *Backend*: Spring Boot application for business logic and API endpoints.

## Features
- REST API for configuration and control of the ticketing system.
- CLI support for monitoring and debugging.
- React-based frontend for an intuitive user experience.

---

## Prerequisites
To get started, ensure you have the following installed on your system:

- *Git*: To clone the repository.
- *Node.js* and *npm*: For running the frontend.
- *Java 17+*: For running the backend.
- *Maven*: For building and running the Spring Boot application.

---

## Getting Started
Follow the steps below to clone and set up the repository:

### 1. Clone the Repository
```bash
$ git clone https://github.com/Dewmiiii/Ticket_Management_System_Backend.git
$ cd Ticket_Management_System_Backend
```

---

## Backend Setup and Execution
The backend is a Spring Boot application that handles the business logic and API endpoints.

### Steps to Run:
1. Navigate to the backendFinal folder:
   ```bash
   $ cd backendFinal
   ```
2. Build the application:
   ```bash
   $ mvn clean install
   ```
3. Run the Spring Boot application:
   ```bash
   $ mvn spring-boot:run
   ```
4. Verify the backend is running:
   - Open your browser and go to [http://localhost:8080](http://localhost:8080).

---

## Notes
- The backend API will be accessible at http://localhost:8080/api.
- Ensure the frontend and backend are running simultaneously for full functionality.
