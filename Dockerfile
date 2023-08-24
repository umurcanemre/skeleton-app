FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
COPY build/libs/skeleton-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]