FROM openjdk:12-ea-25-jdk-alpine3.8

# overwrite w/ 'json' to log in JSON format
ENV SPRING_PROFILES_ACTIVE=plain

COPY target/logging-test-driver-spring-boot-*.jar /app.jar

CMD ["java","-jar","/app.jar"]