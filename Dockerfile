FROM openjdk:8-jdk

ENV DEPLOYMENT_DIR /host-info

RUN mkdir -p $DEPLOYMENT_DIR

COPY build/libs/host-info-0.0.1-SNAPSHOT.jar $DEPLOYMENT_DIR

EXPOSE 8080

CMD ["java", "-jar", "/host-info/host-info-0.0.1-SNAPSHOT.jar"]

