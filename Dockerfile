FROM openjdk:17-jdk-slim

EXPOSE 8080

ADD build/libs/jebal-0.0.1-SNAPSHOT.jar jebal-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","jebal-0.0.1-SNAPSHOT.jar"]
