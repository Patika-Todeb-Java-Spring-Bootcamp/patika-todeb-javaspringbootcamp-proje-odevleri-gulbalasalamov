# Project: Second-hand shopping app

This repository is dedicated to demonstrate weekly progress of project implementation in bootcamp.

For weekly theorytical homework, please see: 
https://github.com/Patika-Todeb-Java-Spring-Bootcamp/patika-todeb-javaspringbootcamp-teorik-odevler-gulbalasalamov

---

#### Project Brief

---

The purpose of this project is to build a potential backend system for second-hand goods exchange app.

The project aims to:

- leverage spring security with secure endpoints,
- register users with roles,
- implement CRUD operations in database,
- send/receive data using REST API

This project omplementats Spring Boot framework with given dependencies:

- Lombok --> Java annotation library which helps to reduce boilerplate code.
- Spring Web --> Builds web, including RESTful, applications using Spring MVC
- Spring Security --> Highly customizable authentication and access-control framework for Spring applications.
- Spring Data JPA --> Persists data in SQL stores with Java Persistence API using Spring Data and Hibernate
- PostgreSQL Driver --> JDBC & R2DBC driver allowing Java programs to connect to PostgreSQL database using standart Java code

---

#### Functional Requirements

---

| **USER STORY ID** | **AS A** | **I WANT TO**                        | **SO THAT**                                                                                                                                 |
|-------------------|----------|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| 1                 | buyer    | sort and browse item(s)              | I can see available items of my choice from different sellers                                                                               |
| 2                 | buyer    | add/update/delete cart               | I can see the number of items in the card and the total cost                                                                                | 
| 3                 | buyer    | ask question(s)                      | I can chat with seller to get information about items and negotiate the price                                                               | 
| 4                 | buyer    | request order                        | I can buy the item within 48 hours                                                                                                          | 
| 5                 | buyer    | register to system                   | I can create a buyer account                                                                                                                | 
| 6                 | buyer    | login & logout                       | I can use the system                                                                                                                        | 
| 7                 | buyer    | communicate admin                    | I can report an issue about seller, or respond admin                                                                                        | 
| 8                 | seller   | add/update/delete item               | I can advertise my items and let buyers know the availability of stocks                                                                     |  
| 9                 | seller   | answer question(s)                   | I can chat with buyer to provide information about items and negotiate the price                                                            |     
| 10                | seller   | view number of order requests        | I can choose among them                                                                                                                     |
| 10                | seller   | confirm order                        | I can accept order and notify other interested buyers that the item is sold out. This will automatically reject all pending order requests. |
| 11                | seller   | register to system                   | I can create a seller account                                                                                                               |
| 12                | seller   | login & logout                       | I can use the system                                                                                                                        |
| 13                | seller   | communicate admin                    | I can report an issue about buyer or respond admin                                                                                          |
| 14                | admin    | register to system                   | I can create an admin account                                                                                                               |
| 15                | admin    | login & logout                       | I can use the system                                                                                                                        |
| 16                | admin    | communicate                          | I can track and handle reported issues from seller and buyers                                                                               | 
| 17                | admin    | add/update/delete categories         | I can manage the correctness of data associated with the items                                                                              |  
| 18                | admin    | activate/deactivate seller and buyer | I can prevent some users from doing operations                                                                                              | 


---

#### Use-Case Diagram

---

![](https://github.com/Patika-Todeb-Java-Spring-Bootcamp/patika-todeb-javaspringbootcamp-proje-odevleri-gulbalasalamov/blob/master/docs/use-case-diagram-draft.png)

---

#### ERD Database Design

---

![](https://github.com/Patika-Todeb-Java-Spring-Bootcamp/patika-todeb-javaspringbootcamp-proje-odevleri-gulbalasalamov/blob/master/docs/entity-relationship-diagram-draft.png)

---
