## Guess The Number Game
1. It is a project to become better familiar with the Spring Framework.
2. This project implements a number guessing game.
3. The project includes the following:
    1. Maven: used to build the project and manage dependencies.
    2. Utilizes Dependency Injection with the Spring Container using the ApplicationContext class, which is based on the BeanFactory interface.
    3. Utilizes AOP with Logback to trace the Spring framework.
    4. Thymeleaf
       1. Interact view with Spring 
    
## Details
1. The parent module shares the pom.xml file configuration with submodules.
2. Config classes can use the @Import tag to import other config classes.