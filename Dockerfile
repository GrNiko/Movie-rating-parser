FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} parser.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/parser.jar"]
