# Middleware_Project_A

## Description - Library

It is necessary to design and implement a central information system for libraries designed for
book registration. Such a system registers libraries, publishing houses, books and authors.
Authors have contracts with several publishing houses for which they write books. Publishing
houses publish these books. A book can have several authors and is published by just one
publishing house. There can be a maximum of 5 identical books in a library.
The library has a name, address and ownership of the book.
The book has a unique ISBN identifier. When inserting a new book into the system, it is
necessary to verify that its ISBN is not yet included in the system and that the specified author
has a contract with the specified publishing house. The book also has the title, authors,
publisher, publication date, genre, etc.
The publishing house has a name, address, authors with whom it has a contract, and published
books.
The author has a name, surname, e-mail, books written, publishing house with which he has a
contract, etc.

## Colaborators : 

- Paulin Zumstein
- Luca Deslot
- Samuel Ohayon
- Dylan Pereira

## Tasks done : 

- Analyze the task and create a class diagram.
  
- According to the design, implement the ORM in Java (choose the technology yourself:
  hibernate, etc.).
  - Use lombok for easy getters, setters , constructors etc.
  - In your project use M:N cardinality:
  - Find out what the fetch and mappedBy parameters mean
- Implement DAO layer and CRUD.
  
- Describe the following three services using a sequence diagram:
  - The author concludes a contract with the publishing house.
  - The publishing house will publish a new book.
  - Adding a book to the library
  
- Implement the services layer, according to sequence diagrams.
  
- Test service layer of application:
  - unit tests
  
- Create an import.sql file in the resources folder. Create test data here.

## Tasks not done :


  
- Add actuator

- Add Springfox for generating swagger specification:
  
- Add javadoc
  
- Add Micrometer for metrics
  
- For DTO layer use mapstruct maping between BO and DTO:
