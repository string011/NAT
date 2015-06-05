#Snack Food JVM Nerdery Assessment Test

This project contains example code which can be used as the basis for the JVM Nerdery Assessment Test (NAT). It does not implement any of the functional requirements of the NAT, and is instead intended to save you time "bootstrapping" the project. It also contains example code that shows how basic web  operations can be performed using the included framework.

**Note**: You are not required to use this base project. If you prefer another framework or project structure, you should feel free to start from scratch. A different architecture of equivalent quality will not be scored any differently. *If you use an alternate framework / architecture, make sure to document how it can be deployed easily and reliably.* A project that can't be tested will not be scored well.

##Base Project Architecture
* **Language**: Java 8
* **Build System**: Gradle
* **Web Framework**: Spring Boot
* **Data Persistence**: Spring Data JPA (H2 for development, MySQL for Production)
* **JSON**: Jackson
* **View Templates**: Freemarker

##Folder Structure
* `src/main/java` - Source code for the web application
* `src/main/resources` - Resources that will be included in the web application
* `test/java` - Unit tests
* `web` - Static HTML / CSS and assets that can be converted to templates for use in the project. You are not required to use these, but it is a good way to save time.