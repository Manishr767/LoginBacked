SajiloYatra: Your All-in-One Nepal Travel Companion (https://sajiloyatra-frontend.vercel.app)

SajiloYatra is a web application that replaces the chaos of Nepal travel planning with a single, trusted platform for discovering, booking, and experiencing the real Nepal.

This repository contains the source code for the YetiGo project, built for [Your Class Name].

Tech Stack

Frontend: Next.js (React)

Backend: Java Spring Boot

Database: MySQL

How to Run Locally

To get a local copy up and running, follow these simple steps.

Prerequisites:

Java 21+ & Maven

Node.js 18+ & npm

A running MySQL server

1. Clone the repository:

git clone [https://github.com/](https://github.com/)[YourUsername]/[YourRepoName].git
cd [YourRepoName]


2. Set up the Database:

Log in to your MySQL server.

Create the database: CREATE DATABASE yetigo_db;

(Optional) Run the schema file at backend/schema.sql to create the tables.

3. Configure the Backend (Java Spring Boot):

Navigate to the backend directory.

In src/main/resources/application.properties, update the spring.datasource.url, spring.datasource.username, and spring.datasource.password to match your local MySQL setup.

Run the backend server:

mvn spring-boot:run


The API will be running at http://localhost:8080.

4. Configure the Frontend (Next.js):

Navigate to the frontend directory.

Create a .env.local file. Copy the contents of .env.example and fill in any necessary variables.

Install dependencies:

npm install


Run the development server:

npm run dev


Open http://localhost:3000 with your browser to see the app.
