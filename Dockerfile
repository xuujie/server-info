FROM openjdk:8-jdk

ENV DEPLOYMENT_DIR /server-info

RUN mkdir -p $DEPLOYMENT_DIR

COPY build/libs/server-info-0.0.1-SNAPSHOT.jar $DEPLOYMENT_DIR

EXPOSE 8080

CMD ["java", "-jar", "/server-info/server-info-0.0.1-SNAPSHOT.jar"]

