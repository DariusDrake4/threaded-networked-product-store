# Threaded Networked Product Store (Java)

A multi-client, threaded inventory management application developed in Java for CST-239 (Java II) at Grand Canyon University.

## Overview
This project extends a single-client product store into a concurrent, multi-client system. The server uses a thread-per-connection model to allow multiple clients to interact with a shared in-memory inventory at the same time.

## Key Features
- Multi-client client/server architecture using Java sockets
- Thread-per-client server design
- Shared inventory state across all connected clients
- Thread safety using synchronization
- Dependency Injection (IMessageProcessor) for testability
- Unit testing with JUnit
- Executable JAR-based deployment

## Technologies Used
- Java
- Multithreading
- Socket Programming
- Maven
- JUnit
- Dependency Injection

## What I Learned
- How to design and implement thread-safe Java applications
- Managing shared state across concurrent client connections
- Applying Dependency Injection to improve testability
- Debugging race conditions in a multi-threaded environment
- Building and running Java applications from JAR files

## How to Run
1. Build the project using Maven
2. Start the server from the server JAR
3. Launch one or more clients from the client JAR
4. Perform inventory operations from multiple clients simultaneously

## Notes
This project was completed as a final milestone and received a score of **100%**.
