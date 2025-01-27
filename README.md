# Distributed Rental Service System

This is a **simple Distributed System project** for a **Rental Service**, built with **Gradle** and **JDK 17**. The application is designed to manage a list of cars and their rental statuses, offering basic operations via HTTP requests. The project has been containerized with **Docker** to enable easy deployment, with future plans to deploy it using **Kubernetes** and integrate a database for persistent storage.


---

## Table of Contents
- [Distributed Rental Service System](#distributed-rental-service-system)
  - [Table of Contents](#table-of-contents)
  - [Project Overview](#project-overview)
  - [Technologies Used](#technologies-used)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
  - [Project Setup](#project-setup)
  - [Available API Endpoints](#available-api-endpoints)
  - [GitHub Actions Workflow for CI/CD](#github-actions-workflow-for-cicd)
  - [Docker Integration](#docker-integration)
  - [Build and Push Docker Image](#build-and-push-docker-image)
  - [Kubernetes Deployment](#kubernetes-deployment)


---


## Project Overview

This project provides a basic backend for managing a list of cars and their rental statuses. It supports the following functionalities:
- View all cars and their rental statuses.
- View details of a specific car using its plate number.
- Add new cars to the system.
- Update the rental status of a car.

The application responds with JSON data and currently does not include a graphical user interface. Future enhancements will include containerization, orchestration, and persistent storage.

---

## Technologies Used
- **Language:** Java (JDK 17).
- **Build Tool:** Gradle.
- **CI/CD:** GitHub Actions.
- **Containerization:** Docker.
- **Orchestration:** Kubernetes.

---

## Getting Started

Follow the steps below to set up and run the project locally:

### Prerequisites
1. **Java Development Kit (JDK 17)**  
   
   Ensure JDK 17 is installed:
   ```bash
   java --version
   ```

   Expected Output:

    ```bash
   openjdk 17.0.x 
   ```

2. **Gradle**
   
    Install Gradle using your package manager or download it from Gradle.org.

    To verify Gradle installation, run:

    ```bash
    gradle --version
    ```

    Expected Output:

    ```bash
   Gradle X.X
   ```

3. **Docker**
   
    Ensure Docker is installed and running on your system.

    To verify Docker installation, run:

    ```bash
    docker --version
    ```

    Expected Output:

    ```bash
   Docker version XX.XX.X, build XXXXXXX
   ```

    Check if Docker is running:

    ```bash
   docker info
   ```

   If Docker is running, the output should include details such as Containers, Images, and Server Version.

4. **Kubernetes** 
   
    Install Minikube and configure it for your local Kubernetes cluster.

    To verify minikube installation, run:

    ```bash
    minikube version
    ```

    Expected Output:

    ```bash
    minikube version: vX.X.X
    ```

    Start a local Kubernetes cluster:

    ```bash
    minikube start
    ```

    If successful, the output will show details about the cluster, including Kubernetes version and status.

## Project Setup

1. **Clone the Repository**
   
```bash
git clone git@github.com:AbdelheqMokhtari/Distrubuted_Programming.git
cd Distrubuted_Programming
```

2. **Build the Project Run the following Gradle command to build the project:**
   
```bash
./gradlew build
```

## Available API Endpoints
The following endpoints are available:

1. **Get a List of All Cars:**
   
    **URL:** GET /cars

    **Description:** Returns a JSON list of all cars with their rental statuses.

    **Example URL:** localhost:8080/cars.

    **Example Response:**
    ```json
    [
        {  
        "plateNumber": "123ABC", "model": "Toyota Camry", "rented": false 
        },

        { 
        "plateNumber": "456DEF", "model": "Honda Accord", "rented": true
        }
    ]
    ```
2. **Get Details of a Specific Car by Plate Number:**

    **URL:** GET /cars/{plateNumber}

    **Description:** Returns details of a car with the specified plate number.

    **Example URL:** localhost:8080/cars/123ABC

    **Example Response:**

    ```json
    {
        "plateNumber": "123ABC", "model": "Toyota Camry", "rented": false 
    }
    ```

3. **Update Rental Status of a Car:**
   
    **URL:** PUT /cars/{plateNumber}?rent={true/false}

    **Description:** Updates the rental status of a car.

    **Example URL:** localhost:8080/cars/123ABC?rent=true

    
4. **Add a New Car:**
   
    **URL:** POST /cars

    **Description:** Adds a new car to the system.

    **Example Request Body:**

    ```json
    {   
        "plateNumber": "789GHI",
        "model": "Ford Focus",
        "rented": false
    }
    ```

## GitHub Actions Workflow for CI/CD

This project uses **GitHub Actions** to automate the build and test process whenever a pull request is made. The workflow ensures the code is checked out, JDK 17 is set up, the Gradle wrapper is granted execution permissions, and the project is built and tested successfully. You can find the workflow file at [.github/workflows/action.yml](./.github/workflows/action.yml) for more details.


## Docker Integration

This project includes a **Dockerfile** to containerize the application for easy deployment. The Dockerfile is located in the `RentelService` directory. You can view and modify it as needed by checking [RentelService/Dockerfile](./RentelService/Dockerfile).


## Build and Push Docker Image

1. Build the Docker Image:
   
```
docker build -t rentalservice .      
```

2. Run the Container:

```
docker run -p 4000:8080 rentalservice.          
```

3. Then check in your browser:

```
http://localhost:4000/cars          
```

4. Tag the image : 
   
```
docker tag 4da2332370c7 AbdelheqMokhtari/rental-service:1.0      
```

5. Log in Dockerhub:

```
docker login.
```

6. push the image:

```
docker push your-dockerhub-username/rental-service:latest    
```
The Docker image is available on my DockerHub: [https://hub.docker.com/u/abdelheq](https://hub.docker.com/u/abdelheq).

## Kubernetes Deployment
