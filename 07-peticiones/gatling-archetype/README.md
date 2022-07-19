Integrando gatling con maven (gatling-maven-plugin-demo)
========================================================

Requisitos:

- Open JDK 11 ó 17
- Maven 3.5+
- Scala 2.12.14

Para invocar la grabadora:
    $ mvn gatling:recorder

Ejecutar sólo una clase de pruebas 
    $ mvn clean gatling:test -Dgatling.simulationClass=Recorder

Ejecutar toda la suite de pruebas:
    $mvn gatling:test


