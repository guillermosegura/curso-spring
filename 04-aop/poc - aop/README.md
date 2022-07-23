## Spring + AOP

#### AOP

1. Before
   - [Before](src/main/resources/beans-before-aspect.xml)
   - [Before con parámetros](src/main/resources/beans-before-params-aspect.xml)
   
2. After
   - [After](src/main/resources/beans-after-aspect.xml)
   - [After con parámetros](src/main/resources/beans-after-params-aspect.xml)
   
3. After return
   - [After return](src/main/resources/beans-after-return-aspect.xml)
   - [After return con parámetros](src/main/resources/beans-after-return-params-aspect.xml)
   
4. After throw
   - [After throw](src/main/resources/beans-after-throwing-aspect.xml)
   - [After throw con parámetros](src/main/resources/beans-after-throwing-params-aspect.xml)
   
5. Around
   - [Around](src/main/resources/beans-around-aspect.xml)
   - [Around con parámetros](src/main/resources/beans-around-params-aspect.xml)
   
6. Interceptor   
   - [Intercept](src/main/resources/beans-intercept-aspect.xml)
   - [Anotación](src/main/java/mx/com/axity/poc/aop/Intercept.java)
   - [Clase](src/main/java/mx/com/axity/poc/service/impl/SimpleServiceImpl.java)
     
#### Requisitos:
- Java 11 [Open JDK11](https://jdk.java.net/java-se-ri/11)
- Maven 3.8.1+ [Maven](https://maven.apache.org/download.cgi)
- Spring 5.3.21 [Spring] (https://spring.io/projects/spring-framework)