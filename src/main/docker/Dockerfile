FROM openjdk:21-jdk
LABEL authors="thomasengels"
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar


ENTRYPOINT ["java", "-jar", "application.jar"]
