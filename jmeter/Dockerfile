FROM openjdk:8-jdk

ARG JMETER_VERSION="5.1.1"
ARG JMETER_INFLUXDB_WRITER_VERSION="1.0"
ENV JMETER_INFLUXDB_WRITER_JAR="JMeter-InfluxDB-Writer-${JMETER_INFLUXDB_WRITER_VERSION}.jar"
ENV	JMETER_DOWNLOAD_URL https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-${JMETER_VERSION}.tgz
ENV JMETER_INFLUXDB_WRITER_LIB_URL https://github.com/NovatecConsulting/JMeter-InfluxDB-Writer/releases/download/v-${JMETER_INFLUXDB_WRITER_VERSION}/${JMETER_INFLUXDB_WRITER_JAR}
ENV JMETER_HOME /opt/apache-jmeter-${JMETER_VERSION}
ENV	JMETER_BIN	${JMETER_HOME}/bin
ENV TEST_PLAN_FOLDER /tmp/test

RUN mkdir -p /tmp/binaries \
    && curl -L --silent ${JMETER_DOWNLOAD_URL} > /tmp/binaries/apache-jmeter-${JMETER_VERSION}.tgz \
    && curl -L --silent ${JMETER_INFLUXDB_WRITER_LIB_URL} > /tmp/binaries/${JMETER_INFLUXDB_WRITER_JAR} \
    && mkdir -p /opt \
    && tar -xzf /tmp/binaries/apache-jmeter-${JMETER_VERSION}.tgz -C /opt \
    && cp /tmp/binaries/${JMETER_INFLUXDB_WRITER_JAR} ${JMETER_HOME}/lib/ext/${JMETER_INFLUXDB_WRITER_JAR} \
    && rm -rf /tmp/binaries

RUN ls -al ${JMETER_HOME}/lib/ext/JMeter-InfluxDB-Writer-1.0.jar

ENV PATH $PATH:$JMETER_BIN

WORKDIR	${JMETER_HOME}
