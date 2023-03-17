FROM openjdk:17-jdk-alpine

COPY src/main/docker/ReservationBack-0.0.1-SNAPSHOT.jar reservationback.jar
#COPY src/target/ReservationBack-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java" , "-jar", "/reservationback.jar"]
#ENTRYPOINT ["java" , "-jar", "/ReservationBack-0.0.1-SNAPSHOT.jar"]