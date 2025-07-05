## Table of Contents

- [Introduction](#introduction)  
- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Folder Structure](#folder-structure)  
- [Getting Started](#getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Installation](#installation)  
  - [Running the Application](#running-the-application)  
- [Design Patterns & Principles](#design-patterns--principles)  
- [Video](#video)  
- [Contact](#contact)  

---

## Introduction

A clean Java console-based e-commerce system that supports expirable and shippable products, shopping cart functionality, checkout with shipping and balance handling — built for the **Fawry Quantum Internship Challenge**.

---

## Features

- Add products to the system (including expirable & shippable products)
- Add items to a cart with quantity validation
- Prevent expired or out-of-stock products from being purchased
- Calculate subtotal, shipping fees, and total
- Deduct from customer balance
- Output shipping notice for physical items

---

## Tech Stack

- **Language**: Java 17+
- **Paradigm**: Object-Oriented Programming (OOP)
- **Principles**: SOLID, Clean Code
- **Design Patterns**: Strategy, Dependency Injection, Interface Segregation

---

## Folder Structure

```plaintext
├── bin
├── lib
├── src/                  # Source code
│   ├── cart/             # Cart components
│   ├── checkout/         # checkout components
│   ├── customer/         # Customer components
│   ├── product/          # product components
│   ├── shipping/         # shipping components
│   ├── App.java/         # Main File
├── .gitignore            # Files to ignore in Git
├── README.md             # Documentation
```

## Getting Started

### Prerequisites

- **Java JDK**: Version `v17.0` or higher.  
- **A Java-compatible IDE** (e.g., IntelliJ IDEA, VS Code)

### Installation

```bash
# Clone the repository
git clone <repository-url>

```
### Running the Application

#### Using Terminal
```bash
# Build and Run the project
javac src/**/*.java
java src/Main
```
#### Using IDE
- Open the project
- Right-click Main.java → Run

## Design Patterns & Principles

### SOLID Principles:
  - SRP: Each class has a single responsibility
  - OCP: Product types are extendable via subclasses
  - LSP: Subtypes can replace Product without issue
  - ISP: IShippableItem is a focused interface
  - DIP: CheckoutService depends on abstractions

### Design Patterns:
  - Strategy-style ShippingService
  - Dependency Injection via constructors
  - Interface-based contracts (IShippableItem)
  
## Video

https://github.com/user-attachments/assets/ebb07085-d6fa-4ef3-8d02-21964e35c5f0

## Contact

Email: mohamedhamdydeveloper55@gmail.com
