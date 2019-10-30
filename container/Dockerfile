FROM openjdk:11-jdk

ENV DEPLOYMENT_DIR /system-info

RUN mkdir -p $DEPLOYMENT_DIR

COPY ../build/libs/system-info-0.0.1-SNAPSHOT.jar $DEPLOYMENT_DIR

EXPOSE 8080

CMD ["java", "-jar", "/system-info/system-info-0.0.1-SNAPSHOT.jar"]

