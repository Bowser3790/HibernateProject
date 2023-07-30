

Welcome to the Hibernate Project! This project demonstrates the use of Hibernate, an Object-Relational Mapping (ORM) 
framework, to interact with a database and perform CRUD (Create, Read, Update, Delete) operations on various entities.


## Introduction

Hibernate is a popular ORM tool that simplifies the interaction between Java applications and relational databases. 
In this project, you'll find different packages representing various Hibernate-related features and entities.

## Project Structure

The project directory has the following structure:

- `src/main/java`: The main Java source code directory contains different packages representing Hibernate features:

    - `hb01/annotation`: This package demonstrates basic Hibernate operations using annotations.

        - `RunnerFetch01.class`: A class for fetching data from the database using annotations.

        - `RunnerSave01.class`: A class for saving data to the database using annotations.

        - `Student01.class`: A model class representing the Student entity with annotations.

    - `hb02/embeddable`: This package showcases embedding objects using Hibernate.

        - `Address.class`: A model class representing an embeddable Address object.

        - `RunnerFetch02.class`: A class for fetching data using embedded objects.

        - `RunnerSave02.class`: A class for saving data with embedded objects.

        - `Student02.class`: A model class representing the Student entity with an embedded Address.

    - `hb03/oneToOne`: This package demonstrates the one-to-one relationship in Hibernate.

        - `Diary.class`: A model class representing the Diary entity.

        - `RunnerFetch03.class`: A class for fetching data using one-to-one relationships.

        - `RunnerSave03.class`: A class for saving data with one-to-one relationships.

        - `Student03.class`: A model class representing the Student entity with a one-to-one relationship to Diary.

    - `hb05/uni_ManyToOne`: This package showcases the unidirectional many-to-one relationship in Hibernate.

        - `RunnerFetch05.class`: A class for fetching data using unidirectional many-to-one relationships.

        - `RunnerSave05.class`: A class for saving data with unidirectional many-to-one relationships.

        - `Student05.class`: A model class representing the Student entity.

        - `University.class`: A model class representing the University entity.

- `resources`: The resources directory contains configuration files related to Hibernate.

    - `Hibernate.cfg.xml`: The Hibernate configuration file specifying database connection details and other settings.

- `target/classes`: This directory contains the compiled class files after building the project. It's created automatically when you build the project using Maven.

- `pom.xml`: The POM (Project Object Model) is an XML file that defines the project's configuration and dependencies. It's used by the Maven build tool to manage the project.


I hope this Hibernate Project helps you understand Hibernate's capabilities and how it simplifies database interactions in Java. If you have any questions or need further assistance, feel free to reach out through GitHub issues.

Happy coding and enjoy exploring Hibernate!
