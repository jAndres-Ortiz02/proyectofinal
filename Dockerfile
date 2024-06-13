FROM openjdk:17-jdk-alpine
WORKDIR /aplicacion
COPY proyectofinal-0.0.1-SNAPSHOT.jar /aplicacion/proyectofinal-0.0.1-SNAPSHOT.jar
EXPOSE 9094
ENTRYPOINT ["java","-jar","/aplicacion/proyectofinal-0.0.1-SNAPSHOT.jar"]
