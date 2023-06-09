FROM amazoncorretto:17-alpine3.17-jdk
COPY target/artifacts/backend_jar/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]