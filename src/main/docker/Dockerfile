FROM openjdk:8-jdk

MAINTAINER Hylke Stapersma

RUN mkdir -p /app
WORKDIR /app

ADD ${project.name}-${project.version}.jar kafka-admin-rest-api-fat.jar

# UDP Port
EXPOSE 8080

CMD ["java","-jar", "kafka-admin-rest-api-fat.jar"]